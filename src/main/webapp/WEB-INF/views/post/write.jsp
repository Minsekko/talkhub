<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 4.
  Time: 오후 2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TalkHub</title>
</head>
<body>
<h1>TalkHub</h1>
<div >
    <h2>토크허브 게시판</h2>
    <p>
        <b>TalkHub</b>에 게시판입니다 글작성 하시기 바랍니다.
    </p>
    <form action="${pageContext.request.contextPath}/post/write-proceed" method="post">
        <div >
            <label>작성자</label>
            <div>
                <input type="text" name="writerId" value="${writerid}"/>
            </div>
        </div>
        <div >
            <label>글종류(*)</label>
            <div>
                <input type="text" name="category"/>
            </div>
        </div>
        <div >
            <label>글제목</label>
            <div>
                <input type="text"  name="title"/>
            </div>
        </div>
        <div>
            <label>글내용</label>
            <div>
                <textarea name="content"></textarea>
            </div>
        </div>
        <div>
            <button type="submit">작성하기</button>
        </div>
    </form>
</div>
</body>
</html>

