<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<link href="../css/admin.css" rel="stylesheet" type="text/css" />
		<link href="../css/login-box.css" rel="stylesheet" type="text/css" />
        <link href="../css/style.css" rel="stylesheet" type="text/css" />
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Category</title>
</head>
<body>

<br/><br/>
	<div class="body">
		<div id="featured">
			<div id="contect">
				<form action="../admin/addcategory" method="Post">
					<table style="width: 100%; height: 100%">
						<tr>
							<td><div id="login-box-name">Category Name :</div></td>
							<td><input class="form-login" type="text" name="CatName" /></td>
							
						</tr>
						
					</table>
					<br />
					<center>
						<input type="submit" class="button" value="Add" />
					</center>
				</form>
				<c:set var="Msg" value="${requestScope.Msg}"></c:set>
				<c:if test="${not empty Msg}">
		            <b> ${Msg}</b>
		        </c:if>
			</div>
		</div>
	</div>
</body>
</html>