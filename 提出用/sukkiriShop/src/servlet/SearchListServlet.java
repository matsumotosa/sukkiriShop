package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SearchDAO;
import model.Account;
/**
 * Servlet implementation class SearchListServlet
 */
@WebServlet("/SearchListServlet")
public class SearchListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// サーチワードを取得し、リクエストスコープに保存する
		request.setCharacterEncoding("UTF-8");
		String searchStr = request.getParameter("searchStr");
		request.setAttribute("searchStr", searchStr);

		//サーチワードでデータベースを検索し、アカウントを取得する
		SearchDAO sDao = new SearchDAO();
		List<Account> accountList = sDao.searchByUserIdOrName(searchStr);

		//ヒットしたデータをリクエストスコープに保存する
		request.setAttribute("accountList", accountList);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/searchList.jsp");
		dispatcher.forward(request, response);



	}

}
