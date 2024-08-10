<!DOCTYPE html>
<%@ page import="com.stou.Student" %>

<html>
<head>
	<meta charset="UTF-8">
	<title>STOU Online School Login</title>
	<script>
		function redirectTrigger() {
			setTimeout(function () {
	      	window.location.href = "indexLoggedIn.jsp";
	   		}, 3000);
		}
	</script>
</head>
<body>
	<form action="LoginServlet" method="post">
		<h1>Student Login</h1>
		<p>Login <input type="text" name="login"></p>
		<p>Password <input type="password" name="password"></p>
		<button type="submit" value="Login">Login</button>
	</form>
	
	<%
		String login_case = (String)request.getAttribute("login_case");
		if (login_case != null) {
			if (login_case.equals("failed_wrongPassword")) {
				out.println("<h4>Failed to login : Wrong Password</h4>");
			} else if (login_case.equals("failed_notFoundUser")) {
				out.println("<h4>Failed to login : Not Found Login Name</h4>");
			} else {
				if (login_case.equals("success")) {
					Student student = (Student)session.getAttribute("userInstance");
					String fullname = student.getStudentName();
					out.println("<h4>Welcome, " + fullname + " to STOU Online School.</h4>");
					out.println("Redirect in 3 seconds...");
					out.println("<script>redirectTrigger();</script>");	
				} else {
					System.out.println("Abnormal Condition in Login Flow");
				}
			}
		}

	%>
</body>
</html>