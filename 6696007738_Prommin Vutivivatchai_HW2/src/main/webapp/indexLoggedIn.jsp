<!DOCTYPE html>
<%@page import="com.stou.Student" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>STOU Online School</title>
	<style>
		.navbar{
			display: flex;
			justify-content: center;
		}
		.navbar a, .navbar span{
			padding: 20px;
			text-decoration: none;
			color: black;
		}
		.navbar a:hover {
			background-color: dimgray;
			color: white;
		}
	</style>
</head>
<body>
	<h1 align="center">STOU Online School</h1>
	<div class="navbar">
		<span>
			<% 
				Student userInstance = (Student)session.getAttribute("userInstance");
				String fullname = userInstance.getStudentName();
				out.println("Welcome, "+ fullname);
			%>
		</span> 
		<a href="profile.jsp">Profile</a>
		<a href="search.jsp">Search</a>
		<a href="enroll.jsp">Enroll</a>
		<a href="logout.jsp">Logout</a>
	</div>
</body>
</html>