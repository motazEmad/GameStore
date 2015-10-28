<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<link rel="stylesheet" href="../css/style.css" type="text/css">
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
		<link href="../css/login-box.css" rel="stylesheet" type="text/css" />
        <link href="../css/style.css" rel="stylesheet" type="text/css" />
        
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Users</title>
</head>
<body>

<jsp:include page="/admin/GetUsers"></jsp:include>

<div class="body">
	<c:set var="users" value="${requestScope.users}"></c:set>
	
	<ul>
		<c:forEach items="${users}" var="row">
		
	     <li><h3><a href="../user/profile.jsp?userEmail=${row.email}">${row.email}</a></h3></li>
		
		</c:forEach>
	</ul>
	</div>
</body>
</html>