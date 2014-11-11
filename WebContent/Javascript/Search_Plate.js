function check()
{
 alert("comes to the javascript to check");
}
function clear()
{
	document.getElementById("errorSpan1").innerHTML="";
	document.getElementById("errorSpan2").innerHTML="";
	document.getElementById("errorSpan3").innerHTML="";
}
function isNumber1(evt)
{
	//check();
	evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    
    if (charCode > 31 && (charCode < 48 || charCode > 57)) 
    	{
    		document.getElementById("errorSpan2").innerHTML="Enter Digits only";
    		return false;
    	}
    	document.getElementById("errorSpan2").innerHTML="";
    	return true;
}
function isNumber2(evt)
{
	//check();
	evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    
    if (charCode > 31 && (charCode < 48 || charCode > 57)) 
    	{
    		document.getElementById("errorSpan3").innerHTML="Enter Digits only";
    		return false;
    	}
    	document.getElementById("errorSpan3").innerHTML="";
    	return true;
}
function CheckDecimal(inputtxt)   
{   
	var decimal=   /^\d+(?:\.\d+|)$/;   
	if(inputtxt.value.match(decimal))   
	{   
		alert('Correct, try another...')  
		return true;  
	}  
		else  
	{   
			alert('Wrong...!')  
			return false;  
	}  
}   
function isNumber3(evt)
{
	//check();
	evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
  
    if(charCode==190)
    	return true;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) 
    	{
    		document.getElementById("errorSpan4").innerHTML="Enter Digits only";
    		return false;
    	}
    	document.getElementById("errorSpan4").innerHTML="";
    	return true;
}

function validate1()
{
	
	var size=document.forms["crmmodifyplate"]["plate_size"].value;
	var total=document.forms["crmmodifyplate"]["plate_total"].value;
	var avail=document.forms["crmmodifyplate"]["plate_available"].value;
	var rate=document.forms["crmmodifyplate"]["plate_rate"].value;
	var decimal=  /^[-+]?[0-9]+\.[0-9]+$/;   
	
	var flag=0;
	if(rate.match(decimal))   
	{   
		document.getElementById("errorSpan4").innerHTML="";  
	}  
	else
	{
		flag=1;
		document.getElementById("errorSpan4").innerHTML="Rate Per Plate Wrong format";
	}
	
	if(total=="")
		{
		document.getElementById("errorSpan2").innerHTML="Total Number Of Empty";
		flag=1;
		}
	if(avail=="")
	{
	document.getElementById("errorSpan3").innerHTML="Available Number Of Plate Empty";
	flag=1;
	}
	
	if(size=="")
	{
	document.getElementById("errorSpan1").innerHTML="Size Empty";
	flag=1;
	}
	if(rate=="")
	{
	document.getElementById("errorSpan4").innerHTML="Rate Per Plate Empty";
	flag=1;
	}
	
	
	if(flag==1)
	{
		return false;
	}
	return true;
	
}