<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TalkHub</title>
</head>
<body>
<h1>게시판 | <small>상세 보기</small></h1>
<p>
    글번호 (No.${PostRead.id}) ${PostRead.title}의 조회 결과입니다.
</p>
<hr/>
<h3>글제목: ${PostRead.title}</h3>
<p style="white-space: pre-wrap">${PostRead.content}</p>
</body>
</html>