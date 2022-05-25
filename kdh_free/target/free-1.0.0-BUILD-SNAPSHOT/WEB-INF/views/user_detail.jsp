<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 베오
  Date: 2022-05-24
  Time: 오후 7:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DCode</title>
    <link rel="stylesheet" href="/free/resources/static/views/user_detail.css" type="text/css"/>
</head>
<body>
<div style="height: 100%; background-color: #f1f1f1">
    <jsp:include page="components/top_menu.jsp"/>
    <div class="user_detail" align=center>
        <div class="user_detail_component">
            <h1>User Detail</h1>
            <h2>USER_ID</h2>
            <p>
                <c:out value="${user.id}"/>
            </p>
            <h2>USER_JOINDATE</h2>
            <p>
                <c:out value="${user.joinDate}"/>
            </p>
        </div>
    </div>
</div>
<jsp:include page="components/footer.jsp"/>
</body>
</html>
