<%--
  Created by IntelliJ IDEA.
  User: 베오
  Date: 2022-05-23
  Time: 오후 5:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>DCode</title>
    <link rel="stylesheet" href="/free/resources/static/views/components/top_menu.css" type="text/css"/>
</head>
<body>
<div class="top_menu_component">
    <h1>DCode</h1>
    <div class="top_menu_menu_div">

        <div class="top_menu_category">
            <a href="/free">Home</a>
            <a href="/free/board/algo">Algorithm</a>
            <a href="/free/board/data">DataStructure</a>
        </div>

        <div class="top_menu_auth_div">
            <sec:authorize access="!isAuthenticated()">
                <a href="/free/auth/sign_up">SignUp</a>
                <a href="/free/auth/sign_in">SingIn</a>
            </sec:authorize>

            <sec:authorize access="isAuthenticated()">
                <sec:authentication property="principal.username" var="user_id"/>
                <a href="/free/user_detail/${user_id}"><img src="/free/resources/static/images/user-icon.png"
                                                            width="40px"
                                                            height="40px"/></a>
                <form action="/free/logout" method="post">
                    <button>${user_id} Logout</button>
                </form>
            </sec:authorize>


        </div>

    </div>


</div>
</body>
</html>

