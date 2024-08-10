package com.stou;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.model.StudentData;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login_load = request.getParameter("login");
		String password_load = request.getParameter("password");
		System.out.println("login_load: " + login_load);
		System.out.println("password_load: " + password_load);
		System.out.println("------------------------------------");
/* debug		
		for (String ele: StudentData.getStudentLoginList()) {
			System.out.println(ele);
		}
		
		for (String ele: StudentData.getStudentPasswordList()) {
			System.out.println(ele);
		}
*/
		HttpSession session = request.getSession(true);
		if (StudentData.getStudentLoginList().contains(login_load)) {
//			System.out.println("check login: " + StudentData.getStudentLoginList().contains(login_load));
			String password_valid = StudentData.getStudentByLoginname(login_load).getPassword();
//			System.out.println("password_valid: " + password_valid);
//			System.out.println("password_load: " + password_load);
			if (password_load.equals(password_valid)) {
//				System.out.println("Login complete" + " Welcome " + StudentData.getStudentByLoginname(login_load).getStudentName());
				
				// create session and set attribute for this user session
				session.setAttribute("login_status", "login");
				session.setAttribute("userInstance", StudentData.getStudentByLoginname(login_load));
				
				request.setAttribute("login_case", "success");
			} else {
				request.setAttribute("login_case", "failed_wrongPassword");
			}
		} else {
			request.setAttribute("login_case", "failed_notFoundUser");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);

	}
}
