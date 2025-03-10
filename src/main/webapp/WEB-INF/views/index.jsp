<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TalkHub</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(135deg, #6D83F2, #4CAF50);
            color: #fff;
            height: 100vh;
            display: flex;
            flex-direction: column;
        }

        header {
            background-color: rgba(0, 0, 0, 0.2);
            padding: 30px;
            text-align: center;
            color: white;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
        }

        header h1 {
            margin: 0;
            font-size: 3em;
            font-weight: bold;
            letter-spacing: 2px;
            text-transform: uppercase;
            animation: fadeInDown 1s ease;
        }

        nav {
            display: flex;
            justify-content: center;
            margin: 20px 0;
            animation: fadeInUp 1.5s ease;
        }

        nav a {
            margin: 0 20px;
            text-decoration: none;
            color: #fff;
            font-weight: bold;
            font-size: 1.2em;
            background-color: rgba(0, 0, 0, 0.3);
            padding: 15px 30px;
            border-radius: 50px;
            transition: background-color 0.3s, box-shadow 0.3s, transform 0.3s;
        }

        nav a:hover {
            background-color: rgba(0, 0, 0, 0.6);
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.3);
            transform: translateY(-5px);
        }

        .content {
            text-align: center;
            flex-grow: 1;
            display: flex;
            flex-direction: column;
            justify-content: center;
            animation: fadeIn 2s ease;
        }

        .content p {
            font-size: 2em;
            margin-bottom: 10px;
            line-height: 1.6;
        }

        .content p.subtext {
            font-size: 1.2em;
            color: rgba(255, 255, 255, 0.8);
        }

        footer {
            background-color: rgba(0, 0, 0, 0.5);
            color: white;
            text-align: center;
            padding: 15px 0;
            position: relative;
            bottom: 0;
            width: 100%;
            box-shadow: 0 -4px 10px rgba(0, 0, 0, 0.3);
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }

        @keyframes fadeInDown {
            from {
                opacity: 0;
                transform: translateY(-30px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        @keyframes fadeInUp {
            from {
                opacity: 0;
                transform: translateY(30px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
    </style>
</head>
<body>
<header>
    <h1>TalkHub</h1>
</header>

<c:choose>
    <c:when test="${authentication}">
        <!-- 로그인 상태 -->
        <nav>
            <a href="${pageContext.request.contextPath}/user/profile">마이페이지</a>
            <a href="${pageContext.request.contextPath}/post/list">게시판</a>
            <a href="${pageContext.request.contextPath}/user/logout">로그아웃</a>
        </nav>
    </c:when>
    <c:otherwise>
        <!-- 비로그인 상태 -->
        <nav>
            <a href="${pageContext.request.contextPath}/user/login">로그인</a>
            <a href="${pageContext.request.contextPath}/user/join">회원가입</a>
        </nav>
    </c:otherwise>
</c:choose>

<div class="content">
    <p>TalkHub에 오신 것을 환영합니다!</p>
    <p class="subtext">다양한 주제에 대해 토론하고, 새로운 사람들과 소통해 보세요.</p>
</div>

<footer>
    <p>&copy; 2025 TalkHub. All rights reserved.</p>
</footer>
</body>
</html>

