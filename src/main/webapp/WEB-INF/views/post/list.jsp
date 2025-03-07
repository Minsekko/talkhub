<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 7.
  Time: 오전 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>TalkHub</title>
</head>
<h1>토크허브|<small>게시판 목록</small></h1>
<body>
<p>
    총${count}개의 게시판 글이 등록되어 있습니다.
</p>
</hr>
<c:forEach var="p" items="${posts}">
    <li style="">
        <div>
            <a href="${pageContext.request.contextPath}/post/view?id=${p.id}">${p.category} ${p.title}</a>
        </div>
        <div>
            ${p.writerid} | ${p.writedAt} | ${p.views} | ${p.likes}
        </div>
    </li>
</c:forEach>
</hr>
</body>
</html>
