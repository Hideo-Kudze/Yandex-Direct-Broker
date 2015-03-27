<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 22.07.14
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="/resources/utmRefresh.js"></script>

    <title></title>
</head>
<body>

${statistic}
<br/>

<input id="refreshWireButton" type="button" value="Обновить ассоциаци" onclick="refreshWire()"/>
<br/>
<br/>
<br/>
<br/>
<br/>


<c:forEach items="${directAccounts}" var="directAccount">
    <br/>
    <a href="/directAccount?user_name=${directAccount.normalized_user_name}">${directAccount.normalized_user_name}</a>

</c:forEach>

<br/>
<br/>
<br/>
<br/>
<br/>

<form name="foo" action="https://oauth.yandex.ru/authorize" method="get">
    <input name="state" type="text"/>
    <input type="hidden" name="response_type" value="code">
    <input type="hidden" name="client_id" value="7f237c1382cd4224938b923f1d4b1419">
    <input type="submit" value="Add direct account">
</form>

</body>
</html>
