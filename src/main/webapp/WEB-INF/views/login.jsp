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

<div id="popupOverlay" class="popup-overlay">

    <div class="popup-box">

        <h2>Welcome to Coupons Market 🎉</h2>

        <p>

            Here you can buy and sell coupon codes
            at the best prices.

            Discover amazing offers on shopping,
            food, lounge access, entertainment
            and more!
            <br>   <b>  -Vijay Chennuri</b>

        </p>

        <button onclick="closePopup()">

            OK

        </button>

    </div>

</div>
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

<div id="footer"></div>

<script>

window.onload = function(){

    const footer = document.createElement("marquee");

    footer.className = "footer-marquee";

    footer.innerText =
    "© Developed by Vijay Kumar Chennuri-2026";

    document.body.appendChild(footer);
}

</script>
<script>

window.onload = function(){

    if(!sessionStorage.getItem("popupShown")){

        document.getElementById("popupOverlay")
        .style.display = "flex";

        sessionStorage.setItem("popupShown","true");

    }else{

        document.getElementById("popupOverlay")
        .style.display = "none";
    }
};

function closePopup(){

    document.getElementById("popupOverlay")
    .style.display = "none";
}

</script>
</body>

</html>