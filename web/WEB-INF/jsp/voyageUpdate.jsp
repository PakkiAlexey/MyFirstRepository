<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pakki
  Date: 5/4/2020
  Time: 5:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="Form Updating" method="post" action="controller">
    <label>Номер аэропорта: <input type="text" name="idAirport"  value="${requestScope.voyage.idAirport}"  /></label><br>
    <label>Номер команды: <input type="text" name="idTeam" value="${requestScope.voyage.idTeam}" /></label><br>
    <label>Номер команды: <input type="text" name="placeOfSending" value="${requestScope.voyage.placeOfSending}" /></label><br>
    <label>Место отправлени :<input type="text"  name="placeOfArriving"  value="${requestScope.voyage.placeOfArriving}"/> </label><br>
    <label>Позиция :<input type="text" name="timeOfSending" value="${requestScope.voyage.timeOfSending}"/></label>
    <label>Позиция :<input type="text" name="timeOfArriving" value="${requestScope.voyage.timeOfArriving}"/></label>
    <label>Позиция :<input type="text" name="status"  value="${requestScope.voyage.status}"/></label>
    <input type="hidden" name="command" value="updateVoyage">
    <input type="hidden" name="id" value="${voyage.id}">

    <input type="submit" value="Ok" name="Ok"><br>
</form>
</body>
</html>
