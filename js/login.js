function login(){
	if(validateEmail()){
	alert("Logged In");	
	document.loginform.action = "profile.html";
	document.loginform.submit();
   }
}

function validateEmail(){
	var pattern = new RegExp("^[A-Za-z]+[.A-Za-z0-9]+@+[A-Za-z0-9]+(.[a-zA-Z]{2,4})+$");
	var email = document.getElementById("email");
	if(pattern.test(email.value)){
		email.style.borderColor = "green";
		return true;
	}else{
	  email.style.borderColor = "red";	
	}
}