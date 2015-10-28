<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/login-box.css" type="text/css">
<title>Register</title>
</head>
<body>

		<script type="text/javascript">
			function validUserName(user) {
				if (user == "") {
					document.getElementById("userspan").innerHTML = "*reqired";
				} else {
					var iChars = "~`!#$%^&*+=-[]\\\';,/{}|\":<>?";
					for (var i = 0; i < user.length; i++) {
						if (iChars.indexOf(user.charAt(i)) != -1) {
							document.getElementById("userspan").innerHTML = "invalid special charecters";
							return false;
						} else {
							document.getElementById("userspan").innerHTML = "";
							return true;
						}
					}
				}
			}

			function validEmail(mail) {
				if (mail === "") {
					document.getElementById("mailspan").innerHTML = "*please enter mail";
					
				} else {
					var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
					if (re.test(mail)) {
						document.getElementById("mailspan").innerHTML = "";
						return true;
					} else {
						document.getElementById("mailspan").innerHTML = "*invalid mail";

						return false;

					}
				}

			}

			function validPassword(pass1, pass2) {
				if (pass1 == "" || pass2 == "") {
					document.getElementById("passspan").innerHTML = "*please enter password";
					document.getElementById("repassspan").innerHTML = "*please enter password";
					
					return false
				} else {
					if (pass1 == pass2) {
						document.getElementById("passspan").innerHTML = "";
						document.getElementById("repassspan").innerHTML = "";
						return true;
					} else {
						document.getElementById("passspan").innerHTML = "*unmatched password";
						document.getElementById("repassspan").innerHTML = "*unmatched password";
						return false;
					}
				}
			}

			function validBirthday(birthday) {
				var today = new Date();
				var todayday = today.getDate();
				var todaymonth = today.getMonth() + 1;
				var todayyear = today.getFullYear();

				var dateParts = birthday.split("-");


				if (todayyear < dateParts[0]) {
					document.getElementById("birthspan").innerHTML = "*invalid date";
					return false;
				} else {
					document.getElementById("birthspan").innerHTML = "";
					return true;
				}
			}

			function validationfun() {
				
				var username = document.getElementById("username").value;
				var email = document.getElementById("email").value;
				var password = document.getElementById("password").value;
				var repassword = document.getElementById("repassword").value;
				var birthday = document.getElementById("birthday").value;
				validUserName(username);
				validPassword(password, repassword);
				validBirthday(birthday);
				validEmail(email);
				if (validUserName(username) == false || validPassword(password, repassword) == false || validBirthday(birthday) == false || validEmail(email) == false) {

					return false;
				} else {

					return true;
				}
			}
		</script>

<br/><br/>

	<div class="body">
		<div id="featured">
			<div id="contect">
				<form action="RegisterServlet" method="Post" enctype="multipart/form-data" onsubmit="return validationfun()" >
					<table style="width: 100%; height: 100%">
						<tr>
							<td><div id="login-box-name">Name:</div></td>
							<td><input class="form-login" type="text" name="username" id="username" /><span id="userspan"></span></td>

							<td><div id="login-box-name">Email:</div></td>
							<td><input class="form-login" type="text" name="email" id="email" /><span id="mailspan"></span></td>
						</tr>
						<tr>
							<td><div id="login-box-name">Password:</div></td>
							<td><input class="form-login" type="password"
								name="password"  id="password"/><span id="passspan"></span></td>

							<td><div id="login-box-name">Birthday:</div></td>
							<td><input class="form-login" type="date" name="birthday" id="birthday"/><span id="birthspan"></span></td>
						</tr>
						
						
						<tr>
							<td><div id="login-box-name">re-enter password:</div></td>
							<td><input class="form-login" type="password"
								name="repassword"  id="repassword"/><span id="repassspan"></span></td>
						</tr>
						
						
						<tr>
							<td><div id="login-box-name">Job:</div></td>
							<td><input class="form-login" type="text" name="job" id="job"/></td>

							<td><div id="login-box-name">Address:</div></td>
							<td><input class="form-login" type="text" name="address" id="address" /></td>
						</tr>
						<tr>
							<td><div id="login-box-name">Image:</div></td>
							<td><input class="form-login" type="file" name="image" /></td>

							<td><div id="login-box-name">Interests:</div></td>
							<td><input class="form-login" type="text" name="interests" /></td>
						</tr>
					</table>
					<br />
					<center>
						<input type="submit" class="button" value="Register" />
					</center>
				</form>
			</div>
		</div>
	</div>
</body>
</html>