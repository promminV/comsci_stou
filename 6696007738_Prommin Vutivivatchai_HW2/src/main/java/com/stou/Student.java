package com.stou;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Student {
	private String student_id;
	private String student_name;
	private String login_name;
	private String password;
	private LocalDateTime register_date;
	
	// sharing value for all instances
	final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	final static String DEFAULT_STUDENT_ID = "default_student_id";
	final static String DEFAULT_STUDENT_NAME = "default_student_name";
	final static String DEFAULT_LOGIN_NAME = "default_login";
	final static String DEFAULT_PASSWORD = "default_password";

	// constructor
	public Student() {
		this.student_id = DEFAULT_STUDENT_ID;
		this.student_name = DEFAULT_STUDENT_NAME;
		this.login_name = DEFAULT_LOGIN_NAME;
		this.password = DEFAULT_PASSWORD;
		this.register_date = LocalDateTime.now();
	}

	public Student(String student_id, String student_name, String login_name, String password) {
		this.student_id = student_id;
		this.student_name = student_name;
		this.login_name = login_name;
		this.password = password;
		this.register_date = LocalDateTime.now();
	}
	
	
	// setter
	public void setStudentID(String student_id) {
		this.student_id = student_id;
	}
	
	public void setStudentName(String student_name) {
		this.student_name = student_name;
	}
	
	public void setLoginName(String login_name) {
		this.login_name = login_name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	// getter
	public String getStudentID() {
		return this.student_id;
	}
	
	public String getStudentName() {
		return this.student_name;
	}
	
	public String getLoginName() {
		return this.login_name;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getRegisterDateTime() {
		return this.register_date.format(formatter);
	}
	
	@Override
	public String toString() {
		return getStudentID() + "  " +
				getStudentName() + "  " +
				getLoginName() + "  " +
				getPassword() +  "  " +
				getRegisterDateTime();
	}
	
}
