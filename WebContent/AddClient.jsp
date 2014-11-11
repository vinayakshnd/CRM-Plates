<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="Javascript/Add_Client.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action='AddClient' method='post' name='crmaddclient' onsubmit='return validate1()'>
<table><tr><td>Client Name :</td><td>
<input type='text' value="" name='client_name' onkeypress='return isChar(event)'>
</td><td><span id='errorSpan1' style='color:red'></span>
</td></tr><tr><td>Client Address</td><td>
<textarea name='client_add' rows='2' cols='50'></textarea></td><td><span id='errorSpan2' style='color:red'></span>
</td></tr><tr><td>Client Phone Number</td><td>
<input type='text' value="" name='client_phn' onchange='isphone1()' onkeypress='return isNumber1(event)'><td><span id='errorSpan3' style='color:red'></span>
</td></tr><tr><td>Client Site Address</td><td> 
<textarea name='client_site_add' rows='2' cols='50'></textarea></td>
<td><span id='errorSpan4' style='color:red'></span>
</td></tr><tr><td>Guaranter Name</td><td>
<input type='text' value="" name='guaranter_name'><td><span id='errorSpan5' style='color:red'></span>
</td></tr><tr><td>Guaranter Phone</td><td> 
<input type='text' value="" name='guaranter_phn' onchange='isphone2()' onkeypress='return isNumber2(event)'><td><span id='errorSpan6' style='color:red'></span>
</td></tr><tr><td>
<input type='submit' value='submit' name='submit'>
</td><td>
<input class='ui-btn ui-icon-delete ui-btn-icon-left' type='submit' value='delete' name='submit'>
</td></tr></table></form>
		</body>
</html>