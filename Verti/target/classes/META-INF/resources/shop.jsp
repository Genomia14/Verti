<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>원두 구매 - Verti</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body class="is-preload no-sidebar">
		<div id="page-wrapper">

			<!-- Header -->
				<jsp:include page="header.jsp"/>

			<!-- Main -->
				<div id="main-wrapper">
					<div class="container">
						
                        <div id="content">
                            <article>
                                <h2 style="text-align: center; margin-bottom: 2em; font-size: 2.5em;">원두 스토어</h2>
                                <p style="text-align: center; margin-bottom: 3em;">전문 로스터가 직접 볶은 신선한 프리미엄 스페셜티 원두를 온라인으로 만나보세요.</p>
                            </article>
                        </div>

                        <!-- Features (Shop items) -->
                        <div class="row">
                            <!-- Product 1 -->
                            <div class="col-4 col-12-medium">
                                <section class="box feature">
                                    <a href="#" class="image featured"><img src="/images/Ethiopia Bean.jpg" alt="" style="height:250px; object-fit:cover;" /></a>
                                    <div class="inner">
                                        <header>
                                            <h2 style="font-size: 24px;">에티오피아 예가체프</h2>
                                            <p style="color: #ed786a; font-weight: bold; font-size: 1.2em;">15,000원 <span style="font-size: 0.7em; color:#888;">/ 200g</span></p>
                                        </header>
                                        <p>은은한 꽃향기와 기분 좋은 과일의 산미가 완벽하게 어우러진 대표적인 스페셜티 커피</p>
                                        <a href="javascript:void(0);" onclick="alert('에티오피아 예가체프 상품이 장바구니에 담겼습니다!');" class="button alt icon solid fa-shopping-cart" style="width:100%; text-align:center; padding-left: 0;">장바구니 담기</a>
                                    </div>
                                </section>
                            </div>
                            
                            <!-- Product 2 -->
                            <div class="col-4 col-12-medium">
                                <section class="box feature">
                                    <a href="#" class="image featured"><img src="/images/Bean_Guatemala.jpg" alt="" style="height:250px; object-fit:cover;" /></a>
                                    <div class="inner">
                                        <header>
                                            <h2 style="font-size: 24px;">과테말라 안티구아</h2>
                                            <p style="color: #ed786a; font-weight: bold; font-size: 1.2em;">14,000원 <span style="font-size: 0.7em; color:#888;">/ 200g</span></p>
                                        </header>
                                        <p>화산재 토양에서 자라 스모키한 향과 화려한 바디감을 자랑하는 매력적인 커피입니다.</p>
                                        <a href="javascript:void(0);" onclick="alert('과테말라 안티구아 상품이 장바구니에 담겼습니다!');" class="button alt icon solid fa-shopping-cart" style="width:100%; text-align:center; padding-left: 0;">장바구니 담기</a>
                                    </div>
                                </section>
                            </div>
                            
                            <!-- Product 3 -->
                            <div class="col-4 col-12-medium">
                                <section class="box feature">
                                    <a href="#" class="image featured"><img src="/images/Brazil Bean.jpg" alt="" style="height:250px; object-fit:cover;" /></a>
                                    <div class="inner">
                                        <header>
                                            <h2 style="font-size: 24px;">브라질 세하도</h2>
                                            <p style="color: #ed786a; font-weight: bold; font-size: 1.2em;">13,000원 <span style="font-size: 0.7em; color:#888;">/ 200g</span></p>
                                        </header>
                                        <p>부드러운 바디감과 고소한 견과류의 단맛, 산미가 적어 호불호 없이 즐기기 좋은 마일드 커피</p>
                                        <a href="javascript:void(0);" onclick="alert('브라질 세하도 상품이 장바구니에 담겼습니다!');" class="button alt icon solid fa-shopping-cart" style="width:100%; text-align:center; padding-left: 0;">장바구니 담기</a>
                                    </div>
                                </section>
                            </div>
                        </div> <!-- row -->

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
