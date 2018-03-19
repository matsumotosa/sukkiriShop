package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserIdDAO {

	public boolean searchByUserId(String userId) {

		Connection conn = null;

		try {
			//ドライバーを読み込む
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/sukkiriShop", "sa", "");

			//SQL文の準備をする
			String sql = "SELECT USER_ID FROM ACCOUNT WHERE USER_ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userId);

			//SELECT文を実行して結果を取得
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				return (userId.equals(rs.getString("USER_ID")));
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

		return false;
	}

}
