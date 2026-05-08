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

<h2>Edit Coupon</h2>

<form action="/updateCoupon" method="post">

<input type="hidden"
name="id"
value="${coupon.id}">

<input type="text"
name="title"
value="${coupon.title}"
required>

<select name="category">

<option value="Food"
${coupon.category=='Food'?'selected':''}>
Food
</option>

<option value="Shopping"
${coupon.category=='Shopping'?'selected':''}>
Shopping
</option>

<option value="Lounge"
${coupon.category=='Lounge'?'selected':''}>
Lounge
</option>

<option value="Entertainment"
${coupon.category=='Entertainment'?'selected':''}>
Entertainment
</option>

</select>

<input type="text"
name="couponCode"
value="${coupon.couponCode}"
required>

<input type="number"
name="actualPrice"
value="${coupon.actualPrice}"
required>

<input type="number"
name="discountedPrice"
value="${coupon.discountedPrice}"
required>

<input type="date"
name="expiryDate"
value="${coupon.expiryDate}"
required>

<input type="text"
name="phoneNumber"
value="${coupon.phoneNumber}"
required>

<button type="submit">
Update Coupon
</button>

</form>

<div class="error">
${error}
</div>

</div>

</body>
</html>