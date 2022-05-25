<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.userdetails.UserDetails" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
    <title>DCode</title>
    <link rel="stylesheet" href="/free/resources/static/views/home.css" type="text/css"/>

</head>
<body>
<div style="height: 100%; background-color: #f1f1f1;">
    <jsp:include page="components/top_menu.jsp"/>
    <div align="center" class="home">
        <div class="home_component">
            <h1>
                Welcome DCode!
            </h1>

            <a href="https://www.youngwonks.com/blog/What-is-an-Algorithm-and-What-are-the-Different-Types-of-Algorithms"
               target="_blank"><img src="/free/resources/static/images/what-is-algorithm.png"/></a>
        </div>
    </div>
    <jsp:include page="components/footer.jsp"/>
</div>
</body>
</html>
