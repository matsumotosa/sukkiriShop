package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {

	public Account findByLogin(Login login) {


			Connection conn = null;
			Account account = null;

			try{

				//ドライバーを読み込む
				Class.forName("org.h2.Driver");

				//データベースへ接続
				conn = DriverManager.getConnection(
						"jdbc:h2:file:C:/data/sukkiriShop","sa","");

				//SELECT文を準備
				String sql = "SELECT USER_ID, PASS, MAIL, NAME, AGE FROM ACCOUNT WHERE USER_ID = ? AND PASS = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, login.getUserId());
				pStmt.setString(2, login.getPass());

				//SELECT文を実行し、結果を取得
				ResultSet rs = pStmt.executeQuery();

				if(rs.next()) {
					String userId = rs.getString("USER_ID");
					String pass = rs.getString("PASS");
					String mail = rs.getString("MAIL");
					String name = rs.getString("NAME");
					int age = rs.getInt("AGE");

					account = new Account(userId, pass, mail, name, age);

				}
			} catch(SQLException e) {
				e.printStackTrace();
				return null;
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			} finally {
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			return account;

	}


}
