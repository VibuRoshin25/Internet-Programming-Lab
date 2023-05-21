function validateForm() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    
    if (username.trim() === "") {
        document.getElementById("error").innerHTML = "Please enter your username.";
        return false;
    }
    
    if (username === "vibu" && password === "password") {
        // Validation successful, redirect to main.html
        window.location.replace("main.html");
        return false; // Prevent form submission
    } else {
        document.getElementById("error").innerHTML = "Invalid username or password.";
        return false;
    }
}
