<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256" session="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Recharge</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
	<div class="body">
	<div id="featured">
       <form action="recharge" method="post">
         <br> Enter Code : <input type="text" name="serial"><br>
         <input type="submit"class="button" value="Recharge"> 
       </form>
        <c:set var="Msg" value="${requestScope.Msg}"></c:set>
        <c:set var="currentCredit" value="${requestScope.currentCredit}"></c:set>
        <c:if test="${not empty Msg}">
            <b> ${Msg}</b>
        </c:if>
        <c:if test="${not empty currentCredit}">
            <b> Your Credit Now : ${currentCredit}</b>
        </c:if>
        </div>
    </div>
</body>
</html>