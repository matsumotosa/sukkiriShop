package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegistrationDAO;
import dao.UserIdDAO;
import model.Account;
import model.Input;
import model.InputCheck;



/**
 * Servlet implementation class UserRegistrationServlet
 */
@WebServlet("/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userRegistration.jsp");
		dispatcher.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//POSTリクエストを変数に代入
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		int iAge = -1;


		//入力項目をチェック
		InputCheck ic = new InputCheck();
		Input input = ic.check(userId, pass, mail, name, age);

		//重複userIdをチェック
		UserIdDAO uDao = new UserIdDAO();
		boolean result = uDao.searchByUserId(userId);


			if(result) { //userIdが重複しているとき
			String s = "ユーザーネームが重複しています";
				if(input == null) {
					input = new Input();
				}

			input.setUserIdCheck(s);
			}

		//POSTデータをリクエストスコープに保存
		try {
			iAge = Integer.parseInt(request.getParameter("age"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		Account account = new Account(userId, pass, mail, name, iAge);
		request.setAttribute("account", account);

		if(input == null) { //入力に誤りがない場合

			//アカウントをデータベースに保存

			RegistrationDAO registration = new RegistrationDAO();
			boolean rDao = registration.insertAccountByInput(account);

			if(rDao) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registrationOK.jsp");
				dispatcher.forward(request, response);
			}

		} else { //入力項目に誤りアリのとき
			//エラー文をリクエストスコープに保存
			request.setAttribute("input", input);

			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registrationNG.jsp");
			dispatcher.forward(request, response);
		}
	}

}
