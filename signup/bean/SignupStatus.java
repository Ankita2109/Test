package com.cts.signup.bean;

public class SignupStatus {
	private boolean signupStatus;
	private boolean emailExist;
	private String message;

	public SignupStatus(boolean signupStatus, boolean emailExist, String message) {
		super();
		this.signupStatus = signupStatus;
		this.emailExist = emailExist;
		this.message = message;
	}

	public SignupStatus() {
		super();
	}



	public boolean isSignupStatus() {
		return signupStatus;
	}

	public void setSignupStatus(boolean signupStatus) {
		this.signupStatus = signupStatus;
	}

	public boolean isEmailExist() {
		return emailExist;
	}

	public void setEmailExist(boolean emailExist) {
		this.emailExist = emailExist;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SignupStatus [signupStatus=");
		builder.append(signupStatus);
		builder.append(", emailExist=");
		builder.append(emailExist);
		builder.append(", message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}


	
//	public boolean equals(Object o) {
//		SignupStatus s=(SignupStatus) o;
//		return this.signupStatus==s.isSignupStatus() && this.error.equals(s.getError());
//	}
}

