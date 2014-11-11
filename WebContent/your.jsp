<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Locale"%>

 <%@page import="com.bps.util.DbUtil"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
$(document).ready(function (){
	alert("document");
	$('.same').change(function(){
		alert("Client id changed");
		var clientId = $(this).val();
			alert("heelo"+clientId);
			var id = $(this).attr('name');
			id=$(document.getElementById(id));
			alert("+"+id);	
			//$('#hello').html("Hello <b>world</b>!");
			id.html("Hello <b>world</b>!");
		});
	});

jQuery(document).ready(function(){
	  $('.accordion .head').click(function() {
	      $(this).next().toggle();
	      return false;
	  }).next().hide();
	});
	
</script>
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
<%!
String s="";
int i=0;
int j=0;
 %>
 <%
 System.out.println(s.concat("previouslyAlloted".concat(Integer.toString(i))));%>
<sql:setDataSource var="clientDB" driver="<%=driver%>"
     url="<%=url%>"
     user="<%=user%>"  password="<%=password%>"/>
     
<sql:query dataSource="${clientDB}" var="clientResult">
<%="select * from client" %>
</sql:query>
 

<sql:query dataSource="${clientDB}" var="providerList">
<%="select * from provider" %>
</sql:query>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h4>Create new Order </h4>

    <form action="AddTrans" method="post">
   
    
    <table>
    <tr>
    <td>Client name : </td>
    <td>
    
    <select name="client_id" id="client_id">
    <option value="Selected">---Select Client---</option>
						
		<c:forEach var="client" items="${clientResult.rows}">
			<option value='<c:out value="${client.client_id}"/>'>
						${client.client_name}
			</option>
		</c:forEach>
						
    </select>
    </td>
    </tr>
    
    <tr>
    </tr>
    <tr>
    <td>Date from : </td>
    <td><input type="date" name="dateFrom">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    
    <td>Date to :</td>
    <td><input type="date"  name="dateTo"></td>
    </tr>
    
    </table>
    <c:forEach var="provider" items="${providerList.rows}">	
  <div id="hello">
  </div>
  ${provider.Provider_Name}<input class="same" type="checkbox" name='${provider.Provider_Id}' value='${provider.Provider_Id}' checked="checked">
  <br>hello
  <br>tht
  <br><div id='${provider.Provider_Id}'>
  </div>
  </c:forEach>
</form>
</body>
</html>