<%--
  Created by IntelliJ IDEA.
  User: pakki
  Date: 5/1/2020
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
Список сотрудников
<form name="listOfPersons" method="POST" action="controller">
    <input type="hidden" name="command" value="listOfPersons"/>
    <input type="submit" value="Persons"/>
</form>


Навигаторы
<c:forEach var="navigator" items="${requestScope.navigators}">
    <ul>
        <li>ID :<c:out value="${navigator.id}"/></li>
        <li>First Name :<c:out value="${navigator.firstName}"/></li>
        <li>Last Name :<c:out value="${navigator.lastName}"/></li>
        <li>Age :<c:out value="${navigator.age}"/></li>


        <form name="Form Updating" method="post" action="controller">
            <input type="hidden" name="command" value="getPerson">
            <input type="hidden" name="position" value="navigator">
            <input type="hidden" name="id" value="${navigator.id}">
            <input type="submit" value="Edit">
        </form>

        <form name="Form Updating" method="post" action="controller">
            <input type="hidden" name="command" value="deletePerson">
            <input type="hidden" name="position" value="navigator">
            <input type="hidden" name="id" value="${navigator.id}">
            <input type="submit" value="Delete">
        </form>
    </ul>
</c:forEach>

Operators
<c:forEach var="operator" items="${requestScope.operators}">
    <li><c:out value="${operator.id}"></c:out></li>
    <li><c:out value="${operator.firstName}"></c:out></li>
    <li><c:out value="${operator.lastName}"></c:out></li>
    <li><c:out value="${operator.age}"></c:out></li>

    <form name="Form Updating" method="post" action="controller">
        <input type="hidden" name="command" value="getPerson">
        <input type="hidden" name="position" value="operator">
        <input type="hidden" name="id" value="${operator.id}">
        <input type="submit" value="Edit">
    </form>

    <form name="Form Updating" method="post" action="controller">
        <input type="hidden" name="command" value="deletePerson">
        <input type="hidden" name="position" value="operator">
        <input type="hidden" name="id" value="${operator.id}">
        <input type="submit" value="Edit">
    </form>
</c:forEach>

Pilots
<c:forEach var="pilot" items="${requestScope.pilots}">
    <li><c:out value="${pilot.id}"></c:out></li>
    <li><c:out value="${pilot.firstName}"></c:out></li>
    <li><c:out value="${pilot.lastName}"></c:out></li>
    <li><c:out value="${pilot.age}"></c:out></li>

    <form name="Form Updating" method="post" action="controller">
        <input type="hidden" name="command" value="getPerson">
        <input type="hidden" name="position" value="pilot">
        <input type="hidden" name="id" value="${pilot.id}">
        <input type="submit" value="Edit">
    </form>

    <form name="Form Updating" method="post" action="controller">
        <input type="hidden" name="command" value="deletePerson">
        <input type="hidden" name="position" value="operator">
        <input type="hidden" name="id" value="${operator.id}">
        <input type="submit" value="Edit">
    </form>
</c:forEach>

Stews
<c:forEach var="stewardess" items="${requestScope.stewardesses}">
    <li><c:out value="${stewardess.id}"></c:out></li>
    <li><c:out value="${stewardess.firstName}"></c:out></li>
    <li><c:out value="${stewardess.lastName}"></c:out></li>
    <li><c:out value="${stewardess.age}"></c:out></li>

    <form name="Form Updating" method="post" action="controller">
        <input type="hidden" name="command" value="getPerson">
        <input type="hidden" name="position" value="stewardess">
        <input type="hidden" name="id" value="${stewardess.id}">
        <input type="submit" value="Edit">
    </form>

    <form name="Form Updating" method="post" action="controller">
        <input type="hidden" name="command" value="deletePerson">
        <input type="hidden" name="position" value="stewardess">
        <input type="hidden" name="id" value="${stewardess.id}">
        <input type="submit" value="Edit">
    </form>
