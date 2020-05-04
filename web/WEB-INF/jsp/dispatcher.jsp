<%--
  Created by IntelliJ IDEA.
  User: pakki
  Date: 5/1/2020
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    Список рейсов
    <form name="listOfVoyages" method="POST" action="controller">
        <input type="hidden" name="command" value="ListOfVoyages" />
        <input type="hidden" name="forward" value="dispatcher" />
        <input type="submit" value="Voyages"/>
    </form>

    <c:forEach var="voyage" items="${requestScope.voyages}">
        <li>Номер</li> <c:out value="${voyage.id}"></c:out>
        <li>Имя</li> <c:out value="${voyage.name}"></c:out>
        <li>Дата отпр</li> <c:out value="${voyage.timeOfSending}"></c:out>
        <li>Дата прибытия</li><c:out value="${voyage.timeOfArriving}"></c:out>
        <li>Статус</li><c:out value="${voyage.status}"></c:out>

        <form name="Form Changing" method="post" action="controller">
            <input type="hidden" name="command" value="changeStatusVoyage">
            <input type="hidden" name="id" value="${voyage.id}">
            <input type="submit" value="Change Status">
        </form>
    </c:forEach>

    Формирование команды по номеру рейса
    <form name="organization team" method="POST" action="controller">
        <label><input type="text" name="voyageId"></label>Номер рейса<br>
        <input type="hidden" name="command" value="organizationTeam" />
        <input type="submit" value="Organize"/>
    </form>

        <li>Номер команды</li> <c:out value="${team.id}"></c:out>
        <li>номер навигатора</li> <c:out value="${team.idNavigator}"></c:out>
        <li>номер оператора</li> <c:out value="${team.idOperator}"></c:out>
        <li> номера пилотов</li> <c:forEach var="pilot" items="${requestScope.pilots}">
        <c:out value="${pilot}"></c:out>
                        </c:forEach>
        <li>Номера Стюардес</li><c:forEach var="stewardess" items="${requestScope.stewardesses}">
        <c:out value="${stewardess}"></c:out>
    </c:forEach>

    Формирование заявки администратору
    <form name="createRequest" method="POST" action="controller">
        <label><input type="text" name="idRequest"></label>Номер рейса<br>
        <label><input type="text" name="idTeam"></label>Номер team<br>
        <label><input type="text" name="idVoyage"></label>Voyage<br>
        <label><input type="text" name="Massage"></label>Voyage<br>
        <input type="hidden" name="command" value="createRequest" />
        <input type="submit" value="create"/>
        <button></button>
    </form>

    <a href="controller?command=logout">Logout</a>

</body>
</html>
