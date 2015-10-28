<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="../css/admin.css" rel="stylesheet" type="text/css" />
		<link href="../css/login-box.css" rel="stylesheet" type="text/css" />
        <link href="../css/style.css" rel="stylesheet" type="text/css" />
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<title>Register</title>
<script type="text/javascript">
		function priceAllNumeric()  
		{   
			var num = document.getElementsByName("price")[0].value;
			var numbers = /^[0-9]+$/;  
			if(num.match(numbers)==null)  
			{  
				alert("Invalid Price !!");
				return false;
				
			}  
			else  
			{  
				return true;
			}
		} 
		function quantityAllNumeric()  
		{   
			var num = document.getElementsByName("quantity")[0].value;
			var numbers = /^[0-9]+$/;  
			if(num.match(numbers)==null)  
			{  
				alert("Invalid Quantity !!");
				return false; 
				
			}  
			else  
			{  
				return true;
			}
		} 
		function nameValidation()
		{
		var name = document.getElementsByName("gameName")[0].value;
		var letters = /^[A-Za-z]+$/;  
		if( name=="")
		{
			alert("please insert game name !!")
			return false;
		}
		else
		{
			
			return true;
		}
	}
		////////////////////
		function checkForm()
		{
			if(nameValidation()==false)
				{
					return false;
				}
			else if(quantityAllNumeric()==false)
				{
					return false;
				}
			else if(priceAllNumeric()==false)
				{
			 		return false;
				}
			else
				{
					return true;
				}
		}


</script>
</head>

<body>

<c:set var="categories" value="${requestScope.categories}"></c:set>
<c:if test="${empty categories}">
  <jsp:include page="/admin/AddGameCategories"></jsp:include>     
</c:if>
<br/><br/>
	<div class="body">
		<div id="featured">
			<div id="contect">
				<form action="../admin/AddGame" method="Post" enctype="multipart/form-data">
					<table style="width: 100%; height: 100%">
						<tr>
							<td><div id="login-box-name">Name:</div></td>
							<td><input class="form-login" type="text" name="gameName" /></td>
							
						</tr>
						<tr>
							<td><div id="login-box-name">Category:</div></td>
							<td>
								<select name="category">
									<c:forEach items="${categories}" var="row">
										<option value="${row.id}"> ${row.name}</option>
									</c:forEach>
								</select>
							</td>
							
						<tr>
							<td><div id="login-box-name">Description:</div></td>
							<td><input class="form-login" type="text" name="desc"/></td>
						</tr>
						<tr>
							<td><div id="login-box-name">Price:</div></td>
							<td><input class="form-login" type="text"
								name="price" /></td>
						</tr>
						<tr>
							<td><div id="login-box-name">Quantity:</div></td>
							<td><input class="form-login" type="text" name="quantity" /></td>
						</tr>
						<tr>
							<td><div id="login-box-name">Image:</div></td>
							<td><input class="form-login" type="file" name="image" /></td>
						</tr>
					</table>
					<br />
					<center>
						<input type="submit" class="button" value="Insert" onclick="return checkForm()" />
					</center>
				</form>
			</div>
		</div>
	</div>
</body>
</html>