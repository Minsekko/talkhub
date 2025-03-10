<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 목록 - TalkHub</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f2f5;
        }

        h1 {
            text-align: center;
            color: #3498db;
            padding: 20px 0;
        }

        .container {
            max-width: 1000px;
            margin: 0 auto;
            padding: 20px;
            background-color: white;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        p {
            font-size: 1.2em;
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }

        ul {
            list-style: none;
            padding: 0;
        }

        li {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            margin-bottom: 15px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
            transition: box-shadow 0.3s ease;
        }

        li:hover {
            box-shadow: 0 4px 16px rgba(0, 0, 0, 0.15);
        }

        a {
            text-decoration: none;
            color: #3498db;
            font-weight: bold;
            font-size: 1.1em;
        }

        a:hover {
            color: #2980b9;
        }

        .post-info {
            font-size: 0.9em;
            color: #666;
            margin-top: 10px;
        }

        .post-info span {
            margin-right: 10px;
        }

        hr {
            border: none;
            border-top: 1px solid #ddd;
            margin: 20px 0;
        }

        @media (max-width: 768px) {
            .container {
                padding: 10px;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <h1>TalkHub | <small>게시판 목록</small></h1>
    <p>총 ${count}개의 게시판 글이 등록되어 있습니다.</p>
    <hr/>

    <ul>
        <c:forEach var="p" items="${posts}">
            <li>
                <a href="${pageContext.request.contextPath}/post/view?id=${p.id}">
                    [${p.category}] ${p.title}
                </a>
                <div class="post-info">
                    <span>작성자: ${p.writerid}</span>
                    <span>작성일: ${p.writedAt}</span>
                    <span>조회수: ${p.views}</span>
                    <span>좋아요: ${p.likes}</span>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
