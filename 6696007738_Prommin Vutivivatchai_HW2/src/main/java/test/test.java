package test;

import com.model.CourseData;
import com.stou.Course;
import java.util.Set;

public class test {
	public static void main(String[] args) {
		Set<Course> searched_set = CourseData.searchByCourseName("web");
		if (searched_set.isEmpty()) {
			System.out.println("No match course");
		} else {
			System.out.println("Mathced course(s) : ");
			for (Course course : searched_set) {
				System.out.println(course);
			}
		}
	}
}
