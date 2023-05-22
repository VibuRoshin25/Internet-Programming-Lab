<?php
$name = $_POST['name'];
$email = $_POST['email'];
$phone = $_POST['phone'];

// Regular expression patterns for validation
$namePattern = '/^[A-Za-z\s]+$/';
$emailPattern = '/^\S+@\S+\.\S+$/';
$phonePattern = '/^\d{10}$/';

// Validation
$errors = array();

if (!preg_match($namePattern, $name)) {
    $errors[] = "Name must contain only letters and spaces.";
}

if (!preg_match($emailPattern, $email)) {
    $errors[] = "Invalid email format.";
}

if (!preg_match($phonePattern, $phone)) {
    $errors[] = "Invalid phone number format. Please enter a 10-digit number.";
}

// Display errors or success message
if (count($errors) > 0) {
    echo "<div class='container'>";
    echo "<h1>Error</h1>";
    foreach ($errors as $error) {
        echo "<p>$error</p>";
    }
    echo "<a href='index.html'>Go Back</a>";
    echo "</div>";
} else {
    echo "<div class='container'>";
    echo "<h1>Success</h1>";
    echo "<p>Name: $name</p>";
    echo "<p>Email: $email</p>";
    echo "<p>Phone: $phone</p>";
    echo "</div>";
}
?>