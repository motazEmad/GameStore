<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<link rel="stylesheet" href="../css/style.css" type="text/css" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Cart</title>
</head>
<body>
	<div class="body" style="width: 600px;">
		<div class="title">Cart</div>
		<c:if test="${not empty Msg}">
            <b> ${Msg}</b>
        </c:if>
		<ul class="blog2">
			<c:forEach items="${requestScope.gamesList}" var="row">
				<li style="height: 300px">
					<div>
						<br />
						<div style="float: right; width: 115px;">
							<a href="removeFromCart?op=buy&gn=${row.game.name}" title="buy">
								<img src="../images/dollar-icon.png" />
							</a>
							<a href="removeFromCart?op=decrement&gn=${row.game.name}" title="decrement">
								<img src="../images/remove-icon.png" />
							</a>
							<a href="removeFromCart?op=delete&gn=${row.game.name}" title="delete">
								<img src="../images/delete-icon.png" />
							</a>
						</div>
						<div class="title" style="width: 485px;">
							<a style="color: gray;text-decoration: none;" href="../game?gn=${row.game.name}">${row.game.name}</a>
						</div>
						<p style="float: left;">
						<center>
							<a href="../game?gn=${row.game.name}"><img width="200"
								height="120" src="../images?Game=${row.game.name}" /></a>
						</center>
						<p style="float: left; margin: 10px;">
							${row.game.description} <br /> <b>Price:</b> ${row.game.price} $
							<br /> <b>Quantity:</b> ${row.quantity}
						</p>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>