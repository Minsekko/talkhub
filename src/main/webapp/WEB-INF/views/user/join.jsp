<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>회원가입 - TalkHub</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            width: 100%;
        }

        h1 {
            text-align: center;
            color: #3498db;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        p {
            text-align: center;
            color: #555;
            margin-bottom: 30px;
        }

        form div {
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-weight: bold;
            color: #333;
            margin-bottom: 5px;
        }

        input[type="text"], input[type="password"], select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            transition: border-color 0.3s ease;
        }

        input[type="text"]:focus, input[type="password"]:focus, select:focus {
            border-color: #3498db;
        }

        button {
            width: 100%;
            background-color: #3498db;
            color: white;
            padding: 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1.2em;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #2980b9;
        }

        .input-group {
            display: flex;
            flex-direction: column;
        }

        select {
            padding: 10px;
        }

        .required {
            color: red;
        }

        .form-note {
            text-align: center;
            font-size: 0.9em;
            color: #999;
            margin-top: 20px;
        }

        @media (max-width: 600px) {
            .container {
                padding: 20px;
            }

            button {
                font-size: 1em;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <h1>TalkHub</h1>
    <h2>회원가입</h2>
    <p><b>TalkHub</b>에 가입하고 자유롭게 이야기하세요!</p>

    <form action="${pageContext.request.contextPath}/user/join-proceed">
        <div class="input-group">
            <label for="id">아이디 <span class="required">(*)</span></label>
            <input type="text" id="id" name="id" placeholder="아이디를 입력하세요" required>
        </div>

        <div class="input-group">
            <label for="password">비밀번호 <span class="required">(*)</span></label>
            <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요" required>
        </div>

        <div class="input-group">
            <label for="nickname">활동명 <span class="required">(*)</span></label>
            <input type="text" id="nickname" name="nickname" placeholder="활동명을 입력하세요" required>
        </div>

        <div class="input-group">
            <label for="gender">성별 <span class="required">(*)</span></label>
            <select id="gender" name="gender" required>
                <option value="남">남</option>
                <option value="여">여</option>
                <option value="비공개">비공개</option>
            </select>
        </div>

        <div class="input-group">
            <label for="birth">출생년도 <span class="required">(*)</span></label>
            <select id="birth" name="birth" required>
                <c:forEach var="i" begin="1970" end="2025">
                    <option value="${i}">${i}년</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit">가입하기</button>
    </form>

    <div class="form-note">
        <p>가입 시 제공한 정보는 TalkHub의 약관 및 개인정보 보호정책에 따라 보호됩니다.</p>
    </div>
</div>
</body>
</html>

