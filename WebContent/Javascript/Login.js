function validate()
{
	
	var user=document.forms["crmloginuser"]["user_id"].value;
	
	var password=document.forms["crmloginuser"]["password"].value;
	
	var flag=0;
	
	if(user=="")
		{
		document.getElementById("errorSpan1").innerHTML="User Name cannot be empty";
		flag=1;
		}
	if(password=="")
	{
	document.getElementById("errorSpan2").innerHTML="Password cannot be empty";
	flag=1;
	}
	
	
	if(flag==1)
	{
		return false;
	}
	return true;
}