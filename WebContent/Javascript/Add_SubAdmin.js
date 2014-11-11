function check()
{
 alert("comes to the javascript to check");
}
function Advice()
{
	var phone=document.forms["crmaddsubadmin"]["subadmin_name"].value;
	var phone=document.forms["crmaddsubadmin"]["subadmin_phn"].value;
}
function clear()
{
	document.getElementById("errorSpan1").innerHTML="";
	document.getElementById("errorSpan2").innerHTML="";
	document.getElementById("errorSpan3").innerHTML="";
	document.getElementById("errorSpan4").innerHTML="";
	document.getElementById("errorSpan5").innerHTML="";
	document.getElementById("errorSpan6").innerHTML="";
}
function isphone()
{      
	 
	
	var phone=document.forms["crmaddsubadmin"]["subadmin_phn"].value;
	
	var pattern = /^[0-9]{10}/;      
	
	if (phone.length==10) 
		{   
			
		document.getElementById("errorSpan3").innerHTML="";  
			return true;
		} 
	else 
		{           
			
			document.getElementById("errorSpan3").innerHTML="Contact Num should have 10 digits";          
			document.forms["crmaddsubadmin"]["subadmin_phn"].value="";
			return false;        
		}    
}
function checkpassword()
{
	var password=document.forms["crmaddsubadmin"]["password"].value;
	var password1=document.forms["crmaddsubadmin"]["password1"].value;
	if(password!=password1)
	{
		document.getElementById("errorSpan7").innerHTML="Rentry Password";
		document.forms["crmaddsubadmin"]["password1"].value="";
		
	}
	else
	{
		document.getElementById("errorSpan7").innerHTML="Password Match";
		
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
	var phone=document.forms["crmaddsubadmin"]["subadmin_phn"].value;
	var address=document.forms["crmaddsubadmin"]["subadmin_add"].value;
	var name=document.forms["crmaddsubadmin"]["subadmin_name"].value;
	var office=document.forms["crmaddsubadmin"]["office_id"].value;
	var user=document.forms["crmaddsubadmin"]["user"].value;
	var password=document.forms["crmaddsubadmin"]["password"].value;
	var password1=document.forms["crmaddsubadmin"]["password1"].value;
	var flag=0;
	clear();
	if(user=="")
	{
		document.getElementById("errorSpan5").innerHTML="User Name Empty";
		flag=1;	
	}
	if(password=="")
	{
		document.getElementById("errorSpan6").innerHTML="Password Empty";
		flag=1;
	}
	if(password1=="")
	{
		document.getElementById("errorSpan7").innerHTML="Rentry Password Empty";
		flag=1;
	}
	if(password!=password1)
	{
		document.getElementById("errorSpan7").innerHTML="Rentry Password";
		flag=1;
	}
	if(office=="Selected")
	{
		document.getElementById("errorSpan4").innerHTML="Select Office";
		flag=1;
	}
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
	document.forms["crmaddsubadmin"]["subadmin_phn"].value="";
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