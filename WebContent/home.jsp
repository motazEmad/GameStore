<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<link rel="stylesheet" href="css/style.css" type="text/css">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Home</title>
</head>
<body>
	<div class="content">
			<div class="rm_wrapper">
				<div id="rm_container" class="rm_container">
					<ul>
						<li data-images="rm_container_1" data-rotation="-15"><img src="images/1.jpg"/></li>
						<li data-images="rm_container_2" data-rotation="-5"><img src="images/2.jpg"/></li>
						<li data-images="rm_container_3" data-rotation="5"><img src="images/3.jpg"/></li>
						<li data-images="rm_container_4" data-rotation="15"><img src="images/4.jpg"/></li>
					</ul>
					<div id="rm_mask_left" class="rm_mask_left"></div>
					<div id="rm_mask_right" class="rm_mask_right"></div>
					<div id="rm_corner_left" class="rm_corner_left"></div>
					<div id="rm_corner_right" class="rm_corner_right"></div>
					<h2>Gamezawy</h2>
					<div style="display:none;">
						<div id="rm_container_1">
							<img src="images/1.jpg"/>
							<img src="images/5.jpg"/>
							<img src="images/6.jpg"/>
							<img src="images/7.jpg"/>
						</div>
						<div id="rm_container_2">
							<img src="images/2.jpg"/>
							<img src="images/8.jpg"/>
							<img src="images/9.jpg"/>
							<img src="images/10.jpg"/>
						</div>
						<div id="rm_container_3">
							<img src="images/3.jpg"/>
							<img src="images/11.jpg"/>
							<img src="images/12.jpg"/>
							<img src="images/13.jpg"/>
						</div>
						<div id="rm_container_4">
							<img src="images/4.jpg"/>
							<img src="images/14.jpg"/>
							<img src="images/15.jpg"/>
							<img src="images/16.jpg"/>
						</div>
					</div>
				</div>
				<div class="rm_nav">
					<a id="rm_next" href="#" class="rm_next"></a>
					<a id="rm_prev" href="#" class="rm_prev"></a>
				</div>
				<div class="rm_controls">
					<a id="rm_play" href="#" class="rm_play">Play</a>
					<a id="rm_pause" href="#" class="rm_pause">Pause</a>
				</div>
			</div>
		</div>
	<div class="body">
	
	<center>
		<!-- <a href="game?gn=Assassin's Creed"><img src="images/home.jpg" width="768"
			height="480" /></a> -->
			
	</center>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.transform-0.9.3.min_.js"></script>
		<script type="text/javascript" src="js/jquery.mousewheel.js"></script>
		<script type="text/javascript" src="js/jquery.RotateImageMenu.js"></script>
	<jsp:include page="/BestGames"></jsp:include>
	<ul class="blog">
		<c:forEach items="${requestScope.bestGames}" var="best">
		<li style="height: 400px;">
			<div>
				<a href="game?gn=${best.name}"><img src="images?Game=${best.name}" width="258" height="172"></a>
				<p>${best.description}</p>
				<a href="game?gn=${best.name}">Read more</a>
			</div>
		</li>
		</c:forEach>
	</ul>
	</div>
</body>
</html>