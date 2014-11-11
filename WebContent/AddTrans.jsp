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

<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Locale"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
$(document).ready(function (){
	alert("document");
	$('#client_id').change(function(){
		
		alert("Client id changed");
		var clientId = $("#client_id").val();
		if(clientId == "Selected") {
			alert("No change");
		}else{
			alert("Sending post request");
			$.post('newOrderController',{client_id:clientId},function(responceText){
				$('#accordion').html(responceText);
			});
		}
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
 
<sql:query dataSource="${clientDB}" var="plateList">
<%="select * from plate_info"%>
</sql:query>

<sql:query dataSource="${clientDB}" var="providerList">
<%="select * from provider" %>
</sql:query>

<body>
<div id="orderForm">
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
    
    <br>
  
  	<div name="form" id="form">
  	
  	</div>
     
  <div id="accordion">
 <%j=0;%>
 	
  <c:forEach var="provider" items="${providerList.rows}">	
  <h3>${provider.Provider_Name}<input type="checkbox" name="" value=></h3>
  <div>${provider.Provider_Name}<input type="checkbox" name='${provider.Provider_Id}' value='<c:out value="${provider.Provider_Id}"/>' checked="checked">
    <p>
    <table border="1" cellspacing="0">
    
    <tr>
    	<th>Size</th>
    	<th>Previously alloted</th>
    	<th>New</th>
    	<th>Returned</th>
    	<th>Rate</th>
    </tr>
  <%j++;
  i=0; %>  
    <c:forEach var="plate" items="${plateList.rows}">
    	<%i++;%>
    	<%System.out.println("the value is"+i+","+j); %>
    	
    	<tr>
    		
    		<td><input type="hidden" value='${plate.plate_id}' name=<%=s.concat("plate".concat(Integer.toString(j*10+i)))%>>
    		${plate.size}
    		</td>
			<td>
    			<input type="text" name=<%=s.concat("previouslyAlloted".concat(Integer.toString(j*10+i)))%> value="0" width="10" readonly="readonly">
    		</td>
    		
    		<td>
    			<input type="text" name=<%=s.concat("new".concat(Integer.toString(j*10+i)))%> value="1" width="10">
    		</td>

    		<td>
    			<input type="text" name=<%=s.concat("submitted".concat(Integer.toString(j*10+i)))%> value="0" width="10">
    		</td>
    		
    		<td>
    			<input type="text" name=<%=s.concat("rate".concat(Integer.toString(j*10+i)))%> value='${plate.RatePerPlate}' width="10">
    		</td>
    	</tr>
    	
	</c:forEach>
    
    
    </table>
   
  </div>
  </c:forEach>
  </div>
  
    <br><br><br>
    
    <table>
    <tr>
    <td><input type="hidden" value=<%=i%> name="noofplates">
    	<input type="hidden" value=<%=j%> name="nofproviders">
    <table cellspacing="0" >
    	<tr>
    		<td>
    			Advance :
    		</td>
    		
    		<td>
    			<input type="text" name="advance" value="500"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		</td>
    	</tr>
    	<tr>
    		<td>
    			Total :
    		</td>
    		
    		<td>
    			<input type="text" name="totalAmount" value="1000">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		</td>
    	</tr>
    </table>
    </td>
    <td>
    
    </td>
    </tr>
	</table>
	
   	<input type="submit" value="Create Order">
    <input type="reset" value="Cancel">
    
  </form>
</div>

</body>
</html>
