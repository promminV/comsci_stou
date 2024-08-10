package com.stou;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Enrollment {
	private String enroll_studentID;
	private String enroll_courseID;
	private LocalDateTime enroll_date;
	
	final static LocalDateTime DEFAULT_DATE = LocalDateTime.now();
	final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	// constructor
	public Enrollment() {
		this.enroll_date = DEFAULT_DATE;
	}
	
	public Enrollment(String enroll_studentID, String enroll_courseID) {
		this.enroll_studentID = enroll_studentID;
		this.enroll_courseID = enroll_courseID;
		this.enroll_date = LocalDateTime.now();
	}
	// setter
	public void setEnrollStudent(String enroll_studentID) {
		this.enroll_studentID = enroll_studentID;
	}
	
	public void setEnrollCourse(String enroll_courseID) {
		this.enroll_courseID = enroll_courseID;
	}
	
	// getter
	public String getEnrollStudentID() {
		return this.enroll_studentID;
	}
	
	public String getEnrollCourseID() {
		return this.enroll_courseID;
	}
	
	public String getEnrollDate() {
		return this.enroll_date.format(formatter);
	}
	
	@Override
	public String toString() {
		return getEnrollStudentID() + "  " +
				getEnrollCourseID() + "  " +
				getEnrollDate();
	}

	
}
