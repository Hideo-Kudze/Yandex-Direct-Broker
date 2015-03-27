<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 22.07.14
  Time: 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

        .green {
            background-color: green;
        }

    </style>

    <script>

    </script>
</head>
<body>


<c:forEach items="${campaignsList}" var="campaign">

    <c:set var="campaignID" scope="request" value="${campaign.campaignID}"/>
    <c:set var="strategy" scope="request" value="${strategiesMap.get(campaignID)}"/>

    <c:if test="${strategy ne null}">
        ${strategy}
    </c:if>

    <br/>

    <a href="/banners?campaignID=${campaignID}">${campaign.name}</a>
    <br/>  <input type="button" value="Добавить utm метки" onclick="addUTM(${campaignID})"/>



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
            <input type="hidden" name="campaignId" value=" ${campaignID}">
        </form>

        <input type="button" onclick = "deleteTactics('campaign', ${campaignID})"
               value="Удалить стратегию компании"/>

        <input type="button" onclick = "deleteTactics('campaignBanners', ${campaignID})"
               value="Удалить стратегии обявлений"/>
    </div>




</c:forEach>


</body>
</html>
