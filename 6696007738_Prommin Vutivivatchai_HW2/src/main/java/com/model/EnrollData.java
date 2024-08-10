package com.model;
import com.stou.Enrollment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class EnrollData {
	private static HashMap<String, Set<Enrollment>> enrollList = new HashMap<String, Set<Enrollment>>();
	
	public static void listEnrollment() { // for-debug
		System.out.println("Enrollment Logs");
		Set<String> keys = enrollList.keySet();
		for (String key : keys) {
			System.out.println("key: " + key + " enroll: " + enrollList.get(key));
		}
		System.out.println("----------------------------");
	}

	public static void addEnrollment(Enrollment enroll) {
		System.out.println("Begin addEnrollment()");
		System.out.println(enrollList.keySet().isEmpty()); 
		Set<String> exist_student_id_set = enrollList.keySet();		
		System.out.println(exist_student_id_set);
		
		if (enrollList.keySet().isEmpty()) { // check if it's first time of enrollment in this system
			System.out.println("First time enroll in the system.");
			Set<Enrollment> new_enroll_set = new HashSet<Enrollment>();
			new_enroll_set.add(enroll);
			enrollList.put(enroll.getEnrollStudentID(), new_enroll_set);
			System.out.println("Enroll complete.");
		} else {
			System.out.println("It's not first time enrollment in the system.");				
				// check that new or old student
				if (exist_student_id_set.contains(enroll.getEnrollStudentID())) {
					Set<Enrollment> retrieve_enroll_set = enrollList.get(enroll.getEnrollStudentID());
					retrieve_enroll_set.add(enroll);
						
					System.out.println("Enroll success in case 1: Insert new enrollment to existing id.");
				} else {
					Set<Enrollment> new_enroll_set = new HashSet<Enrollment>();
					new_enroll_set.add(enroll);
					enrollList.put(enroll.getEnrollStudentID(), new_enroll_set);
					
					System.out.println("Enroll success in case 2: Insert new student id and new enrollment.");
				} 
			}
		}
	
	public static Set<Enrollment> getEnrollmentByStudentID(String student_id) {
		return enrollList.get(student_id);
	}
	
	public static String getEnrolledCourseName(String student_id) {
		String enrolled_course_name = "";
		Set<Enrollment> enrollment= EnrollData.getEnrollmentByStudentID(student_id);
		if (enrollment == null) {
			enrolled_course_name = "No enrolled course";
		} else {
			Set<String> courseid_enrolled_set = new HashSet<String>();
			for (Enrollment enroll_instance : enrollment) {
				courseid_enrolled_set.add(enroll_instance.getEnrollCourseID()); 
			}
			
			int count=1;
			for (String course : courseid_enrolled_set) {
				int size = courseid_enrolled_set.size();
				String course_name = CourseData.searchByCourseID(course).getCourseName();
				if (count == size) {
					enrolled_course_name += course_name;
				} else {
					enrolled_course_name += course_name + ", ";
				}
				count+=1;
				
				System.out.println(enrolled_course_name);
			}
		}
		return enrolled_course_name;
	}
	
	
	
	public static Set<String> getEnrolledStudentID() {
		return enrollList.keySet();
	}
}
