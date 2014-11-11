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
	$.post('AddTableTransAjax',{},function(responceText){
		$("#firstable").html(responceText);
	});
	$('.same').change(function(){
		var clientId = $(this).val();
		//alert("heelo"+clientId);
		var id = $(this).val();
		id=$(document.getElementById(id));
		//alert("+"+id);	
		var clientId = $("#client_id").val();
		if($(this).is(":checked")) {
			
			//alert("Sending post request");
			$.post('AddTableTransAjax',{client_id:clientId},function(responceText){
				id.html(responceText);
			});
		}
		else{
			id.html("Hello <b>world</b>!");	
		}
	});
});
jQuery(document).ready(function(){
	  $('.accordion .head').click(function() {
	      $(this).next().toggle();
	      return false;
	  }).next().hide();
	});
	
//function updatetotal()
//{      
//	var plate_id=document.getElementsByName("plate_id");
//	var new1=document.getElementsByName('new');
//	var subm=document.getElementsByName('submitted');
//	var prev=document.getElementsByName("previouslyAlloted");
//	var total=document.getElementsByName("total");
//	alert("hey");
//	alert(new1[0].value+"+"+new1[1].value);
//	for (var i = 0; i < plate_id.length; i++) {
//		total[i].value=(Number(new1[i].value)+Number(subm[i].value)-Number(prev[i].value));
//	}
//}
function updatetotal()
{      
	var provider_id=document.getElementsByName("provider_id");
	var new1=document.getElementsByName('new');
	var subm=document.getElementsByName('submitted');
	var prev=document.getElementsByName("previouslyAlloted");
	var total=document.getElementsByName("total");
	var new1_total=document.getElementsByName('new_total');
	var subm_total=document.getElementsByName('submitted_total');
	var prev_total=document.getElementsByName("previouslyAlloted_total");
	var total_total=document.getElementsByName("total_total");
	
	var i=0;
	for(var j=0;j<provider_id.length;j++)
	{	
		new1_total[j].value="0";
		prev_total[j].value="0";
		subm_total[j].value="0";
		total_total[j].value="0";
		for(var k=0; k < (new1.length/provider_id.length);k++) 
		{
		total[i].value=(Number(new1[i].value)-Number(subm[i].value)+Number(prev[i].value));
		
		new1_total[j].value=(Number(new1[i].value)+Number(new1_total[j].value));
		//alert(j+"+"+Number(new1[i].value)+"+"+Number(new1_total[j].value));
		prev_total[j].value=(Number(prev_total[j].value)+Number(prev[i].value));
		
		subm_total[j].value=(Number(subm_total[j].value)+Number(subm[i].value));
		total_total[j].value=(Number(total[i].value)+Number(total_total[j].value));
		i++;
		
		}
	}
}


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

<sql:setDataSource var="clientDB" driver="<%=driver%>"
     url="<%=url%>"
     user="<%=user%>"  password="<%=password%>"/>
     
<sql:query dataSource="${clientDB}" var="clientResult">
<%="select * from client" %>
</sql:query>
 

<sql:query dataSource="${clientDB}" var="providerList">
<%="select * from provider where provider_id!=1" %>
</sql:query>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h4>Create new Order </h4>

    <form action="AddTransaction" method="post">
   
    
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
  	<table>
  <tr><td>Shashi Plates</td>
  <td><input type="hidden" value="1" name="provider_id">
  </tr>
  <tr><td>
  <div id="firstable">
  </div>
  </td></tr>
  <tr>
  <td>
 
  
   <c:forEach var="provider" items="${providerList.rows}">	
  <tr><td>${provider.Provider_Name}<input class="same" type="checkbox" name="provider_id" value='${provider.Provider_Id}'>
  </td></tr>
  <tr><td>
  <div id='${provider.Provider_Id}'>
  </div></td></tr>
  </c:forEach>
<tr><td>
<table>
    <tr>
    <td>    <table cellspacing="0" >
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

</td></tr>
</table>

</form>
</body>
</html>