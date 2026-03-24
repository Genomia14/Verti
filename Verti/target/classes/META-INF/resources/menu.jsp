<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>원두 소개 - Verti</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body class="is-preload left-sidebar">
		<div id="page-wrapper">

			<!-- Header -->
				<jsp:include page="header.jsp"/>

			<!-- Main -->
				<div id="main-wrapper">
					<div class="container">
						<div class="row gtr-200">
							<div class="col-4 col-12-medium">
								<div id="sidebar">

									<!-- Sidebar -->
										<section>
											<h3>원두 이야기</h3>
											<p>커피나무의 씨앗, 원두가 우리들의 일상에 들어오기까지의 여정을 소개합니다.</p>
										</section>

										<section>
											<h3>목차</h3>
											<ul class="style2">
												<li><a href="#definition">1. 원두의 정의</a></li>
												<li><a href="#characteristics">2. 원두의 특징</a></li>
												<li><a href="#types">3. 주요 원두 종류</a></li>
											</ul>
										</section>

								</div>
							</div>
							<div class="col-8 col-12-medium imp-medium">
								<div id="content">

									<!-- Content -->
										<article>

											<h2 id="definition">1. 커피 원두의 정의</h2>
											<p>커피 원두(Coffee Bean)는 꼭두서니과 커피나무속에 속하는 식물의 열매 안쪽에 있는 씨앗입니다. 빨갛게 익은 커피 체리의 과육을 벗겨내면 나오는 생두(Green Bean)를 열을 가해 볶는 '로스팅(Roasting)' 과정을 거치면, 비로소 우리가 아는 갈색의 커피 원두가 완성됩니다.</p>

											<h3 id="characteristics">2. 원두의 주요 특징</h3>
											<p>원두는 재배 지역의 고도, 기후, 토양 등의 '떼루아(Terroir)'에 따라 고유의 향미를 갖게 됩니다. 또한 생두를 볶는 가공 방식(로스팅 정도)에 따라 신맛, 단맛, 쓴맛, 바디감 등이 천차만별로 달라지는 특징이 있습니다. 로스팅이 약할수록 과일 같은 산미가 도드라지고, 강하게 볶을수록 묵직한 쓴맛과 다크초콜릿 향이 강해집니다.</p>

											<h3 id="types">3. 세계 3대 주요 원두 종류</h3>
											<p>전 세계에서 상업적으로 재배되는 커피 원두는 크게 세 가지 부류로 나뉩니다.</p>
											<ul>
												<li><strong>아라비카(Arabica):</strong> 전 세계 커피 생산량의 약 60~70%를 차지합니다. 해발 800m 이상의 고산지대에서 자라며, 병충해에 약해 재배가 까다롭지만 부드럽고 섬세한 산미와 풍부한 향기(아로마)를 지녀 가장 대중적으로 사랑받는 고급 원두입니다.</li>
												<li><strong>로부스타(Robusta):</strong> 덥고 습한 저지대에서도 잘 자라며 병충해에 매우 강합니다. 아라비카에 비해 카페인 함량이 약 2배로 높고, 구수하고 묵직한 바디감과 쓴맛이 강해 주로 인스턴트 커피나 에스프레소 블렌딩 용도로 사용됩니다.</li>
												<li><strong>리베리카(Liberica):</strong> 현재는 전체 생산량의 1% 미만을 차지하는 희귀한 종입니다. 쓴맛이 너무 강해 상업적 가치가 떨어져 서아프리카나 말레이시아 일부 지역에서만 자체 소비용으로 소량 재배됩니다.</li>
											</ul>

										</article>

								</div>
							</div>
						</div>
					</div>
				</div>

			<!-- Footer -->
				<jsp:include page="footer.jsp"/>

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