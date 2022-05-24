<%--
  Created by IntelliJ IDEA.
  User: 베오
  Date: 2022-05-23
  Time: 오후 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DCode</title>
    <link rel="stylesheet" href="/free/resources/static/views/board_write.css" type="text/css"/>
</head>
<body>
<div style="height: 100%; background-color: #f1f1f1">
    <jsp:include page="components/top_menu.jsp"/>
    <div class="board_write" align=center>
        <div class="board_write_component">
            <h1>${mode} Write</h1>
            <form action="/free/board/write/${mode}" method="post">
                <div>
                    <label>
                        <input class="board_write_input" type="text" name="title" autofocus
                               placeholder="Enter the subject"></td>
                    </label>

                    <label>
                        Language
                        <select name="language">
                            <option value="C++">C++</option>
                            <option value="Java">Java</option>
                            <option value="Python">Python</option>
                        </select>
                    </label>
                </div>
                <label>
                    <textarea class="board_write_textarea" type="text" rows="5" cols="33" name="description"
                              placeholder="Enter the Description"></textarea>
                </label>

                <div>
                <input class="board_write_submit" type="submit" name="submit" value="보내기">
                <input class="board_write_reset" type="reset" name="reset" value="다시 작성">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
