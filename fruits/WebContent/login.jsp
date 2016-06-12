<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>SL Fruits</title>
<link href='http://fonts.googleapis.com/css?family=Oswald:400,300' rel='stylesheet' type='text/css' />
<link href='http://fonts.googleapis.com/css?family=Abel|Satisfy' rel='stylesheet' type='text/css' />
<link href="css/default.css" rel="stylesheet" type="text/css" media="all" />
<!--[if IE 6]>
<link href="default_ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->


</head>
<body>
	<div id="header-wrapper">
		<div id="header">
			<div id="logo">
				<h1>
					<a href="#">SL Fruits</a>
				</h1>
			</div>

		</div>

	</div>
	<div id="wrapper">
		<div id="page-wrapper">
			<div id="page">
				<div id="content">
					<div class="login">
						<%@include file="notification.jsp" %>
						<h1>Login</h1>
						
						<form action="doLogin" name="login1" method="post">
							<p>
								<input type="text" name="username" placeholder="Username" />
							</p>
							<p>
								<input type="password" name="password"  placeholder="Password"/>
							</p>
							
							
								<input class="button-style" type="submit" name="commit" value="Login"/>
							
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
	<div id="footer" class="container">
		<p>&copy; All rights reserved. Design by SL Fruits</p>
	</div>
</body></html>