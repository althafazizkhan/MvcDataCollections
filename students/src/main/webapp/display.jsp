<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Result is: ${Result}

	<form action="edit">
	
	
	Name <input type="text" name="name"> Last Name <input
			type="text" name="Lname"> <select name="condition">

			<option value="edit">edit</option>
			<option value="delete">delete</option>
		</select> <input type="submit">
	</form>
</body>
</html>