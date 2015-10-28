<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Login</title>

<link href="css/login-box.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>

<body>
	<center>
		<div>
			<div class="body">
				<div id="featured" style="height: 438px">
					<label style="color:red" ><c:out value="${requestScope.error}" /></label>
					<div id="login-box">
						<form action="login" method="post">
							<br /> <br />
							<table>
								<tr>
									<td>Email:</td>
									<td><input name="username" class="form-login"
										title="Email" value="" size="30" maxlength="2048" /></td>
								</tr>
								<tr>
									<td>Password:</td>
									<td><input name="password" type="password"
										class="form-login" title="Password" value="" size="30"
										maxlength="2048" /></td>
								</tr>
								<tr>
									<td colspan="2"><input type="checkbox" name="remeber"
										value="remeber" />Remember Me</td>
								</tr>
								<tr>
									<td colspan="2"><input type="submit" class="button"
										value="login" /></td>
								</tr>
							</table>
						</form>
					</div>
					<a href="RegisterForm.jsp" class="title" style="text-decoration: none;">Register</a>
				</div>
			</div>
		</div>
	</center>
</body>
</html>
