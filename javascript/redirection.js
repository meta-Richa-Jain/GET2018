function validateForm() {
    debugger;
    error = "";

    if (localStorage) {
        localStorage.clear();
    }

    validateFirstName();
    validateLastName();
    validateEmail();
    validatePhone();
    validateCity();




    var state = document.getElementById("state");

    if (state.value == 'Rajasthan') {
        validateDomainName();
        var projectDesc = document.getElementById('projectDesc');
        localStorage.setItem('projectDesc', projectDesc.value);
    } else if (state.value == 'Haryana') {
        validateZipCode();
        var hosting = document.getElementById('hosting');
        localStorage.setItem("hosting", hosting.value);
    } else if (state.value == 'Maharashtra') {
        validateZipCode();
        var projectDesc = document.getElementById('projectDesc');
        localStorage.setItem('projectDesc', projectDesc.value);
    }

    localStorage.setItem("state", state.value);

    var address = document.getElementById("address");
    localStorage.setItem("address", address.value);

    if (error.length == 0) {
        // all values are correct
        alert("Success");
        return true;
    } else {
        alert(error);
        return false;
    }
}


function validateFirstName() {
    var pattern = new RegExp("(^[A-Za-z]{2,}$)");
    var firstName = document.getElementById('firstName');
    if (pattern.test(firstName.value)) {
        localStorage.setItem("firstName", firstName.value);

    } else {
        error += "Enter valid first name \n";

    }


}

function validateLastName() {
    debugger;
    var pattern = new RegExp("(^[A-Za-z]{2,}$)");
    var lastName = document.getElementById('lastName');
    if (lastName.value.length != 0) {
        if (pattern.test(lastName.value)) {
            localStorage.setItem("lastName", lastName.value)

        } else {
            error += "Enter valid last name \n";

        }
    }
}

function validateEmail() {
    var pattern = new RegExp("^[A-Za-z]+[.A-Za-z0-9]+@+[A-Za-z0-9]+(.[a-zA-Z]{2,4})+$");
    var email = document.getElementById("email");
    if (pattern.test(email.value)) {
        localStorage.setItem("email", email.value);

    } else {
        error += "Enter valid email-id \n";

    }

}

function validatePhone() {
    debugger;
    var pattern = new RegExp("([1-9]{1}[0-9]{9}$)");
    var phone = document.getElementById("phone");
    if (pattern.test(phone.value)) {
        localStorage.setItem("phone", phone.value);

    } else {
        error += "Enter valid phone no \n";

    }
}

function validateCity() {
    var pattern = new RegExp("(^[A-Za-z]{3,}$)");
    var city = document.getElementById('city');
    if (pattern.test(city.value)) {
        localStorage.setItem("city", city.value);

    } else {
        error += "Enter valid city \n";

    }
}

function validateZipCode() {

    var zip = document.getElementById('zipcode');
    if (zip.value.length != 0) {
        var pattern = new RegExp("([1-9]{1}[0-9]{5}$)");
        if (pattern.test(zip.value)) {
            localStorage.setItem("zip", zip.value);
        } else {
            error += "Enter valid zip code \n";
        }
    }
}

function validateDomainName() {
    var domain = document.getElementById('domainName');
    if (domain.value.length != 0) {
        localStorage.setItem("domain", domain.value);
    }
}
