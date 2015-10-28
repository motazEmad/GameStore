
<html>

<head>

<title>Profile</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<link href="../css/templatemo_style.css" rel="stylesheet"
	type="text/css" />
</head>

<body>
<form method="post" action="../UserEdit">
	<div class="body">

	   <c:if test="${user.type==1}">
	 
	     <jsp:include page="/admin/findUser"></jsp:include>
	     <jsp:useBean id="currentUser" class="dto.User" scope="request"></jsp:useBean>
	   </c:if>
	   <c:if test="${user.type==0}">
	   		<jsp:useBean id="user" class="dto.User" scope="session"></jsp:useBean>
	   </c:if>
		<div id="featured" style="height: 583px;">
		
			<!-- end of left side bar -->


			<div class="body" style="float:left; width:500px">
				
				
				<div class="title">User Information</div>
				<div>Name:</div>
				<p>
					<c:if test="${user.type==0}">
					<span><input type=text name=user-name value="<jsp:getProperty name="user" property="name" />"></span>
					</c:if>
					<c:if test="${user.type==1}">
					<span><jsp:getProperty name="currentUser" property="name" /></span>
					</c:if>
				</p>
				<div>BirthDate:</div>
				<p>
				<c:if test="${user.type==0}">
					<span><input type=date name=user-birthdate value="<jsp:getProperty name="user" property="birthdayStr" />"></span>
				</c:if>
				<c:if test="${user.type==1}">
				<span><jsp:getProperty name="currentUser" property="birthday" /></span>
				</c:if>
				</p>

				<div>Job:</div>
				<p>
				<c:if test="${user.type==0}">
				
					<span><input type=text name=user-job value="<jsp:getProperty name="user" property="job" />"></span>
				</c:if>
				<c:if test="${user.type==1}">
									<span><jsp:getProperty name="currentUser" property="job" /></span>
				</c:if>
				</p>
				
				<div>Email:</div>
				<p>
				<c:if test="${user.type==0}">
					<span><input type=text name=user-email value="<jsp:getProperty name="user" property="email" />"></span>
				</c:if>
				<c:if test="${user.type==1}">
				<span><jsp:getProperty name="currentUser" property="email" /></span>
				</c:if>
				</p>


				<div>Address</div>
				<p>
				<c:if test="${user.type==0}">
					<span><input type=text name=user-address value="<jsp:getProperty name="user" property="address" />"></span>
				</c:if>
				<c:if test="${user.type==1}">
					<span><jsp:getProperty name="currentUser" property="address" /></span>
					</c:if>
				</p>


				<div>Credit</div>
				<p>
				<c:if test="${user.type==0}">
					<span><jsp:getProperty name="user" property="credit" /></span>
				</c:if>
				<c:if test="${user.type==1}">
					<span><jsp:getProperty name="currentUser" property="credit" /></span>
				</c:if>
					
				</p>


				<div>Interests</div>
				<p>
				<c:if test="${user.type==0}">
					<span><input type="text" name="user-interests" value="<jsp:getProperty name="user" property="interests" />"></span>
				</c:if>
				<c:if test="${user.type==1}">
					<span><jsp:getProperty name="currentUser" property="interests" /></span>
				</c:if>
				</p>
				<c:if test="${user.type==0}">
					<input type="submit" class="button" value="Save">
				</c:if>
			</div>
			<div>
			<c:if test="${user.type==0}">
				<img src="../images?Profile=pic" alt="your profile picture" width="150"
					height="150">
			</c:if>
			<c:if test="${user.type==1}">
				<img src="../images?Profile=<jsp:getProperty name="currentUser" property="email" />" alt="your profile picture" width="150"
					height="150">
			</c:if>
			</div>
		</div>
	</div>
	</form></body>
</html>