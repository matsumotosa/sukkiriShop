package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Account;

public class SearchDAO {

	public List<Account> searchByUserIdOrName (String searchWord) {

		Connection conn = null;
		List<Account> accountList = null;

		try {
			//ドライバーを読み込む
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/sukkiriShop","sa","");

			//UserIdとNameを検索するSQL文を準備する
			String[] sql = {
					"SELECT USER_ID, PASS, MAIL, NAME, AGE FROM ACCOUNT WHERE USER_ID like ?",
					"SELECT USER_ID, PASS, MAIL, NAME, AGE FROM ACCOUNT WHERE NAME like ?"};

			for(String s:sql) {

			PreparedStatement pStmt = conn.prepareStatement(s);
			pStmt.setString(1,'%'+searchWord+'%');

			//SQL文を実行し、結果を取得
			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {
				String userId = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				String mail = rs.getString("MAIL");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");

				Account account = new Account(userId, pass, mail, name, age);
				if(accountList == null) {
					accountList = new ArrayList<Account> ();
				}
				accountList.add(account);
			}


		}
	} catch(SQLException e) {
		e.printStackTrace();
	} catch(ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		if(conn != null) {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}


		return accountList;
	}
}
