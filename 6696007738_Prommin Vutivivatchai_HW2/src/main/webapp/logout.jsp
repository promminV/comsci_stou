<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>STOU Online School Logout</title>
	<script>
		function delayedRedirect() {
		    setTimeout(function() {
		        window.location.href = 'index.html';
		    }, 3000); // delay 3 seconds
		}
		
		// Call the function when the page loads
		window.onload = delayedRedirect;
	</script>
</head>
<body>
	<%  
		if (session != null) {
			session.invalidate();
		}
	%>
	<h4>Logout complete.</h4>
	<p>Select login menu again if you want to access our services.</p>
</body>
</html>