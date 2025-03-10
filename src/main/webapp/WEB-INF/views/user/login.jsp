<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>로그인</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .login-container {
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }

        h2 {
            text-align: center;
            margin-bottom: 30px;
            font-size: 1.8em;
            color: #333;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 15px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 1em;
            box-sizing: border-box;
        }

        input[type="text"]:focus, input[type="password"]:focus {
            border-color: #4CAF50;
            outline: none;
            box-shadow: 0 0 5px rgba(76, 175, 80, 0.5);
        }

        button {
            width: 100%;
            padding: 15px;
            background-color: #4CAF50;
            color: white;
            font-size: 1.2em;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #45a049;
        }

        .message {
            text-align: center;
            margin-top: 20px;
            font-size: 0.9em;
            color: #555;
        }

        .message a {
            color: #4CAF50;
            text-decoration: none;
        }

        .message a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>로그인</h2>
    <form action="${pageContext.request.contextPath}/user/login-proceed" method="post">
        <input type="text" name="id" placeholder="아이디를 입력하세요" required>
        <input type="password" name="password" placeholder="비밀번호를 입력하세요" required>
        <button type="submit">사용자인증</button>
    </form>
    <div class="message">
        <p>계정이 없으신가요? <a href="${pageContext.request.contextPath}/user/join">회원가입</a></p>
    </div>
</div>
</body>
</html>
