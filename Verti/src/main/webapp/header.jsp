<%@page import="User.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Header</title>
</head>
<body>

<div id="header-wrapper">
    <header id="header" class="container">

        <!-- Logo -->
        <div id="logo">
            <h1>
                <a href="/">Verti</a>
            </h1>
            <span>by HTML5 UP</span>
        </div>

        <!-- Nav -->
        <nav id="nav">
            <ul>
                <li class="current"><a href="/">소개</a></li>
                <li><a href="#">Dropdown</a>
                    <ul>
                        <li><a href="#">Lorem ipsum dolor</a></li>
                        <li><a href="#">Magna phasellus</a></li>
                        <li><a href="#">Phasellus consequat</a>
                            <ul>
                                <li><a href="#">Lorem ipsum dolor</a></li>
                                <li><a href="#">Phasellus consequat</a></li>
                                <li><a href="#">Magna phasellus</a></li>
                                <li><a href="#">Etiam dolore nisl</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Veroeros feugiat</a></li>
                    </ul>
                </li>
                <li><a href="menu.jsp">메뉴</a></li>
                <li><a href="list.do">문의사항</a></li>

                <%
                if (session.getAttribute("loginUser") != null) { 
                UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
                %>
                    <li><a href="logout.do">로그아웃</a></li>
                    <li><span><%= loginUser.getId() %>님, 반갑습니다.</span></li>
                <% } else { %>
                    <li><a href="login.do">로그인</a></li>
                    <li><a href="register.do">회원가입</a></li>
                <% } %>
            </ul>
        </nav>

    </header>
</div>

</body>
</html>
