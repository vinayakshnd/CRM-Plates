<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="Javascript/Add_Office.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddOffice" method="post" name="crmaddoffice" onsubmit="return validate1()">
<table>
<tr><td>office name :<input type="text" name="office_name" ></td><td><span id='errorSpan1' style='color:red'></span></td></tr>
<tr><td>office address<textarea name="office_Add" rows="2" cols="50" ></textarea></td><td><span id='errorSpan2' style='color:red'></span></td></tr>

<tr><td>office phn<input type="text" name="office_phn" onchange="isphone()" onkeypress="return isNumber3(event)" ></td><td><span id='errorSpan3' style='color:red'></span></td></tr>
<tr><td><input type="submit" value="add"></td></tr>
</table>
</form>
</body>
</html>
