<!DOCTYPE html>
<%@ page import = "com.stou.Student" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>STOU Online School Enrollment</title>
	<script>
		function redirectTrigger() {
			setTimeout(function() {
				window.location.href = "index.html";
			}, 3000);
		}
	</script>
</head>
<body>
	<% 
		String login_status = (String)session.getAttribute("login_status");
		if (login_status == null) {
			out.println("<h4>Please log in before enter to this service.</h4> Redirect in 3 seconds...");
			out.println("<script>redirectTrigger()</script>");
		} else {
	%>
			<form action="EnrollServlet" method="get">
				<h1>Enrollment</h1>
				<% 
					Student userInstance = (Student)session.getAttribute("userInstance");
					String student_id = userInstance.getStudentID();
				%>
				<p>Student ID <input type="text" name="studentid" value="<%= student_id %>"></p>
				<p>Course ID <input type="text" name="courseid"></p>
				<button type="submit" value="Enroll">Enroll</button>
			</form>	
	<%
			String enroll_case = (String)request.getAttribute("enroll_case");
			if (enroll_case != null) {
				if (enroll_case.equals("enroll_failed_empty")) {
					out.println("<h4>Enroll Failed : Empty Input</h4>");
				} else if (enroll_case.equals("enroll_failed_notFoundCourse")) {
					out.println("<h4>Enroll Failed : Input course is not found in the system.</h4>");
				} else if (enroll_case.equals("enroll_failed_repeat")) {
					out.println("<h4>Enroll Failed : Repeat enroll course</h4>");
				} else {
					if (enroll_case.equals("enroll_success")) {
						out.println("<h4>Enroll Success</h4>");
					}
					else {
						System.out.println("Abnormal Condition in Enroll Flow");
					}
				} 
			}
		}
	%>
</body>
</html>