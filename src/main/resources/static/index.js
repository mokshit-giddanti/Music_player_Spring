function register()
{
    var url="http://localhost:8082/reg/new";
    var password = document.getElementById("pass1").value;
    var retypePassword = document.getElementById("pass2").value;
    if (password !== retypePassword) {
        document.getElementById("l1").innerText = "Passwords do not match!";
        return;
    }

    if (!isLengthValid(password)) {
        document.getElementById("l1").innerText = "minimum password length is 8";
        return;
    }
    if(!isNumeric(password)){
        document.getElementById("l1").innerText = "password should contain a numeric value";
        return;
    }
    if(!containsCaps(password)){
        document.getElementById("l1").innerText = "password should contain a capital";
        return;
    }
    if(!hasSpecial(password)){
        document.getElementById("l1").innerText = "password should contain a specail character";
        return;
    }

    var data=JSON.stringify({
        "name":name1.value,
        "email":email1.value,
        "password":pass1.value

    });

    callApi("POST",url,data,getResponse);
}
function getResponse(res)
{
    l2.innerText=res;
}
function callApi(METHOD,URL,DATA,SUCCESS)
{
    var xhttp=new XMLHttpRequest();
    xhttp.open(METHOD,URL,true)
    xhttp.setRequestHeader('Content-Type','application/json');
    xhttp.onreadystatechange=function()
    {
        if(this.readyState == 4)
        {
            if(this.status == 200)
                SUCCESS(this.responseText);
            else
                alert("404: Service unavailable");

        }

    };
    xhttp.send(DATA);
}
function isLengthValid(password){
    var lengthPattern = /.{8,}/;
    var isLengthValid = lengthPattern.test(password);
    return isLengthValid;
}
function containsCaps(password){
    var capitalPattern = /[A-Z]/;
    var hasCapitalLetter = capitalPattern.test(password);
    return hasCapitalLetter;
}
function isNumeric(password){
    var numericPattern = /[0-9]/;
    var hasNumericDigit = numericPattern.test(password);
    return hasNumericDigit;
}
function hasSpecial(password){
    var specialCharPattern = /[!@#$%^&*()_+{}\[\]:;<>,.?~\\-]/;
    var hasSpecialChar = specialCharPattern.test(password);
    return hasSpecialChar;
}
function login() {
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    var loginData = {
        email: email,
        password: password
    };

    fetch('/reg/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(loginData)
    })
        .then(response => response.text())
        .then(data => {
            if (data === 'Login Successful') {
                // Redirect to another page on successful login
                window.location.href = 'success.html';
            } else {
                // Display an alert for invalid credentials
                alert('Invalid credentials');
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
