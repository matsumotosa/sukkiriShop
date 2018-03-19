package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputCheck {

	//エラー文
	private final String TEXTOVER = "文字数がオーバーしています。";
	private final String TEXTAZ09 = "半角英数字で入力してください。";
	private final String MAILREGIX = "メールの書式で入力してください。";
	private final String AGEREGIX = "半角数字で入力してください。";
	private final String EMPTYTEXT = "文字を入力してください。";


	public Input check(String userId, String pass, String mail, String name, String age){

		//フィールド作成
		String userIdCheck = null;
		String passCheck = null;
		String mailCheck = null;
		String nameCheck = null;
		String ageCheck = null;

		Input input;

		//正規表現で文字列を精査する
		Pattern textRegix = Pattern.compile("^[\\w]+$");
		Pattern mailRegix = Pattern.compile("^[-@+*;:#$%&.\\w]+@[-@+*;:#$%&.\\w]+$");
		Pattern ageRegix = Pattern.compile("^[0-9]+$");

		Matcher mUserId = textRegix.matcher(userId);
		Matcher mPass = textRegix.matcher(pass);
		Matcher mMail = mailRegix.matcher(mail);
		Matcher mAge = ageRegix.matcher(age);


		if(!mUserId.find()) {
			userIdCheck = TEXTAZ09;
		}
		if(!mPass.find()) {
			passCheck = TEXTAZ09;
		}
		if(!mMail.find()) {
			mailCheck = MAILREGIX;
		}
		if(!mAge.find()) {
			ageCheck = AGEREGIX;
		}

		if(userId.length() > 10) {
			userIdCheck = TEXTOVER;
		} else if (userId.length() == 0) {
			userIdCheck = EMPTYTEXT;
		}
		if(pass.length() > 10) {
			passCheck = TEXTOVER;
		} else if (pass.length() == 0) {
			passCheck = EMPTYTEXT;
		}
		if(mail.length() > 40){
			mailCheck = TEXTOVER;
		} else if (mail.length() == 0) {
			mailCheck = EMPTYTEXT;
		}
		if(name.length() > 40){
			nameCheck = TEXTOVER;
		} else if (name.length() == 0) {
			nameCheck = EMPTYTEXT;
		}
		if(age.length() > 10) {
			ageCheck = TEXTOVER;
		} else if (age.length() == 0) {
			ageCheck = EMPTYTEXT;
		}

		 if(userIdCheck != null || passCheck != null || mailCheck != null || nameCheck != null || ageCheck != null) {


		input = new Input(userIdCheck, passCheck, mailCheck, nameCheck, ageCheck);

		return input;

		 } else {
			return null;
		 }

	}

}
