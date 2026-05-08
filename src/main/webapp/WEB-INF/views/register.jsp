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

</body>
</html>