function validateForm() {
    var firstName = document.getElementById("firstName").value;
    var lastName = document.getElementById("lastName").value;
    var email = document.getElementById("email").value;
    var phone = document.getElementById("phone").value;
    var address = document.getElementById("address").value;
    var city = document.getElementById("city").value;
    var state = document.getElementById("state").value;
    var zipcode = document.getElementById("zipcode").value;
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    
    // Regular expressions for validation
    var nameRegex = /^[A-Za-z\s]+$/;
    var emailRegex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    var phoneRegex = /^\d{10}$/;
    var zipcodeRegex = /^\d{6}$/;
    var usernameRegex = /^[A-Za-z0-9]+$/;
    var passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$/;
    
    if (!firstName.match(nameRegex)) {
        document.getElementById("error").innerHTML = "Please enter a valid first name.";
        return false;
    }
    
    if (!lastName.match(nameRegex)) {
        document.getElementById("error").innerHTML = "Please enter a valid last name.";
        return false;
    }
    
    if (!email.match(emailRegex)) {
        document.getElementById("error").innerHTML = "Please enter a valid email address.";
        return false;
    }
    
    if (!phone.match(phoneRegex)) {
        document.getElementById("error").innerHTML = "Please enter a valid phone number.";
        return false;
    }
    
    if (address.trim() === "") {
        document.getElementById("error").innerHTML = "Please enter your address.";
        return false;
    }
    
    if (city.trim() === "") {
        document.getElementById("error").innerHTML = "Please enter your city.";
        return false;
    }
    
    if (state.trim() === "") {
        document.getElementById("error").innerHTML = "Please enter your state.";
        return false;
    }
    
    if (!zipcode.match(zipcodeRegex)) {
        document.getElementById("error").innerHTML = "Please enter a valid ZIP code.";
        return false;
    }
    
    if (!username.match(usernameRegex)) {
        document.getElementById("error").innerHTML = "Please enter a valid username.";
        return false;
    }
    
    if (!password.match(passwordRegex)) {
        document.getElementById("error").innerHTML = "Please enter a valid password. It should contain at least 6 characters including at least one digit, one lowercase letter, and one uppercase letter.";
        return false;
    }
    
    // Registration successful
    var successMessage = "<h1>Registration successful!<h1>";
    document.getElementById("error").innerHTML = successMessage;

    // Prevent form submission
    return false;
}
