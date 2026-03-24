<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link rel="stylesheet" href="assets/css/main.css" />
<style>
table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

table, th, td {
	border: 1px solid #ccc;
}

th, td {
	padding: 10px;
	text-align: center; /* 글자 가운데 정렬 */
	color: black; /* 글자 색을 검은색으로 지정 */
}

th {
	background-color: #f2f2f2;
}
</style>
</head>
<body>
	<div id="page-wrapper">
		<!-- Header -->
		<jsp:include page="header.jsp" />

		<form method="get" action="list.do">
			<table>
				<tr>
					<td><input type="text" name="searchWord"
						placeholder="검색어를 입력하세요" value="${param.searchWord}" /> <input
						type="submit" value="검색" /></td>
				</tr>
			</table>
		</form>

		<div class="content">
			<h2>게시판 목록</h2>

			<p>총 게시물 수: ${totalCount}</p>

			<!-- 게시물이 없을 경우 -->
			<c:if test="${not empty noResultsMessage}">
				<p>${noResultsMessage}</p>
			</c:if>

			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
						<th>상세보기</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty boardLists}">
							<tr>
								<td colspan="6">등록된 게시물이 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="board" items="${boardLists}">
								<tr>
									<td style="text-align: center; color: black;">${board.num}</td>
									<td style="text-align: center; color: black;">${board.title}</td>
									<td style="text-align: center; color: black;">${board.id}</td>
									<td style="text-align: center; color: black;">${board.postdate}</td>
									<td style="text-align: center; color: black;">${board.visitcount}</td>
									<td><a href="view.do?num=${board.num}"
										style="color: black; text-align: center;">상세보기</a></td>
								</tr>

							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>

			<button onclick="location.href='write.do'">글쓰기</button>
		</div>





		<!-- Footer -->
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
