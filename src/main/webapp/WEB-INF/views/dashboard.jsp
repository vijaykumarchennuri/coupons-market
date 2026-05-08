<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c"%>

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

<!-- TOPBAR -->

<div class="topbar">

<h2>
Coupon Market
</h2>

<a href="/logout">

<button class="logout-btn">
Logout
</button>

</a>

</div>

<!-- CATEGORY -->

<div class="category-container">

<a href="/dashboard">
<div class="category">All</div>
</a>

<a href="/category/Food">
<div class="category">Food</div>
</a>

<a href="/category/Shopping">
<div class="category">Shopping</div>
</a>

<a href="/category/Lounge">
<div class="category">Lounge</div>
</a>

<a href="/category/Entertainment">
<div class="category">Entertainment</div>
</a>

</div>

<!-- ADD COUPON -->

<div class="container">

<h3>Add Coupon</h3>

<form action="/addCoupon" method="post">

<input type="text"
name="title"
placeholder="Coupon Title"
required>

<select name="category">

<option value="Food">Food</option>

<option value="Shopping">Shopping</option>

<option value="Lounge">Lounge</option>

<option value="Entertainment">Entertainment</option>

</select>

<input type="text"
name="couponCode"
placeholder="Coupon Code"
required>

<input type="number"
name="actualPrice"
placeholder="Actual Price"
required>

<input type="number"
name="discountedPrice"
placeholder="Discounted Price"
required>

<input type="date"
name="expiryDate"
required>

<input type="text"
name="phoneNumber"
placeholder="10 Digit Mobile Number"
maxlength="10"
pattern="[0-9]{10}"
oninput="this.value=this.value.replace(/[^0-9]/g,'').slice(0,10)"
required>

<button type="submit">
Add Coupon
</button>

</form>

<div class="success">${success}</div>

<div class="error">${error}</div>

</div>

<!-- COUPON LIST -->

<div class="cards-container">

<c:forEach items="${coupons}" var="c">

<div class="card">

<div class="card-top">

<div>

<h3>${c.title}</h3>

<p class="category-text">
${c.category}
</p>

</div>

<div class="price-box">

<p class="actual-price">
₹ ${c.actualPrice}
</p>

<p class="discount-price">
₹ ${c.discountedPrice}
</p>

</div>

</div>

<div class="coupon-box">

Voucher Code :
${c.couponCode}

</div>

<p class="expiry">

Expiry :
${c.expiryDate.dayOfMonth}
-${c.expiryDate.monthValue}
-${c.expiryDate.year}

</p>

<p class="posted">

Posted By :
${c.user.username}

</p>

<p class="phone">

📞 ${c.phoneNumber}

</p>

<!-- OWNER BUTTONS -->

<c:if test="${sessionScope.user.username eq c.user.username}">

<div class="btn-group">

<a href="/edit/${c.id}">

<button class="edit-btn">
Edit
</button>

</a>

<a href="/delete/${c.id}">

<button class="delete-btn">
Delete
</button>

</a>

</div>

</c:if>

</div>

</c:forEach>

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