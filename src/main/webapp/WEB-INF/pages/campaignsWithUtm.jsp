<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 02.08.14
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="/resources/conversionStrategiesDao.js"></script>
    <script src="/resources/tacticDAOAjax.js"></script>
    <title></title>

    <style>

        .tactics {
            border: 1px solid black;
            margin: 10;
        }


    </style>

</head>
<body>

<br/>
<br/>



<c:forEach items="${campaignsList}" var="campaign">


    <c:set var="campaignId" scope="request" value="${campaign.campaignId}"/>
    ${strategiesMap.get(campaignId)}

    <br/>


    <br/>

    <div class="tactics">
            ${campaign.name} (${campaign.campaignId})
        <form>
            <div class='right'>Позиции:
                <select multiple="multiple" size="5" name="positions">
                    <option> 1СПЕЦ.</option>
                    <option> СПЕЦ.</option>
                    <option> 1ГАР.</option>
                    <option> ГАР.</option>
                    <option> ДИН.</option>
                </select>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Цели:
                <select multiple="multiple" size="5" name="goals">

                    <c:forEach items="${campaign.goalsSet}" var="goal">
                        <option value="${goal.id}"> ${goal.name} </option>
                    </c:forEach>

                </select>
            </div>

            <div class='right'>
                <input type="radio" name="group1" value="true">Наивысшая позиция<br/>
                <input type="radio" name="group1" value="false">Самая дешевая<br/>
                R-max : <input type="text" name="rmax" size="2"/>
                C-max : <input type="text" name="cmax" size="2"/>
                <input type="button" value="Установить" onclick="saveConversionStrategy(this, ${campaignId})"/>
            </div>
        </form>

        <input type="button" onclick="deleteTactics('campaign', ${campaignId})"
               value="Удалить стратегию компании"/>


    </div>



</c:forEach>
</br>
</br>
</body>
</html>
