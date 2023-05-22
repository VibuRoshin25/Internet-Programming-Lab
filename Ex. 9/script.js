function getUserDetails() {
    var userId = document.getElementById("userId").value;

    // Create a new XMLHttpRequest object
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var xmlDoc = xhr.responseXML;
                var users = xmlDoc.getElementsByTagName("user");
                var userDetails = document.getElementById("userDetails");

                userDetails.innerHTML = "";

                for (var i = 0; i < users.length; i++) {
                    var id = users[i].getElementsByTagName("id")[0].textContent;
                    if (id === userId) {
                        var name = users[i].getElementsByTagName("name")[0].textContent;
                        var email = users[i].getElementsByTagName("email")[0].textContent;
                        var phone = users[i].getElementsByTagName("phone")[0].textContent;

                        userDetails.innerHTML += "<h3>User Details:</h3>";
                        userDetails.innerHTML += "<p><strong>Name:</strong> " + name + "</p>";
                        userDetails.innerHTML += "<p><strong>Email:</strong> " + email + "</p>";
                        userDetails.innerHTML += "<p><strong>Phone:</strong> " + phone + "</p>";
                        return;
                    }
                }

                userDetails.innerHTML = "User not found!";
            } else {
                console.log("Error: " + xhr.status);
            }
        }
    };

    // Open and send the GET request to the XML file
    xhr.open("GET", "users.xml", true);
    xhr.send();
}