</c:forEach>

</table>
</div>
Добавление нового сотрудника
<form name="create new Person" method="post" action="controller">
    <label><input type="text" name="id"></label>Номер сотрудника<br>
    <label><input type="text" name="firstName"></label>Имя<br>
    <label><input type="text" name="lastName"></label>Фамилия<br>
    <label><input type="text" name="age"></label>Возраст<br>
    <select name="position">
        <option value="navigator">navigator</option>
        <option value="operator">operator</option>
        <option value="pilot">pilot</option>
        <option value="stewardess">stewardess</option>
    </select>
    <input type="hidden" name="command" value="createPerson"/>
    <input type="submit" value="create"/>
</form>

<form name="listOfVoyages" method="POST" action="controller">
    <input type="hidden" name="command" value="ListOfVoyages"/>
    <input type="hidden" name="forward" value="admin"/>
    <input type="submit" value="Voyages"/>
</form>

Добавление нового рейса
<form name="createVoyage" method="POST" action="controller">
    <label><input type="text" name="id"></label>Номер рейса<br>
    <label><input type="text" name="idAirport"></label>Номер феропорта<br>
    <label><input type="text" name="idTeam"></label>Номеер команды<br>
    <label><input type="text" name="placeOfSending"></label>Место отлета<br>
    <label><input type="text" name="placeOfArriving"></label>Место прибытия<br>
    <label><input type="text" name="timeOfSending"></label>Время отлета<br>
    <label><input type="text" name="timeOfArriving"></label>Время прибытия<br>
    <label><input type="text" name="status"></label>Статус<br>
    <input type="hidden" name="command" value="createVoyage"/>
    <input type="submit" value="create"/>
    <button></button>
</form>

<c:forEach var="voyage" items="${requestScope.voyages}">
    <li>Номер</li>
    <c:out value="${voyage.id}"></c:out>
    <li>Имя</li>
    <c:out value="${voyage.name}"></c:out>
    <li>Дата отпр</li>
    <c:out value="${voyage.timeOfSending}"></c:out>
    <li>Дата прибытия</li>
    <c:out value="${voyage.timeOfArriving}"></c:out>
    <li>Статус</li>
    <c:out value="${voyage.status}"></c:out>

    <form name="Form Delete" method="post" action="controller">
        <input type="hidden" name="command" value="deleteVoyage">
        <input type="hidden" name="id" value="${voyage.id}">
        <input type="submit" value="Delete">
    </form>

    <form name="Form Updating" method="post" action="controller">
        <input type="hidden" name="command" value="getVoyage">
        <input type="hidden" name="id" value="${voyage.id}">
        <input type="submit" value="Edit">
    </form>

</c:forEach>

<form name="listOfRequest" method="POST" action="controller">
    <input type="hidden" name="command" value="listOfRequest"/>
    <input type="submit" value="Requests"/>
</form>

<c:forEach var="request" items="${requestScope.listOfRequest}">
    <li>Номер</li>
    <c:out value="${request.id}"></c:out>
    <li>Номер Команды</li>
    <c:out value="${request.idTeam}"></c:out>
    <li>Номер Рейса</li>
    <c:out value="${request.idVoyage}"></c:out>
    <li>Статус</li>
    <c:out value="${request.status}"></c:out>
    <li>Сообщение</li>
    <c:out value="${request.massage}"></c:out>

    <form name="Form Delete" method="post" action="controller">
        <input type="hidden" name="command" value="closeRequest">
        <input type="hidden" name="id" value="${request.id}">
        <input type="submit" value="Close">
    </form>

    <form name="Form Changing" method="post" action="controller">
        <input type="hidden" name="command" value="changeStatusRequest">
        <input type="hidden" name="id" value="${request.id}">
        <input type="submit" value="Change Status">
    </form>
</c:forEach>
<a href="controller?command=logout">Logout</a>
</body>
</html>
