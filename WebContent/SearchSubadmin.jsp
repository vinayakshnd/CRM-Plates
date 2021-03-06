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
<script type="text/javascript" src="Javascript/SubAdminSearchValidate.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AJAX calls using Jquery in Servlet</title>
        <script src="http://code.jquery.com/jquery-latest.js">   
        </script>
        <script>
            $(document).ready(function() {                        
                $('#subadmin_id').change(function(event) {  
                    var username=$('#subadmin_id').val();
                    if(username=="Selected")
                    	{
                    	$('#welcometext').html("<input type='hidden' value=''");
                    	}
                    else{
                 $.post('SearchSubAdminAjax',{subadmin_id:username},function(responseText) { 
                        $('#welcometext').html(responseText);         
                    });
                    }
                    });
            });
        </script>
       
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
<%="select * from userinfo"%>
</sql:query>

<body>
<select id="subadmin_id">
						<option value="Selected">--Selected--</option>
						<c:forEach var="cust" items="${result1.rows}">
							<option value='<c:out value="${cust.User}"/>'>
								${cust.User_Name}
							</option>
						</c:forEach>
				</select>	
<input type="hidden" value="1" name="chkcontrol">
</body>
<div id="welcometext"></div>
</html>


