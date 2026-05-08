<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html>

<head>

<meta charset="UTF-8">

<meta name="viewport"
content="width=device-width, initial-scale=1.0">

<title>Dashboard</title>

<link rel="stylesheet" href="/style.css">

</head>

<body>
<div class="main-header">

<div class="logo-section">

<img src="/images/logo.png"
class="logo-img">

<div>

<h2>CM - Coupons Market</h2>

<p>Save More, Shop More</p>

</div>

</div>



</div>

<div class="app">
<div class="container">

<h2>Register</h2>

<form action="/signup" method="post">

<input type="text" name="username" placeholder="Username">

<input type="password" name="password" placeholder="Password">

<input type="text" name="address" placeholder="Address">

<input type="text"
name="phoneNumber"
placeholder="Enter Mobile Number"
maxlength="10"
pattern="[0-9]{10}"
oninput="this.value=this.value.replace(/[^0-9]/g,'').slice(0,10)"
required>

<button type="submit">Register</button>

</form>

<div class="error">${error}</div>

</div>

<script>

window.onload = function(){

    const footer = document.createElement("marquee");

    footer.className = "footer-marquee";

    footer.innerText =
    "© Developed by Vijay Kumar Chennuri-2026";

    document.body.appendChild(footer);
}

</script>

</body>
</html>