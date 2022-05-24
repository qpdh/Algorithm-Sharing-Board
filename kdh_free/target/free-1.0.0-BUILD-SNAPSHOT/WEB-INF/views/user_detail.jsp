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
    <div align=center>
        <header>학생 정보</header>
        <br>
        <table>
            <tr>
                <th>LoginID</th>
                <td><c:out value="${user.id}"/></td>
            </tr>
            <tr>
                <th>JoinDate</th>
                <td><c:out value="${user.joinDate}"/></td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
