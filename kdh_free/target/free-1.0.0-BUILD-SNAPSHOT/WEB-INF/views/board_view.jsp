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
    <title>DCode</title>
    <link rel="stylesheet" href="/free/resources/static/views/board_view.css" type="text/css"/>
</head>
<body>
<div style="height: 100%; background-color: #f1f1f1">
    <jsp:include page="components/top_menu.jsp"/>
    <div class="board_view" align=center>
        <div class="board_view_component">
            <h1>${mode}</h1>

            <div class="board_view_top">
                <div class="board_view_top_title">
                    <h2>
                        <c:out value="${post.title}"/>
                    </h2>
                </div>

                <div class="board_view_top_sub">
                    <c:out value="${post.userId}"/> |

                    <c:out value="${post.language}"/>

                    <div class="board_view_post_date">
                        <c:out value="${post.postDate}"/>
                    </div>
                </div>

            </div>
            <div class="board_view_description">
                <aside id="markdown" contenteditable style="display:none"><c:out value="${post.description}"/></aside>
                <section id="output-html" style="text-align: left"></section>
                <script type="text/javascript" src="/free/resources/static/markdown.js"></script>

            </div>

            <div class="board_view_back"><a href="/free/board/${mode}"><img
                    src="/free/resources/static/images/arrow-back-icon.png" width="40px" height="40px"/></a></div>

            <c:if test="${viewer == post.userId}">
                <div style="display: flex">
                    <div class="board_view_modify">
                        <a href="/free/board/${mode}/modify?id=${post.id}">Modify</a>
                    </div>

                    <div class="board_view_delete">
                        <a href="/free/board/${mode}/delete?id=${post.id}">Delete</a>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
