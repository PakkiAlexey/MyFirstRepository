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
    Hello, Dispatcher

<%--    <form name="listOfVoyages" method="POST" action="controller">--%>
<%--        <input type="hidden" name="command" value="allList" />--%>
<%--        <input type="submit" value="Voyages"/>--%>
<%--    </form>--%>

<%--    <c:forEach var="voyage" items="${requestScope.voyages}">--%>
<%--        <li>Номер</li> <c:out value="${voyage.idVoyage}"></c:out>--%>
<%--        <li>Имя</li> <c:out value="${voyage.name}"></c:out>--%>
<%--        <li>Дата отпр</li> <c:out value="${voyage.timeOfSending}"></c:out>--%>
<%--        <li>Дата прибытия</li><c:out value="${voyage.timeOfArriving}"></c:out>--%>
<%--        <li>Статус</li><c:out value="${voyage.status}"></c:out>--%>
<%--    </c:forEach>--%>

<%--    <form name="organization team" method="POST" action="controller">--%>
<%--        <label><input type="text" name="teamId"></label>Значение сортировки<br>--%>
<%--        <input type="hidden" name="command" value="organizationTeam" />--%>
<%--        <input type="submit" value="Organize"/>--%>
<%--    </form>--%>

<%--        <c:forEach var="pilot" items="${requestScope.pilots}">--%>
<%--        <c:out value="${pilot.firstName}"></c:out>--%>
<%--        </c:forEach>--%>

<%--        <li>Номер</li> <c:out value="${team.idTeam}"></c:out>--%>
<%--        <li>Navig</li> <c:out value="${team.idNavigator}"></c:out>--%>
<%--        <li>Oper</li> <c:out value="${team.idOperator}"></c:out>--%>
<%--        <li>Пилоты</li> <c:forEach var="pilot" items="${requestScope.pilots}">--%>
<%--        <c:out value="${pilot.idPilot}"></c:out>--%>
<%--                        </c:forEach>--%>
<%--        <li>Стюардессы</li><<c:forEach var="stewardess" items="${requestScope.stewardesses}">--%>
<%--        <c:out value="${stewardess.idStewardess}"></c:out>--%>
<%--    </c:forEach>--%>
<%--        <li>Дата прибытия</li><c:out value="${voyage.timeOfArriving}"></c:out>--%>
<%--        <li>Статус</li><c:out value="${voyage.status}"></c:out>--%>

    <form name="createRequest" method="POST" action="controller">
        <label><input type="text" name="idRequest"></label>Номер рейса<br>
        <label><input type="text" name="idTeam"></label>Номер team<br>
        <label><input type="text" name="idVoyage"></label>Voyage<br>
        <input type="hidden" name="command" value="createRequest" />
        <input type="submit" value="create"/>
        <button></button>
    </form>

    <form name="logoutForm" method="POST" action="controller">
        <input type="hidden" name="command" value="logout" />
        <input type="submit" value="Log out"/>
        <button></button>
    </form>

</body>
</html>
