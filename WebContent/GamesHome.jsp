<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<link rel="stylesheet" href="css/style.css" type="text/css">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Games</title>
</head>
<body>
<jsp:include page="/games"></jsp:include>
	<c:set var="categories" value="${requestScope.categories}"></c:set>
	<div class="background">
		<div class="body left-side" style="width: 250px;">
			<div id="feature">
				<div class="title">Games by Categories</div>

				<ul>
					<c:forEach items="${categories}" var="row">
						<c:if test="${row.id==param.category}">
							<li><h3><a href="GamesHome.jsp?category=${row.id}"
							 style="text-decoration: none;color: #63634B;" class="selected">${row.name}</a></h3></li>
						</c:if>
						<c:if test="${row.id!=param.category}">
						<li><h3><a href="GamesHome.jsp?category=${row.id}" 
							style="text-decoration: none;color: #63634B;">${row.name}</a></h3></li>
						</c:if>
					</c:forEach>
				</ul>
			</div>

			<c:set var="gamesList" value="${requestScope.GamesByCategories}"></c:set>
		</div>
		<div class="body" style="width: 600px;">
			<ul class="blog2">
			<c:forEach items="${gamesList}" var="row">
				<li style="height: 300px">
					<div>
					<br/>
					<div class="title">
						<a style="color: gray;text-decoration: none;" href="game?gn=${row.name}">${row.name}</a>
					</div>
					<p style="float: left;">
						<center><a href="game?gn=${row.name}"><img width="200" height="120" src="images?Game=${row.name}" /></a></center>
						<p style="float: left;margin: 10px;">${row.description} <br /> <br />
						<b>Price:</b> ${row.price} $
						</p> 
					</div>
				</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>