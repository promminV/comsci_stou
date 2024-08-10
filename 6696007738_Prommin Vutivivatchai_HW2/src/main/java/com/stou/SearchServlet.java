package com.stou;
import java.io.*;
import java.util.Set;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.model.CourseData;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("success get request");
		
		String course_name = request.getParameter("coursesearch");
		System.out.println("searching... : " + course_name);
		
		Set<Course> searched_course_set = CourseData.searchByCourseName(course_name);
		System.out.println("found course(s): " + searched_course_set);
		
		HttpSession session = request.getSession(false);
		session.setAttribute("searched_course_set", searched_course_set);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
		dispatcher.forward(request, response);
	}
}
