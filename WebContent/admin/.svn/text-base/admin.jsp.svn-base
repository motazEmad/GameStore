<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>

		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>
			Admin Home
		</title>
		<link href="../css/admin.css" rel="stylesheet" type="text/css" />
		<link href="../css/login-box.css" rel="stylesheet" type="text/css" />
        <link href="../css/style.css" rel="stylesheet" type="text/css" />
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
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
	
	}
		////////////////////
		function checkForm()
		{
			 if(quantityAllNumeric()==false)
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


<jsp:include page="/games"></jsp:include>
		<c:set var="categories" value="${requestScope.categories}"></c:set>
	<div class="background">
		<div class="body left-side" style="width: 250px;">
			<div id="feature">
				<div class="title">Games by Platform</div>

				<ul>
					<c:forEach items="${categories}" var="row">
					
					<form action="../admin/DeleteCategory" method="post">
						<c:if test="${row.id==param.category}">
							<li><h3><a href="admin.jsp?category=${row.id}"
							 style="text-decoration: none;color: #63634B;" class="selected">${row.name}</a></h3></li>
						<input type="hidden" name="cname" value="${row.name}"></input>
						<input type="submit" class ="button" value="delete"></input>
						
						</c:if>
						<c:if test="${row.id!=param.category}">
						<li><h3><a href="admin.jsp?category=${row.id}" 
							style="text-decoration: none;color: #63634B;">${row.name}</a></h3></li>
						<input type="hidden" name="cname" value="${row.name}"></input>
						<input type="submit" class ="button"value="delete"></input>
						
						
						</c:if>
						</form>
					</c:forEach>
					
				</ul>
				<br></br>
				<a href=addCategory.jsp ><button value="add-category" class="categorybutton">Add Category</button></a>
			</div>

			<c:set var="gamesList" value="${requestScope.GamesByCategories}"></c:set>
		</div>
		<div class="body" style="width: 600px;">
		
			<c:if test="${param.deleted==1}">
				 <b>Congrats,,deleted successfully !! </b>
				</c:if>
				<c:if test="${param.deleted==0}">
				 <b>failed to be deleted !! </b>
				</c:if>
			
		
		</div>
		<div class="body" style="width: 600px;">
			
			<ul class="blog2">
			
			<c:forEach items="${gamesList}" var="row">
			
				<li style="height: 450px">
					<div>
					<br/>
					<div class="title">
						<a href="game?gn=${row.name}">${row.name}</a>
					</div>
					<p style="float: left;">
						<center><a href="game?gn=${row.name}"><img width="200" height="120" src="../images?Game=${row.name}" /></a></center>
						<p style="margin: 10px;">${row.description} 
						<form action="../admin/EditGame" method="post" style="float: left;">
						Price:<input type="text" name="price" value="${row.price}"></input> &nbsp;&nbsp;
						quantity : <input type="text" name="quantity" value="${row.quantity}"></input>
						<input type="hidden" name="gameName" value="${row.name}"></input>
						<input type="submit" class="button" value="Edit" onclick="checkForm()"></input>
						 </form>
						 <form action="../admin/DeleteGame" method="post" style="float: left;">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="hidden" name="gameName" value="${row.name}"></input>  
						<button value="delete" class="button">Delete</button>
						
						</form>
						</p>
						
						</p>
						
						 
					</div>
				</li>
				</c:forEach>
				
				<a href="AdminAddGame.jsp"><input type="button" class ="categorybutton" value="Add Game"></input></a>
			
			</ul>
		</div>
	</div>
</div>
</body>
</html>
	
