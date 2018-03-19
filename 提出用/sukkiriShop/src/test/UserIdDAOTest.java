package test;

import dao.UserIdDAO;
public class UserIdDAOTest {

	public static void main(String[] args) {
		testexecute1();
		testexecute2();

	}

	public static void testexecute1() {
		UserIdDAO dao = new UserIdDAO();
		boolean result = dao.searchByUserId("minato");
		System.out.println("testexecute1:"+result);

	}
	public static void testexecute2() {
		UserIdDAO dao = new UserIdDAO();
		boolean result = dao.searchByUserId("sanako");
		System.out.println("testexecute2:"+result);
	}
}
