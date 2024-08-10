package com.stou;
import java.io.*;
import java.util.Set;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.model.CourseData;
import com.model.EnrollData;

@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    // handle GET request
//		System.out.println("get request success");
		
		String enroll_student_id = request.getParameter("studentid");
		String enroll_course_id = request.getParameter("courseid");
		
		if (enroll_student_id.isEmpty() || enroll_course_id.isEmpty()) {
			request.setAttribute("enroll_case", "enroll_failed_empty");
		
			System.out.println("Enroll Failed : Empty Input");
		} else {
			if (CourseData.searchByCourseID(enroll_course_id) == null) {
				request.setAttribute("enroll_case", "enroll_failed_notFoundCourse");
				
				System.out.println("Enroll Failed: Not Found Course");
			} else {
				Enrollment enrollRequest = new Enrollment(enroll_student_id, enroll_course_id);
				System.out.println(enrollRequest);
				
				
				Set<Enrollment> enrollHistory = EnrollData.getEnrollmentByStudentID(enroll_student_id);
				
				if (enrollHistory == null) { 
					// enroll new student 
					System.out.println("Begin : Enroll new student");
					EnrollData.addEnrollment(enrollRequest);
					
					request.setAttribute("enroll_case", "enroll_success");
				} else {
					boolean repeat_enroll = false;

					// check repeating in enrollment of current student (existing student)
					for (Enrollment enrolled : enrollHistory) {
						if (enrolled.getEnrollCourseID().equals(enroll_course_id)) {
							repeat_enroll = true;
						} 
					}
					
					if (repeat_enroll) {
						System.out.println("Enroll failed : Repeat enrollment");
						
						request.setAttribute("enroll_case", "enroll_failed_repeat");
					} else {
						System.out.println("Begin : Enroll in existing student id");
						EnrollData.addEnrollment(enrollRequest);
						
						request.setAttribute("enroll_case", "enroll_success");
					}
				}

	
				//request.setAttribute("enroll_case", "enroll_success");
				EnrollData.listEnrollment();
				System.out.println("----------------------------------------------");
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("enroll.jsp");
		dispatcher.forward(request, response);
	}
}
