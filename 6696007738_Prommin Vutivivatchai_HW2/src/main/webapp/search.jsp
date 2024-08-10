<!DOCTYPE html>
<%@ page import = "com.stou.Course" %>
<%@ page import = "java.util.Set" %>


<html>
<head>
	<meta charset="UTF-8">
	<title>STOU Online School Course Search</title>
	<script>
		function redirectTrigger() {
			setTimeout(function () {
	      		window.location.href = "index.html";
	   		}, 3000);
		}
	</script>
</head>
<body>
	<%
		String login_status = (String)session.getAttribute("login_status");
		if ((login_status == null)) {
				out.println("<h4>Please log in before enter to this service.</h4> Redirect in 3 seconds...");
				out.println("<script>redirectTrigger()</script>");
		} else {
	%>
				<form action="SearchServlet" method="get">
					<h1>Course Search</h1>
					<p>
						Course Name <input type="text" name="coursesearch">
						<button type="submit" value="Search">Search</button>
					</p>
				</form>
				<%
					Set<Course> searched_course_set = (Set<Course>)session.getAttribute("searched_course_set");
					if(searched_course_set != null) {
						System.out.println("Searched_course_set :" + searched_course_set);
						if (searched_course_set.isEmpty()) {
							out.println("<p><b>Not found any course.<b></p>");
							System.out.println("Not found any course.");
						} else {
							out.println("<p><b>Found course(s) : </b><p>");
							System.out.println("Found courses(s): ");
							for (Course course : searched_course_set) {
								out.println("<p>" + course + "</p>");
								System.out.println(course);
							}
						} 
					} %>
		<% } %>
		
</body>
</html>