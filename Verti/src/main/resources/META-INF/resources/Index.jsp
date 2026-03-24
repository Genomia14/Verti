<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>Verti</title>

<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body class="is-preload homepage">
	<div id="page-wrapper">

		<!-- Header -->
		<jsp:include page="header.jsp" />


		<!-- Features -->
		<div id="features-wrapper">
			<div class="container">
				<div class="row">
					<div class="col-4 col-12-medium">

						<!-- Box -->
						<section class="box feature">
							<a href="/menu.jsp" class="image featured"><img
								src="<%=request.getContextPath()%>/images/Beans.jpg" style="height:250px; object-fit:cover;" /></a>
							<div class="inner">
								<header>
									<h2 style="font-size: 30px; text-align: center;">원두란?</h2>
								</header>
								<p style="font-size: 15px; text-align: center;">커피콩은 커피나무 열매의 씨앗으로, 향긋한 커피 한 잔의 핵심 재료입니다. 로스팅을 통해 숨겨진 다채로운 맛과 향이 피어납니다.</p>
							</div>
						</section>

					</div>
					<div class="col-4 col-12-medium">

						<!-- Box -->
						<section class="box feature">
							<a href="/shop.jsp" class="image featured"><img
								src="/images/Index_Bean1.jpg" alt="" style="height:250px; object-fit:cover;" /></a>
							<div class="inner">
								<header>
									<h2 style="font-size: 30px; text-align: center;">프리미엄 원두</h2>
								</header>
								<p style="font-size: 15px; text-align: center;">아라비카, 로부스타 등 전 세계 각지에서 생산되는 매력적인 스페셜티 커피 원두들을 직접 둘러보고 구매해 보세요.</p>
							</div>
						</section>

					</div>
					<div class="col-4 col-12-medium">

						<!-- Box -->
						<section class="box feature">
							<a href="/list.do" class="image featured"><img
								src="/images/Coffee_latte.jpg" alt="" style="height:250px; object-fit:cover;" /></a>
							<div class="inner">
								<header>
									<h2 style="font-size: 30px; text-align: center;">커뮤니티</h2>
								</header>
								<p style="font-size: 15px; text-align: center;">커피를 진심으로 사랑하는 사람들과 함께 유익한 정보를 공유하고 자유롭게 소통할 수 있는 열린 게시판입니다.</p>
							</div>
						</section>

					</div>
				</div>
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