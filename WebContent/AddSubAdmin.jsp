<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.bps.util.DbUtil"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Properties"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Locale"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="Javascript/Add_SubAdmin.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<% Properties prop = new Properties();
                InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("/db.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
%>
  <sql:setDataSource var="cust" driver="<%=driver%>"
     url="<%=url%>"
     user="<%=user%>"  password="<%=password%>"/>
     
<sql:query dataSource="${cust}" var="result1">
<%="select * from agency_info"%>
</sql:query>
<%!
String name="";
String phn="";
String add="";
String office="Selected";
String message="hey";
%>
<%
if(request.getAttribute("message")!=null)
{
	message=(String)request.getAttribute("message");
}
if(request.getAttribute("name")!=null)
{
	name=(String)request.getAttribute("name");
}
if(request.getAttribute("add")!=null)
{
	add=(String)request.getAttribute("add");
}if(request.getAttribute("phn")!=null)
{
	phn=(String)request.getAttribute("phn");
}if(request.getAttribute("office")!=null)
{
	office=(String)request.getAttribute("office");
}
%>
<body>

				<form action='AddSubadmin' method='post' name='crmaddsubadmin' onsubmit='return validate1()'>
					<h2 style='color:red'><%=message %></h2>	
					<table> <tr><td>Name :</td><td>
					<input type='text' value='<%=name%>' name='subadmin_name' onkeypress='return isChar(event)'><td><span id='errorSpan1' style='color:red'></span></td>
					<tr><td>Address</td>
					<td><textarea name='subadmin_add' rows='2' cols='50' value="ad"><%=add%></textarea></td><td><span id='errorSpan2' style='color:red'></span></td>
					</tr><tr><td>Phone Number</td>
					<td><input type='text' value='<%=phn%>' name='subadmin_phn' value="1234567890" onchange='isphone()' onkeypress='return isNumber3(event)'><td><span id='errorSpan3' style='color:red'></span></td>
					</tr><tr><td>Select Office</td><td>
					<select name="office_id">
						<option value='<%=office%>'>--Selected--</option>
						<c:forEach var="cust" items="${result1.rows}">
							<option value='<c:out value="${cust.Office_Id}"/>'>
								${cust.Office_Name}
							
							</option>
						</c:forEach>
				</select>	
				</td><td><span id='errorSpan4' style='color:red'></span></td>
				</tr><tr><td>User Name</td><td>
				<input type="text" value="" name="user" value="ad"></td><td><span id='errorSpan5' style='color:red' ></span>
				</td></tr>
				<tr><td>Password</td><td>
				<input type="password" value="" name="password" value="ad"><td><span id='errorSpan6' style='color:red'></span></td>
				</tr>
				<tr><td>Enter Password Again</td><td>
				<input type="password" value="" name="password1" onchange="checkpassword()" value="ad"></td><td><span id='errorSpan7' style='color:red'></span></td>
				
				<tr><td>	<input type='submit' value='submit' name='submit'>
					</td></tr></table></form>
</body>
</html>