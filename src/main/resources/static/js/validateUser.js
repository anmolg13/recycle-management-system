function validate(){
	var firstName=document.getElementById("firstName").value;
	var lastName=document.getElementById("lastName").value;
	var phoneNumber=document.getElementById("phoneNumber").value;
	var email=document.getElementById("email").value;
	var password=document.getElementById("password").value;
	var gender=document.getElementById("gender").value;
	var passwordpattern=  /^(?=.*[0-9])(?=.*[@#$%^&+=]).{6,}/

	if(firstName===null || firstName==="" || firstName.length<3 || firstName.length>15){
	document.getElementById('firstName').style.borderColor = "red";
	alert("Please update the highlighted mandatory fields!");
	return false;
	}
	if(lastName===null || lastName==="" || lastName.length<3 || lastName.length>15){
	document.getElementById('lastName').style.borderColor = "red";
	alert("Please update the highlighted mandatory fields!");
	return false;
	}
	if(phoneNumber===null || phoneNumber==="" || phoneNumber.length!=10){
	document.getElementById('phoneNumber').style.borderColor = "red";
	alert("Please update the highlighted mandatory fields!");
	return false;
	}
	if(email===null || email==="" || !(email.includes("@"))){
	document.getElementById('email').style.borderColor = "red";
	alert("Please update the highlighted mandatory fields!");
	return false;
	}
	if(password===null || password==="" || !(password.match(passwordpattern))){
	document.getElementById('password').style.borderColor = "red";
	alert("Please update the highlighted mandatory fields!");
	return false;
	}
	if(gender==="----Select----"){
	document.getElementById('gender').style.borderColor = "red";
	alert("Please update the highlighted mandatory fields!");
	return false;
	}

	}