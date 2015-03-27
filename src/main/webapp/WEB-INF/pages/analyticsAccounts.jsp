<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 08.08.14
  Time: 3:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="/resources/utmRefresh.js"></script>
</head>
<body>

<input type="button" value="Обновить ассоциаци" onclick="refreshWire()"/>
<br/>


    <c:forEach items="${analyticsAccounts}" var="directAccount">
        <br/>
        ${directAccount.userName}
    </c:forEach>

    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <form>
        <input type="button"  value="Add analytic account." onclick="window.location.href = '${authorizationUrl}'">
    </form>

</body>
</html>
