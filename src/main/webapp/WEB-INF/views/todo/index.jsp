<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <title>todo index</title>
</head>
<body>
<h1>
    todo index
</h1>

<table border="1">
    <tr>
        <td>id</td>
        <td>content</td>
        <td>status</td>
        <td>操作</td>
    </tr>

    <c:forEach items="${todos}" var="todo">
        <tr>
            <td>${todo.id}</td>
            <td>${todo.getContent()}</td>
            <td>${todo.status}</td>
            <td>
                <a href="#">修改</a>
                <a href="#">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>新增一个</h2>
<form action="/todos" method="post">
    <input type="text" name="content"/>
    <input type="submit" value="新增！">
</form>
</body>
</html>
