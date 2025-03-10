<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<h3>글제목: ${PostRead.title} | 조회수:${PostRead.views} | 추천수 ${PostRead.likes}</h3>

<c:choose>
    <c:when test="${alreadyLiked}">
        <button type="button" disabled> 이미추천하였습니다. </button>
    </c:when>
<c:otherwise>
    <a href="${pageContext.request.contextPath}/post/likes-proceed?id=${PostRead.id}">
        <button type="button">추천하기</button>
        </a>
</c:otherwise>
</c:choose>
<a href="${pageContext.request.contextPath}/post/list">목록</a>
<p style="white-space: pre-wrap">${PostRead.content}</p>
</body>
</html>