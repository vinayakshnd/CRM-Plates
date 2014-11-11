<%@page import="crm.to.SubAdminTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@page import="java.util.List" %>
    <%@page import="java.util.ArrayList" %>

<%@page import="com.bps.util.DbUtil"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
    
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Locale"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
    Properties prop = new Properties();
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

 <body>
<p>hello</p>
</body>
<form action="CrmSeachSubadmin" method="post" name="crmmodifysubadmin">
<%
System.out.println("inside jsp1");
SubAdminTO subadmin;
System.out.println("inside jsp2");
subadmin=(SubAdminTO)request.getAttribute("subadmin");
System.out.println("inside jsp3  :"+subadmin.getSubadminOffice());

//out.print(list);
%>
<table>
<tr>
<td>Name :
</td>
<td>
<input type="hidden" value=<%=subadmin.getSubadminId() %> name="subadmin_id">
<input type="text" value=<%=subadmin.getSubadminName()%> name="subadmin_name">
</td>

<tr><td>Address</td>
<td><input type="text" value=<%=subadmin.getSubadminAdd()%> name="subadmin_add">
</td>
</tr>
<tr>
<td>
Phone Number
</td>
<td><input type="text" value=<%=subadmin.getSubadminPhn()%> name="subadmin_phn">
</td>
</tr>
<tr>
<td>
Select Office</td>
<td><select name="office">  
<option value=<%=subadmin.getSubadminOffice()%>><%=subadmin.getSubadminOffice()%>
</option> 
<c:forEach var="cust" items="${result1.rows}">
							<option value='<c:out value="${cust.Office_Id}"/>'>
								${cust.Office_Name}
							</option>
						</c:forEach>   
</select>
</td>
</tr>
<tr>
<td>
<input type="submit" value="submit" name="submit"> 
</td>
<td><input class="ui-btn ui-icon-delete ui-btn-icon-left" type="submit" value="delete" name="submit"> 
</td>
<td><input type="hidden" value="2" name="chkcontrol">
</td>
</tr>
</table>
</form>
</html>