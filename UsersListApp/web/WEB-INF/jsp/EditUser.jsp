<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User List Application</title>
    <script>
        function isEmail() {
            var str = document.getElementById("email").value;
            var status = document.getElementById("status");
            var re = /^[^\s()<>@,;:\/]+@\w[\w\.-]+\.[a-z]{2,}$/i;
            if (re.test(str)) status.innerHTML = "Адрес правильный";
            else status.innerHTML = "Адрес неверный";
            if(isEmpty(str)) status.innerHTML = "Поле пустое";
        }
        function isEmpty(str){
            return (str == null) || (str.length == 0);
        }
    </script>
</head>
<body>
<div style="text-align: center;">
    <h1>User List Application</h1>
    <h2>
        <a href="controller?command=users">Users</a>
        &nbsp;&nbsp;
        <a href="controller?command=savedUsers">Saved</a>
    </h2>
</div>
<div align="center">
    <form action="controller" method="post">
        <c:if test="${typeOfList=='saved'}">
            <input type="hidden" name="command" value="editUser">
        </c:if>
        <c:if test="${typeOfList=='users'}">
            <input type="hidden" name="command" value="insertUser">
        </c:if>

        <table border="1" cellpadding="5">
            <caption>
                <h2>
                     Edit User
                </h2>
            </caption>

            <input type="hidden" name="idUser" value="<c:out value='${user.idUser}' />"/>

            <tr>
                <th>First Name:</th>
                <td>
                    <input type="text" name="firstName" size="45"
                           value="<c:out value='${user.firstName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Last Name</th>
                <td>
                    <input type="text" name="lastName" size="45"
                           value="<c:out value='${user.lastName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Email</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${user.email}'/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Phone</th>
                <td>
                    <input type="text" name="phone" size="45"
                           value="<c:out value='${user.phone}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save">

                </td>

            </tr>
            <td valign="bottom">
                <c:if test="${typeOfList=='saved'}">
                    <a href="controller?command=savedUsers">Back</a>
                </c:if>
                <c:if test="${typeOfList=='users'}">
                    <a href="controller?command=users">Back</a>
                </c:if>
            </td>
        </table>
    </form>
</div>
</body>
</html>