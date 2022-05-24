<%--
  Created by IntelliJ IDEA.
  User: 베오
  Date: 2022-05-24
  Time: 오후 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="height: 100%; background-color: #f1f1f1">
    <jsp:include page="components/top_menu.jsp"/>
    <div align=center>
        <header>${mode}</header>
        <br>
        <table>
            <tr>
                <th>Title</th>
                <td><c:out value="${post.title}"/></td>
            </tr>
            <tr>
                <th>Description</th>
                <td><c:out value="${post.description}"/></td>
            </tr>
            <tr>
                <th>Language</th>
                <td><c:out value="${post.language}"/></td>
            </tr>
            <tr>
                <th>PostDate</th>
                <td><c:out value="${post.postDate}"/></td>
            </tr>
            <tr>
                <th>UserId</th>
                <td><c:out value="${post.userId}"/></td>
            </tr>
        </table>
        <a href="/free/board/${mode}">Go To List</a>
        <c:if test="${viewer == post.userId}">
            <form action="/free/board/${mode}" method="delete">
                <button>Delete This Post</button>
            </form>
        </c:if>
    </div>
</div>
</body>
</html>
