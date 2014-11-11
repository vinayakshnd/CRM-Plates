<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="Javascript/Login.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
String message=null;
if(session.getAttribute("user")==null)
{
	message="";
}
else
{
	message=(String)session.getAttribute("user");
}
%>
<body>
</body>
<form action="LoginController" method="post" name="crmloginuser" onsubmit="return validate()">
<table>
<tr>
<td>Name<input type="text" name="user_id" value=""></td><td><span id='errorSpan1' style='color:red'></span></td></tr>
<tr><td>Password<input type="password" name="password" value=""><td><span id='errorSpan2' style='color:red'></span></td></tr>
<tr><td><input type="submit" value="login"></td></tr>
<tr><td><%=message%></td></tr>

</table>
</form>
</html>