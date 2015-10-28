<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<c:set var="Msg" value="${requestScope.Msg}"></c:set>
<c:set var="currentCredit" value="${requestScope.currentCredit}"></c:set>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/GameStore/css/style.css" type="text/css">
<title>${requestScope.gameBean.name}</title>
</head>
<body>
	<div class="background">
		<div class="body left-side">
			<div class="title">${requestScope.gameBean.name}</div>
			<ul class="blog2">
				<li>
					<div style="height:359px">
						<p>
						<a href="/GameStore/GamesHome.jsp?category=${requestScope.gameBean.category.id}"><b style="padding: 0 0 0 23px;">Category: ${requestScope.gameBean.category.name}</b></a> <br />
						<center>
							<img width="300" height="168" src="/GameStore/images?Game=${requestScope.gameBean.name}" />
						</center>
						<p>${requestScope.gameBean.description} <br />
						<b>Price:</b> ${requestScope.gameBean.price} $
						</p> 
						<a href="/GameStore/user/AddToCart?gameName=${requestScope.gameBean.name}" class="more">Add to cart</a>
					</div>
					<br/><br/>
					<a href="/GameStore/user/Purchase?gn=${requestScope.gameBean.name}" class="title">purchase</a>
				</li>
			</ul>
	<c:if test="${not empty Msg}">
            <b> ${Msg}</b>
        </c:if>
        <c:if test="${not empty currentCredit}">
            <b> Your Credit Now : ${currentCredit}</b>
        </c:if>
		</div>
		<div class="body" style="width: 400px">
			<div class="title">Other Games</div>
			<ul class="blog">
				<c:forEach items="${requestScope.similarGames}" var="similarGame">
					<li><div><a href="/GameStore/game?gn=${similarGame.name}" class="figure"><img  width="250" height="168"
							src="/GameStore/images?Game=${similarGame.name}" alt=""></a> <span><a
							href="/GameStore/game?gn=${similarGame.name}"> ${similarGame.name} </a></span></div></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>