<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>STOU Online School Signup</title>
	<script>
		function redirectTrigger() {
			setTimeout(function () {
	      	window.location.href = "index.html";
	   		}, 3000);
		}
	</script>
</head>
<body>
	<form action="SignupServlet" method="post">
		<h1>Student Registration</h1>
		<p>ID <input type="text" name="id"></p>
		<p>Name <input type="text" name="name"></p>
		<p>Loginname <input type="text" name="login"></p>
		<p>Password <input type="password" name="password"></p>
		<button type="submit" value="Register">Register</button>
	</form>
	<% 
		String register_result = (String)request.getAttribute("register_result");
		if (register_result != null) {
			if (register_result.equals("failed")) {
				out.println("<h4>Registration failed, please try again</h4>");
			} else if (register_result.equals("success")) {
				out.println("<h4>Registration complete.</h4> Redirect to first page in 3 seconds...");
				out.println("<script>redirectTrigger();</script>");
			}
		}
	%>	
</body>
</html>