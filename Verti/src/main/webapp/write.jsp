<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>문의사항 작성</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<style>
/* 문의사항 폼 스타일 */
#contact-wrapper {
	padding: 40px;
	background-color: #f8f8f8;
}

#contact-form {
	background-color: #fff;
	padding: 30px;
	border-radius: 8px;
	box-shadow: 0 3px 10px rgba(0, 0, 0, 0.1);
	max-width: 600px;
	margin: 0 auto;
}

#contact-form h2 {
	text-align: center;
	margin-bottom: 20px;
}

.input-wrapper {
	margin-bottom: 20px;
}

.input-wrapper label {
	font-weight: bold;
	margin-bottom: 5px;
	display: block;
}

.input-wrapper input, .input-wrapper textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

.input-wrapper textarea {
	height: 150px;
}

#submit-button {
	width: 100%;
	padding: 12px;
	background: #3cadd4;
	border: none;
	color: #fff;
	font-weight: bold;
	border-radius: 4px;
	cursor: pointer;
}

#submit-button:hover {
	background: #37a0c5;
}
</style>
</head>
<body class="is-preload homepage">
	<div id="page-wrapper">

		<!-- Header -->
		<jsp:include page="header.jsp" />

		<!-- 오류 메시지 출력 -->
		<%
		String errorMessage = (String) request.getAttribute("alertMessage");
		if (errorMessage != null) {
		%>
		<div
			style="color: red; padding: 10px; border: 1px solid red; margin: 10px 0;">
			<%=errorMessage%>
		</div>
		<%
		}
		%>

		<!-- 문의사항 글쓰기 섹션 -->
		<div id="contact-wrapper">
			<div id="contact-form">
				<h2>문의사항 작성</h2>
				<form action="write.do" method="post">
					<!-- 이름 입력 -->
					<div class="input-wrapper">
						<label for="title">제목</label> <input type="text" name="title"
							id="title" required />
					</div>

					<!-- 이메일 입력 -->
					<div class="input-wrapper">
						<label for="id">아이디</label> <input type="text" name="id" id="id"
							required />
					</div>

					<!-- 문의사항 입력 -->
					<div class="input-wrapper">
						<label for="content">문의 내용</label>
						<textarea name="content" id="content" required></textarea>
					</div>

					<!-- 제출 버튼 -->
					<button type="submit" id="submit-button">제출</button>
				</form>
			</div>
		</div>

		<!-- Footer -->
		<jsp:include page="footer.jsp" />

	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.dropotron.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>
</html>
