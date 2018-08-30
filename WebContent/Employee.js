function validateFirstName(){
	     var pattern = new RegExp("(^[A-Za-z]+$)");  
		 var firstname = document.getElementById("fName");
        if(firstname.value.length > 2 && pattern.test(firstname.value)){
		firstname.style.borderColor = "green";
		return true;
		}else{
		firstname.style.borderColor = "red";
			errorMsg += "Invalid First Name ";
		}
}

function validateLastName(){
	     var pattern = new RegExp("(^[A-Za-z]+$)");  
		 var lastname = document.getElementById("lName");
        if(lastname.value.length > 2 && pattern.test(lastname.value)){
		lastname.style.borderColor = "green";		
		return true;
		}else{
		lastname.style.borderColor = "red";	
		errorMsg += "Invalid Last Name ";
		}
}

function validateAge(){
	var age = document.getElementById("age");
	if( isNAN(age) || age<18 || age >70){
		age.style.borderColor = "red";	
		errorMsg += "Invalid age ";
	}
	else{
		age.style.borderColor = "green";		
		return true;
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
		errorMsg += "Invalid email ";
	}
}

function validateAll(){
        if(validateFirstName() && validateLastName() && validateAge() && validateEmail()){
		 return true;
		}else{
		 return false;	
		}		
}


function addEmployee(){
   debugger;
   if(validateAll()){
	
   alert('Added Successfully!!');
   document.addEmployee.action = 'AddEmployee';
   document.addEmployee.submit();
   }else{
   alert(errorMsg);
   }
}