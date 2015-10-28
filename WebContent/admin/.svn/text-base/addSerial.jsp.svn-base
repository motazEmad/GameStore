<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/style.css" type="text/css">
<link rel="stylesheet" href="../css/login-box.css" type="text/css">
<title>Add Credit Serial</title>
</head>
<body>

<br/><br/>
	<div class="body">
		<div id="featured">
			<div id="contect">
				<form action="AddCreditSerial" method="Post">
					<table style="width: 100%; height: 100%">
						<tr>
							<td><div id="login-box-name">Serial:</div></td>
							<td><input class="form-login" type="text" name="serial" /></td>
							
						</tr>
						<tr>
							<td><div id="login-box-name">Value:</div></td>
							<td><input class="form-login" type="text"
								name="value" /></td>
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