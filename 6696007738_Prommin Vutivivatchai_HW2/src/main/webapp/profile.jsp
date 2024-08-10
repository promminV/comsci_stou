<!DOCTYPE html>
<%@ page import = "com.stou.Student" %>
<%@ page import = "com.stou.Enrollment" %>
<%@ page import = "com.model.EnrollData" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>STOU Online School Profile</title>
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
		System.out.println(login_status);

		if ((login_status == null)) {
			out.println("<h4>Please log in before enter to this service.</h4> Redirect in 3 seconds...");
			out.println("<script>redirectTrigger();</script>");
		} else {
			Student sessionStudent = (Student)session.getAttribute("userInstance");
			String enroll_course = EnrollData.getEnrolledCourseName(sessionStudent.getStudentID());
			String student_id = sessionStudent.getStudentID();
			String student_name = sessionStudent.getStudentName();
			
			out.println("<p><b>" + student_id + " " + student_name + " Enrolled Course: " + enroll_course + "<b></p>");
		}
	%>
		
</body>
</html>