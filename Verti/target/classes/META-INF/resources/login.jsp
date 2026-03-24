<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />

<style>
#login-box {
	max-width: 400px;
	margin: 80px auto;
	background: #fff;
	padding: 40px 30px;
	border-radius: 8px;
	box-shadow: 0 3px 15px rgba(0, 0, 0, 0.15);
}

#login-box h2 {
	text-align: center;
	margin-bottom: 25px;
	color: #444;
	font-weight: 600;
}

.input-wrapper {
	margin-bottom: 20px;
}

.input-wrapper label {
	font-weight: bold;
	margin-bottom: 5px;
	display: block;
}

.input-wrapper input {
	width: 100%;
	padding: 12px 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

#login-button {
	width: 100%;
	padding: 12px;
	background: #3cadd4;
	border: none;
	color: #fff;
	font-weight: bold;
	border-radius: 4px;
	cursor: pointer;
	font-size: 1.05em;
}

#login-button:hover {
	background: #37a0c5;
}

.sub-links {
	text-align: center;
	margin-top: 15px;
}

.sub-links a {
	color: #3cadd4;
	text-decoration: none;
}
</style>
</head>

<body class="is-preload">

	<div id="page-wrapper">

		<!-- Header -->
		<jsp:include page="header.jsp" />

		<!-- 로그인 박스 -->
		<div id="main-wrapper">
			<div id="login-box">

				<h2>로그인</h2>

				<form action="login.do" method="post">
					<div class="input-wrapper">
						<label for="id">아이디</label>
						<input type="text" name="id" id="id" required />
					</div>

					<div class="input-wrapper">
						<label for="password">비밀번호</label>
						<input type="password" name="password" id="password" required />
					</div>

					<button type="submit" id="login-button">로그인</button>
				</form>

				<div class="sub-links">
					<a href="register.jsp">회원가입</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<jsp:include page="footer.jsp" />
	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.dropotron.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
</body>
</html>
