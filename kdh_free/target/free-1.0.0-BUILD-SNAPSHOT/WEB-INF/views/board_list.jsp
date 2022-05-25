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
    <link rel="stylesheet" href="/free/resources/static/views/board_list.css" type="text/css"/>
</head>
<body>
<div style="height: 100%; background-color: #f1f1f1">
    <jsp:include page="components/top_menu.jsp"/>
    <div class="board_component">
        <div class="board_table">

            <div class="board_top_menu">
                <div>
                    <h1>${mode}</h1>
                </div>
            </div>
            <div>
                <table class="board_list_table">
                    <tr class="board_list_header">
                        <th class="board_list_title">Title</th>
                        <th class="board_list_language">Language</th>
                        <th class="board_list_postDate">PostDate</th>
                        <th class="board_list_userId">UserId</th>
                    </tr>
                    <c:forEach var="post" items="${posts}">
                        <tr>
                            <td class="board_list_td_title"><a href="/free/board/${mode}/${post.id}"><c:out value="${post.title}"/></a></td>
                            <td><c:out value="${post.language}"/></td>
                            <td><c:out value="${post.postDate}"/></td>
                            <td><c:out value="${post.userId}"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="board_list_write_button"><a href="/free/board/write/${mode}"><img
                    src="/free/resources/static/images/plus-icon.png" width="40px" height="40px"/> </a></div>
        </div>
    </div>
    <jsp:include page="components/footer.jsp"/>
</div>
</body>
</html>
