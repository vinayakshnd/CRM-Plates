function check()
{
 alert("comes to the javascript to check");
}
function clear()
{
	document.getElementById("errorSpan1").innerHTML="";
	document.getElementById("errorSpan2").innerHTML="";
	document.getElementById("errorSpan3").innerHTML="";
	document.getElementById("errorSpan4").innerHTML="";
	
}
function isphone()
{      
	 
	
	var phone=document.forms["crmmodifysubadmin"]["subadmin_phn"].value;
	
	var pattern = /^[0-9]{10}/;      
	
	if (phone.length==10) 
		{   
			
		document.getElementById("errorSpan3").innerHTML="";  
			return true;
		} 
	else 
		{           
			
			document.getElementById("errorSpan3").innerHTML="Contact Num should have 10 digits";          
			document.forms["crmmodifysubadmin"]["subadmin_phn"].value="";
			return false;        
		}    
}

function isNumber3(evt)
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
function validate1()
{
	var phone=document.forms["crmmodifysubadmin"]["subadmin_phn"].value;
	var address=document.forms["crmmodifysubadmin"]["subadmin_add"].value;
	var name=document.forms["crmmodifysubadmin"]["subadmin_name"].value;
	
	var flag=0;
	clear();
	
	if(phone=="")
		{
		document.getElementById("errorSpan3").innerHTML="Contact number Empty";
		flag=1;
		}
	if (phone.length==10) 
	{   
	document.getElementById("errorSpan3").innerHTML="";  
	} 
	else 
	{           
	document.getElementById("errorSpan3").innerHTML="Contact Num should have 10 digits";          
	document.forms["crmmodifysubadmin"]["subadmin_phn"].value="";
	flag=1;        
	}    
	if(address=="")
	{
	document.getElementById("errorSpan2").innerHTML="Address Empty";
	flag=1;
	}
	if(name=="")
	{
	document.getElementById("errorSpan1").innerHTML="Name Empty";
	flag=1;
	}
	
	
	if(flag==1)
	{
		return false;
	}
	return true;
}