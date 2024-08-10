package com.stou;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.model.StudentData;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Student toUpdateStudent;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    // handle POST request
		String student_id = request.getParameter("id");
		String student_name = request.getParameter("name");
		String login_name = request.getParameter("login");
		String password = request.getParameter("password");
		
		// check null or empty condition
		
		if (student_id.isEmpty() || student_name.isEmpty() || login_name.isEmpty() || password.isEmpty()) {
			request.setAttribute("register_result", "failed");
			System.out.println("failed register");
		} else {
			toUpdateStudent = new Student(student_id, student_name, login_name, password);
			StudentData.addStudent(toUpdateStudent);
			StudentData.registeredStudent(); // back-end : real-time log			
			
			request.setAttribute("register_result", "success");
			System.out.println("success register");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("signup.jsp");
		dispatcher.forward(request, response);
		
	}
}
