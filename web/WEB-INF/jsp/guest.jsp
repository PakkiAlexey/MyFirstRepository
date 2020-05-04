
<%--
  Created by IntelliJ IDEA.
  User: pakki
  Date: 5/2/2020
  Time: 12:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Hello, Guest
    <h2>Все рейсы</h2>

    <form name="listOfVoyages" method="POST" action="controller">
        <input type="hidden" name="command" value="ListOfVoyages" />
        <input type="hidden" name="forward" value="guest" />
        <input type="submit" value="Voyages"/>
    </form>

    <c:forEach var="voyage" items="${requestScope.voyages}">
       <li>Номер</li> <c:out value="${voyage.idVoyage}"></c:out>
        <li>Имя</li> <c:out value="${voyage.name}"></c:out>
        <li>Дата отпр</li> <c:out value="${voyage.timeOfSending}"></c:out>
        <li>Дата прибытия</li><c:out value="${voyage.timeOfArriving}"></c:out>
        <li>Статус</li><c:out value="${voyage.status}"></c:out>
    </c:forEach>

    Поиск по номеру
    <form name="FindVoyage" method="POST" action="controller">
        <label><input type="number" name="idVoyage"></label>Номер рейса<br>
        <input type="hidden" name="command" value="findVoyage" />
        <input type="submit" value="Find"/>
    </form>

    <c:out value="${foundedVoyage.name}" > </c:out>
    <c:out value="${foundedVoyage.timeOfSending}" > </c:out>
    <c:out value="${foundedVoyage.timeOfArriving}" > </c:out>
    <c:out value="${foundedVoyage.status}" > </c:out>

    Сортировка рейсов по выбранному полю
    <form name="SortedForm" method="POST" action="controller">
        <select name="Sorted by" size="1">
            <option value="name">Name</option>
            <option value="id">Id</option>
        </select>
        <input type="hidden" name="command" value="sortedList" />
        <input type="submit" value="Sort"/>
    </form>

    <c:forEach var="voyage" items="${requestScope.sortedVoyages}">
        <li>Номер</li> <c:out value="${voyage.id}"></c:out>
        <li>Имя</li> <c:out value="${voyage.name}"></c:out>
        <li>Дата отпр</li> <c:out value="${voyage.timeOfSending}"></c:out>
        <li>Дата прибытия</li><c:out value="${voyage.timeOfArriving}"></c:out>
        <li>Статус</li><c:out value="${voyage.status}"></c:out>
    </c:forEach>

    Выборка рейсов по выбраному полю
    <form name="SelectionForm" method="POST" action="controller">
        <select name="Selection by" size="1">
            <option value="place of sending">Place of sending</option>
            <option value="place of arriving">Place of arriving</option>
            <option value="time of sending">Time of sending</option>
        </select>
        <label><input type="text" name="value"></label>Значение сортировки<br>
        <input type="hidden" name="command" value="selectVoyages" />
        <input type="submit" value="Select"/>
    </form>

    <c:forEach var="voyage" items="${requestScope.voyagesSelection}">
        <li>Номер</li> <c:out value="${voyage.idVoyage}"></c:out>
        <li>Имя</li> <c:out value="${voyage.name}"></c:out>
        <li>Дата отпр</li> <c:out value="${voyage.timeOfSending}"></c:out>
        <li>Дата прибытия</li><c:out value="${voyage.timeOfArriving}"></c:out>
        <li>Статус</li><c:out value="${voyage.status}"></c:out>
    </c:forEach>

    <a href="controller?command=logout">Logout</a>


</body>
</html>
