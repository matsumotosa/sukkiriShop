package test;

import dao.RegistrationDAO;
import model.Account;
public class RegistrationDAOTest {

	public static void main(String[] args) {

		//testExecute1();
		//testExecute2();

	}

	public static void testExecute1() {
		Account account = new Account("matsuto", "sss", "mail@sanae.com", "sanae", 35);
		RegistrationDAO registration = new RegistrationDAO();
		System.out.println(registration.insertAccountByInput(account));

	}

	public static void testExecute2() {
		Account account = new Account("mato", "aaa", "maillll", "sanako", 35);
		RegistrationDAO registration = new RegistrationDAO();
		System.out.println(registration.insertAccountByInput(account));
	}
}
