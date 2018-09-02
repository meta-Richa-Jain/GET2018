var errorMsg ="";

function logIn(){
	debugger;
	if(validateEmail() && validatePassword()){
	alert("Logged In Successfully !!");	
	document.loginForm.action = "Profile.html";
	document.loginForm.submit();
   }
   else{
	   alert(errorMsg);
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
	  errorMsg += "Invalid email id ";
	  return false;
	}
}

function validatePassword(){
      var pattern = new RegExp("^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}$");
      var password = document.getElementById("password");
      if(pattern.test(password.value)){
      password.style.borderColor = "green";
	  return true;
      }
      else{
       password.style.borderColor = "red";
	   errorMsg += "Invalid password";
	   return false;
      }
}