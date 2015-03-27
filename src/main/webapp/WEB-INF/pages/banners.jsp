<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 22.07.14
  Time: 3:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="/resources/tacticDAOAjax.js"></script>

    <title></title>
    <style>

        .tactics {
            border: 1px solid black;
            margin: 10;
        }

        .green{
            background-color: green;
        }

    </style>
</head>
<body>


<c:forEach items="${banners}" var="banner">

    <c:set var="bannerID" scope="request" value="${banner.bannerID}"/>
    <c:set var="strategy" scope="request" value="${strategiesMap.get(bannerID)}"/>

    <c:if test="${strategy ne null}">
        ${strategy}
    </c:if>
    

    <br/>

    ${banner.title} (${banner.bannerID})

    <div class="tactics">

        <form>

            <select multiple = "multiple" size="5" name="beginPosition">
                <option> 1СПЕЦ.</option>
                <option> СПЕЦ.</option>
                <option> 1ГАР.</option>
                <option> ГАР.</option>
                <option> ДИН.</option>
            </select>

            <input type="radio" name="group1" value="true">Наивысшая позиция<br/>
            <input type="radio" name="group1" value="false">Самая дешевая<br/>
            R-max : <input type="text" name="rmax" size="2"/>
            <input type="submit" value="Установить"/>
            <input type="hidden" name="bannerId" value=" ${bannerID}">
        </form>

        <input type="button" onclick = "deleteTactics('banner', ${bannerID})"
               value="Удалить стратегию обявления" />

    </div>


</c:forEach>


</body>
</html>
