<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pakki
  Date: 5/3/2020
  Time: 11:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person Update</title>

</head>
<body>
<br />

<form name="Form Updating" method="post" action="controller">
    <label>Новое Имя: <input type="text" name="firstName" <c:out value="${requestScope.member.firstName}"/>  /></label><br>
    <label>Новая Фамилия: <input type="text" name="lastName" <c:out value="${requestScope.member.lastName}"/> </div> /></label><br>
    <label>Другой Возраст :<input type="text" name="age" value="${requestScope.member.age}" /></label><br>
    <select name="position">
        <option value="navigator">navigator</option>
        <option value="operator">operator</option>
        <option value="pilot">pilot</option>
        <option value="stewardess">stewardess</option>
    </select>
    <input type="hidden" name="command" value="updatePerson">
    <input type="hidden" name="id" value="${member.id}">

    <input type="submit" value="Ok" name="Ok"><br>
</form>
</body>
</html>
