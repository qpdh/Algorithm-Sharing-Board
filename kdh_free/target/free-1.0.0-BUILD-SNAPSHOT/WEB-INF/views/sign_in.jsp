<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/free/resources/static/views/sign_in.css" type="text/css"/>
</head>
<body>
<div style="height: 100%; background-color: #f1f1f1">
    <jsp:include page="components/top_menu.jsp"/>
    <div class="sign_in_component">

        <div class="sign_in_login">
            <H2>SIGN IN</H2>

            <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                로그인 에러입니다.<br>
                예외 타입 : ${SPRING_SECURITY_LAST_EXCEPTION.getClass().name} <br>
                메시지 : ${SPRING_SECURITY_LAST_EXCEPTION.message} <br>
                <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
            </c:if>

            <form class="sign_in_form" action="processLogin" method="POST">
                <div style="display: flex; flex-direction: column">
                    <label><img src="../resources/static/images/user-icon.png" width="40px" height="40px"
                                alt="user.png"/><input class="sign_in_input"
                                                       type="text" name="paramLoginId"
                                                       placeholder="Enter the ID"/></label>
                    <label><img src="../resources/static/images/password-icon.png" width="40px" height="40px"
                                alt="user.png"/><input class="sign_in_input"
                                                       type="password" name="paramPassword" placeholder="Enter the PW"/></label>
                </div>
                <div>
                    <input class="sing_in_login" type="submit" value="SIGN IN"/>
                </div>
            </form>
            <a class="sign_in_enroll" href="/free/auth/sign_up">SIGN UP</a>
        </div>
    </div>

</div>
<jsp:include page="components/footer.jsp"/>
</body>
</html>