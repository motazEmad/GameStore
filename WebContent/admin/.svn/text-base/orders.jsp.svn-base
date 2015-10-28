<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<link href="../css/tablestyle.css" rel="stylesheet" type="text/css" />
<title>Orders</title>
</head>
<body>
	<jsp:include page="/admin/OrdersServlet"></jsp:include>
	<div class="background">
		<div class="body">
			<table id="hor-minimalist-b" style="width: 100%" cellspacing="20px">
				<tr>
					<th>Customer</th>
					<th>Game</th>
					<th>Quantity</th>
					<th>Date</th>
				</tr>
				<c:forEach items="${orders}" var="order">
					<tr>
						<td>${order.user.name}</td>
						<td>${order.game.name}</td>
						<td>${order.quantity}</td>
						<td>${order.date}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>