package test;

import java.util.List;

import dao.SearchDAO;
import model.Account;
public class SearchDAOTest {

	public static void main(String[] args) {
		testExecute1();
		testExecute2();

	}

	public static void testExecute1() {
		SearchDAO dao = new SearchDAO();
		List<Account> list = dao.searchByUserIdOrName("mina");
		try {
		for(Account account:list) {
			System.out.println(account.getUserId());
			System.out.println(account.getMail());
		}

		} catch (NullPointerException e) {
			//e.printStackTrace();
			System.out.println("見つかりません");
		}

	}
	public static void testExecute2() {
		SearchDAO dao = new SearchDAO();
		List<Account> list = dao.searchByUserIdOrName("sana");
		try {
			for(Account account:list) {
				System.out.println(account.getUserId());
				System.out.println(account.getMail());
			}
		} catch(NullPointerException e) {
			System.out.println("見つかりません");
		}
	}

}
