<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update User</title>
</head>
<body>
<%-- <p>Welcome ${id}</p> --%>
	<p>Update Profile</p>
	<form action="/update" method=post>
		<p>Enter New Name</p>
		<input type="text" name="name"/>
		<p>Enter New Password</p>
		<input type="text" name="password" />
		 <br>
		<button type="submit">Submit</button>
	</form>
</body>
</html>