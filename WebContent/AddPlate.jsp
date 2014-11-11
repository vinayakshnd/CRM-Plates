<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="Javascript/Add_Plate.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddPlate" method="post" name="crmaddplate" onsubmit="return validate1()">
<table>
<tr><td>size:<input type="text" name="plate_size" ></td><td><span id='errorSpan1' style='color:red'></span></td></tr>
<tr><td>total Plates<input type="text" name="total_plate" onkeypress="return isNumber1(event)" ></td><td><span id='errorSpan2' style='color:red'></span></td></tr>
<tr><td>Avail Plates<input type="text" name="avail_plate" onkeypress="return isNumber2(event)" ></td><td><span id='errorSpan3' style='color:red'></span></td></tr>
<tr><td>Rate Per Plates<input type="text" name="rate_per_plate" ></td><td><span id='errorSpan4' style='color:red'></span></td></tr>
<tr><td><input type="submit" value="add"></td></tr>
</table>
</form>
</body>
</html>
