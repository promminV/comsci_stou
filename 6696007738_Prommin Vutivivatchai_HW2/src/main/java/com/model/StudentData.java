package com.model;
import java.util.*;

import com.stou.Student;

public class StudentData {
	private static HashMap<String, Student> students = new HashMap<String, Student>();
	public StudentData() {}
	
	// setter
	public static void addStudent(Student student) {
		students.put(student.getLoginName(), student); // key: loginname, value: student instance (assume login name is unique)
	}	
	
	// getter	
	public static void registeredStudent() { // for de-bug
		Set<String> keys_id = students.keySet();
		System.out.println("Registered Students: ");
		for(String key: keys_id) {
			System.out.println(key + ": " + students.get(key));
		}
		System.out.println("--------------------------------");
	}
	
	public static Set<String> getStudentLoginList() {
		Set<String> keys_id = students.keySet();
		Set<String> loginlist = new HashSet<String>();
		for(String key: keys_id) {
			loginlist.add(students.get(key).getLoginName());
		}
		return loginlist;
	}
	
	public static Student getStudentByLoginname(String login_load) {
		return students.get(login_load);
	}
}
