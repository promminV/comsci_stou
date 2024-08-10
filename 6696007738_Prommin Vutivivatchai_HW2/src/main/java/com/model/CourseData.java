package com.model;
import com.stou.Course;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CourseData {
	private static HashMap<String, Course> courses = new HashMap<String, Course>();
	
	
	
	// static initializer block
	static {
		// mock-up course data
		Course dbms = new Course();
		Course compro = new Course();
		Course webpro = new Course();
		Course webdesign = new Course();
		
		dbms.setCourseID("96408");
		dbms.setCourseName("Database Management System");
		dbms.setCourseCredits(6);
		
		compro.setCourseID("96414");
		compro.setCourseName("Computer Programming");
		compro.setCourseCredits(6);
		
		webpro.setCourseID("99420");
		webpro.setCourseName("Web Programming");
		webpro.setCourseCredits(6);
		
		webdesign.setCourseID("99XXX");
		webdesign.setCourseName("Web Designing");
		webdesign.setCourseCredits(6);
		
		CourseData.addCourse(dbms);
		CourseData.addCourse(compro);
		CourseData.addCourse(webpro);
		CourseData.addCourse(webdesign);
	}
	
	// constructor (anybody don't need to create instance of CourseData to access data
	public CourseData() {}
	
	// method of CourseData
	
	// setter
	public static void addCourse(Course course) {
		courses.put(course.getCourseID(), course);
	}
	
	// getter
	public static Set<Course> searchByCourseName(String courseName) {
		Set<Course> searched_course_set = new HashSet<Course>(); // searched items may be more than 1 (similar name of courses)
		courseName = courseName.trim().toLowerCase();
		// for a course instance in courses -> get course name -> compare, if true -> return matched course instance
		for (Course course : courses.values()) {
			String coursename_db = course.getCourseName().trim();
			coursename_db = coursename_db.toLowerCase();
			if (coursename_db.contains(courseName)) {
				searched_course_set.add(course);
			}
		}
		return searched_course_set.isEmpty()? Collections.emptySet(): searched_course_set;
	}
	
	public static Course searchByCourseID(String course_id) {
		return courses.get(course_id);
	}


/*
	public static Set<String> getCourseNameList() {
		Set<String> keys_course_id = courses.keySet();
		Set<String> course_name_list = new HashSet<String>();
		for (String ele : keys_course_id) {
			course_name_list.add(courses.get(ele).getCourseName());
		}
		return course_name_list;
	}
*/	
/*
	public static HashMap<String, Course> getCourseData() {
		return courses;
	}
*/	
}
