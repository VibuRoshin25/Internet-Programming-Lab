<?php
// Database connection parameters
$host = 'localhost';
$username = '';
$password = '';
$database = 'oceans_db';

// Create a database connection
$conn = mysqli_connect($host, $username, $password, $database);

// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

// Retrieve form data
$name = $_POST['name'];
$email = $_POST['email'];
$phone = $_POST['phone'];

// Insert form data into the database
$sql = "INSERT INTO users (name, email, phone) VALUES ('$name', '$email', '$phone')";

if (mysqli_query($conn, $sql)) {
    echo "<div class='container'>";
    echo "<h1>Success</h1>";
    echo "<p>Form data has been stored in the database.</p>";
    echo "</div>";
} else {
    echo "<div class='container'>";
    echo "<h1>Error</h1>";
    echo "<p>Error storing form data: " . mysqli_error($conn) . "</p>";
    echo "</div>";
}

// Close the database connection
mysqli_close($conn);
?>
