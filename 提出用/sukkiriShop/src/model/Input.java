package model;

public class Input {

	private String userIdCheck;
	private String passCheck;
	private String mailCheck;
	private String nameCheck;
	private String ageCheck;

	public Input() {};

	public Input(String userIdCheck, String passCheck,
			String mailCheck, String nameCheck, String ageCheck) {

		this.userIdCheck = userIdCheck;
		this.passCheck = passCheck;
		this.mailCheck = mailCheck;
		this.nameCheck = nameCheck;
		this.ageCheck = ageCheck;

	}

	public String getUserIdCheck() {
		return userIdCheck;
	}

	public String getPassCheck() {
		return passCheck;
	}

	public String getMailCheck() {
		return mailCheck;
	}

	public String getNameCheck() {
		return nameCheck;
	}

	public String getAgeCheck() {
		return ageCheck;
	}

	public void setUserIdCheck(String userIdCheck) {
		this.userIdCheck = userIdCheck;
	}

}
