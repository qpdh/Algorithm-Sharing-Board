<%--
  Created by IntelliJ IDEA.
  User: 베오
  Date: 2022-05-23
  Time: 오후 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>DCode</title>
    <link rel="stylesheet" href="../resources/static/views/board.css" type="text/css"/>
</head>
<body>
<div style="height: 100%; background-color: #f1f1f1">
    <jsp:include page="components/top_menu.jsp"/>
    <div class="board_component">
        <div class="board_table">
            <table>
                <tr>
                    <th>title</th>
                    <th>language</th>
                    <th>postDate</th>
                    <th>userId</th>
                </tr>
                <c:forEach var="post" items="${posts}">
                    <tr>
                        <td><c:out value="${post.title}"/></td>
                        <td><c:out value="${post.language}"/></td>
                        <td><c:out value="${post.postDate}"/></td>
                        <td><c:out value="${post.userId}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
