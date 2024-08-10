package com.stou;

public class Course {
	private String course_id;
	private String course_name;
	private int course_credits;
	
	final static String DEFAULT_COURSE_ID = null;
	final static String DEFAULT_COURSE_NAME = null;
	final static int DEFAULT_COURSE_CREDITS = 0;
	
	
	public Course() {
		this.course_id = DEFAULT_COURSE_ID;
		this.course_name = DEFAULT_COURSE_NAME;
		this.course_credits = DEFAULT_COURSE_CREDITS;
		
	}
	
	public Course(String course_id, String course_name, int course_credits) {
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_credits = course_credits;
	}
	
	public void setCourseID(String course_id) {
		this.course_id = course_id;
	}
	
	public void setCourseName(String course_name) {
		this.course_name = course_name;
	}
	
	public void setCourseCredits(int course_credits) {
		this.course_credits = course_credits;
	}
	
	public String getCourseID() {
		return this.course_id;
	}
	
	public String getCourseName() {
		return this.course_name;
	}
	
	public int getCourseCredits() {
		return this.course_credits;
	}
	
	
	@Override
	public String toString() {
		return getCourseID() + "  " +
				getCourseName() + "  " +
				getCourseCredits() + " Credits";
	}
}
