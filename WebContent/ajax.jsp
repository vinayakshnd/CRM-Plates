<%@page import="java.awt.peer.SystemTrayPeer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%System.out.println("hello done1"); %>
<script>
function callAjaxType(){
	function getXMLHttpRequestObject()
	{  
		var xmlhttp;    
		<%
		System.out.println("hello done6"); %>

		try {      
			xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");    
			} 
		catch (e) {      
			try {        
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");      
				} 
			catch (E) {        
				xmlhttp = false;      
				}    
			}  
		if (!xmlhttp)
		{    
			try {      
				xmlhttp = new XMLHttpRequest();    
				} 
			catch (e) {      
				xmlhttp = false;    
			}  
			}  
		return xmlhttp;
			}
			


	var http = new getXMLHttpRequestObject();
	var url="<c:out value="${pageContext.request.contextPath}"/>/fetchsubadmin.jsp";
	
	http.open("GET","fetchsubadmin.jsp", true);
	http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");


	http.onreadystatechange = function(){          
		if(http.readyState == 4) 
		{          
			if(http.status==200)
			{                   
				document.getElementById('a').innerHTML=http.responseText;          
				
			}    
		}
	}
		http.send(null);
	}
		</script> 

<body>
<form action=""> 
<select name="customers" onchange="callAjaxType()">
<option value="">Select a customer:</option>
<option value="ALFKI">Alfreds Futterkiste</option>
<option value="NORTS ">North/South</option>
<option value="WOLZA">Wolski Zajazd</option>
</select>
</form>
<%
System.out.println("hello done5"); %>
<input type="text" name="cardnum" value="hello" onchange="callAjaxType()">

<span id="errorSpan1" style="color:red"></span>
<div id="a">


</div>

</body>
</html>
