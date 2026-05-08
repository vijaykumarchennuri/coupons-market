<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Login</title>

<link rel="stylesheet" href="/style.css">

</head>

<body>

<div class="app">

<div class="container">

<h2>Login</h2>

<form action="/login" method="post">

<input type="text"
name="username"
placeholder="Enter Username"
required>

<input type="password"
name="password"
placeholder="Enter Password"
required>

<button type="submit">
Login
</button>

</form>

<c:if test="${not empty error}">

<div class="error">

${error}

<br><br>

Don't have an account?

<a href="/register"
class="register-link">

Create Account

</a>

</div>

</c:if>

<div style="margin-top:15px; text-align:center;">

<a href="/register"
class="register-link">

Create New Account

</a>

</div>

</div>

</div>

</body>

</html>