package test;

import model.Input;
import model.InputCheck;

public class InputCheckTest {

	public static void main(String[] args) {

		testExcute1();
		testExcute2();


	}

	public static void testExcute1() {
		InputCheck ic = new InputCheck();
		Input input = ic.check("matumoto", "aksks", "sanae1@sane.jp", "sanae", "35");
		if(input != null) {
			System.out.println(input.getUserIdCheck());
			System.out.println(input.getPassCheck());
			System.out.println(input.getMailCheck());
			System.out.println(input.getNameCheck());
			System.out.println(input.getAgeCheck());
		}
	}
	public static void testExcute2() {
		InputCheck ic =new InputCheck();
		Input input = ic.check("mmmmmmmmatumoto", "@@@@@@@@@@@@", "0[[[[[[[[[", "さなえ", "35");

		if(input != null) {
			System.out.println(input.getUserIdCheck());
			System.out.println(input.getPassCheck());
			System.out.println(input.getMailCheck());
			System.out.println(input.getNameCheck());
			System.out.println(input.getAgeCheck());

		}
	}
}
