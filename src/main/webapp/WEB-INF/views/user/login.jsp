<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 4.
  Time: 오후 6:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/login-proceed">
    <input type="text" name="id">
    <input type="password" name="password">
    <button type="submit"> 사용자인증 </button>
</form>
</body>
</html>