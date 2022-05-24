<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>DCode</title>
    <link rel="stylesheet" href="/free/resources/static/views/sign_up.css" type="text/css"/>
</head>
<body>
<div style="height: 100%; background-color: #f1f1f1">
    <jsp:include page="components/top_menu.jsp"/>
    <div class="sign_up_component">

        <div class="sign_up_enroll">
            <H2>회원가입</H2>

            <%--    <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">--%>
            <%--        로그인 에러입니다.<br>--%>
            <%--        예외 타입 : ${SPRING_SECURITY_LAST_EXCEPTION.getClass().name} <br>--%>
            <%--        메시지 : ${SPRING_SECURITY_LAST_EXCEPTION.message} <br>--%>
            <%--        <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>--%>
            <%--    </c:if>--%>

            <form class="sign_up_form" action="/free/auth/enroll" method="POST">
                <label><img src="../resources/static/images/user-icon.png" width="40px" height="40px"
                            alt="user.png"/><input type="text" name="id" placeholder="아이디를 입력해주세요."/></label>
                <label><img src="../resources/static/images/password-icon.png" width="40px" height="40px"
                            alt="user.png"/><input type="password" name="passwd" placeholder="비밀번호를 입력해주세요."/></label>
                <input class="sing_up_enroll_button" type="submit" value="회원가입"/>
            </form>
        </div>

    </div>
</div>
</body>
</html>