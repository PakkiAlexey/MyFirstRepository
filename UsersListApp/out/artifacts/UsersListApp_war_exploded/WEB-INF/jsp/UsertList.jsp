<%--
  Created by IntelliJ IDEA.
  User: pakki
  Date: 5/22/2020
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Of Users</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Users List Application</h1>

    <h2>
        <a href="controller?command=users">Users</a>
        &nbsp;&nbsp;
        <a href="controller?command=savedUsers">Saved</a>
    </h2>

    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Users</h2></caption>
            <tr>

                <th>First Name</th>
                <th>Last Name</th>
                <th>Phone</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="user" items="${listOfUsers}">
                <tr>
                    <td><img src="\UsersListApp\web\WEB-INF\jsp\Avatar\1.jpg"></td>
                    <td><c:out value="${user.firstName}"/></td>
                    <td><c:out value="${user.lastName}"/></td>
                    <td><c:out value="${user.phone}"/></td>

                    <td>
                        <div style="text-align: center;">
                            <a href="controller?command=showEditUser&typeOfList=users&idUser=${user.idUser}">Edit</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
