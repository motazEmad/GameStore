<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<div class="page">
		<div class="header">
			<a href="/GameStore/home.jsp" id="logo"><img src="/GameStore/images/logo.gif" alt="" /></a>
			<ul>
				<li class="selected"><a href="/GameStore/home.jsp">Home</a></li>
				<li><a href="/GameStore/GamesHome.jsp?category=1">Games</a></li>
				<c:if test="${empty sessionScope.user.email}">
					<li><a href="/GameStore/login">Login/Register</a></li>
				</c:if>
				<li><a href="/GameStore/about.jsp">About</a></li>
			</ul>
			<ul>
				<c:if test="${not empty sessionScope.user.email}">
					<br/>
					<li>Welcome ${user.name}</li>
					<li><a href="/GameStore/user/profile.jsp">Edit Profile</a></li>
					<li><a href="/GameStore/user/recharge.jsp">Recharge ( ${user.credit} )</a>
					<li><a href="/GameStore/user/cart">Cart ( ${user.cart.itemsCount} )</a>
					<li><a href="/GameStore/user/logout">Logout</a>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>