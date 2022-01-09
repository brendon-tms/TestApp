const myForm = document.getElementById('myForm');

let firstName = document.getElementById('firstName');

myForm.addEventListener('submit', function(e) {
    e.preventDefault();

  let result = document.querySelector('#firstName');
  let name = document.querySelector('#lastName');
  let email = document.querySelector('#email');
  let password = document.querySelector('#password');
  let mobileNumber = document.querySelector('#mobileNumber');
  let company = document.querySelector('#company');
  let primaryRole = document.querySelector('#primaryRole');
  let emailVerified = document.querySelector('#emailVerified');
     
  // Creating a XHR object
  let xhr = new XMLHttpRequest();
  let url = "http://localhost:8080/TestApp/users";

  // open a connection
  xhr.open("POST", url, true);

  // Set the request header i.e. which type of content you are sending
  xhr.setRequestHeader("Content-Type", "application/json");

  // Create a state change callback
  xhr.onreadystatechange = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {

          // Print received data from server
          result.innerHTML = this.responseText;

      }
  };

  // Converting JSON data to string
  var data = JSON.stringify(
      { 
          "firstName": name.value, 
          "lastName": lastName.value, 
          "email": email.value, 
          "password": password.value,
          "mobileNumber": mobileNumber.value,
          "company": company.value,
          "primaryRole": primaryRole.value,
          "emailVerified": emailVerified.value
      }
);

  // Sending data with the request
  xhr.send(data);
  console.log(data);


});

