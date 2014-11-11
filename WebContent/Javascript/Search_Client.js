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
function isphone1()
{      
	var phone=document.forms["crmmodifyclient"]["client_phn"].value;
	var pattern = /^[0-9]{10}/;      
	
	if (phone.length==10) 
		{   
			
		document.getElementById("errorSpan3").innerHTML="";  
			return true;
		} 
	else 
		{           
			
			document.getElementById("errorSpan3").innerHTML="Contact Num should have 10 digits";          
			document.forms["crmmodifyclient"]["client_phn"].value="";
			return false;        
		}    
}
function isChar(evt) 
{
    evt = (evt) ? evt : event;
    var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode :
    ((evt.which) ? evt.which : 0));
    if (charCode > 32 && (charCode < 65 || charCode > 90) &&
        (charCode < 97 || charCode > 122)) {
    	document.getElementById("errorSpan1").innerHTML="Enter Characters only";
		    
    	return false;
        }
    return true;
}
function isphone2()
{      
	 
	
	var phone=document.forms["crmmodifyclient"]["guaranter_phn"].value;
	
	var pattern = /^[0-9]{10}/;      
	
	if (phone.length==10) 
		{   
			
		document.getElementById("errorSpan6").innerHTML="";  
			return true;
		} 
	else 
		{           
			
			document.getElementById("errorSpan6").innerHTML="Contact Num should have 10 digits";          
			document.forms["crmmodifyclient"]["guaranter_phn"].value="";
			return false;        
		}    
}

function isNumber1(evt)
{
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
function isNumber2(evt)
{
	evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    
    if (charCode > 31 && (charCode < 48 || charCode > 57)) 
    	{
    		document.getElementById("errorSpan6").innerHTML="Enter Digits only";
    		return false;
    	}
    	document.getElementById("errorSpan6").innerHTML="";
    	return true;
}

function validate1()
{
	var client_name=document.forms["crmmodifyclient"]["client_name"].value;
	var client_add=document.forms["crmmodifyclient"]["client_add"].value;
	var client_phn=document.forms["crmmodifyclient"]["client_phn"].value;
	var client_site=document.forms["crmmodifyclient"]["client_site_add"].value;
	var guaranter_name=document.forms["crmmodifyclient"]["guaranter_name"].value;
	var guaranter_phn=document.forms["crmmodifyclient"]["guaranter_phn"].value;
	
	var flag=0;
	
	if(client_phn=="")
		{
		document.getElementById("errorSpan3").innerHTML="Contact number Empty";
		flag=1;
		}
	if (client_phn.length==10) 
	{   
	document.getElementById("errorSpan3").innerHTML="";  
	} 
	else 
	{           
	document.getElementById("errorSpan3").innerHTML="Contact Num should have 10 digits";          
	document.forms["crmmodifyclient"]["client_phn"].value="";
	flag=1;        
	}    
	if(guaranter_phn=="")
	{
	document.getElementById("errorSpan6").innerHTML="Contact number Empty";
	flag=1;
	}
if (guaranter_phn.length==10) 
{   
document.getElementById("errorSpan6").innerHTML="";  
} 
else 
{           
document.getElementById("errorSpan6").innerHTML="Contact Num should have 10 digits";          
document.forms["crmmodifyclient"]["guaranter_phn"].value="";
flag=1;        
}    
	if(guaranter_name=="")
	{
	document.getElementById("errorSpan5").innerHTML="Guaranter Name Empty";
	flag=1;
	}
	if(client_site=="")
	{
	document.getElementById("errorSpan4").innerHTML="Client site Address Empty";
	flag=1;
	}
	if(client_add=="")
	{
	document.getElementById("errorSpan2").innerHTML="Client Address Empty";
	flag=1;
	}
	if(client_name=="")
	{
	document.getElementById("errorSpan1").innerHTML="Client Name Empty";
	flag=1;
	}
	
	
	if(flag==1)
	{
		return false;
	}
	return true;
}