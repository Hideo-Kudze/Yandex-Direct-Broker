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
    <script src="/resources/ANYStrategiesDao.js"></script>
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
            <div class='right'>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Цели:
                <select multiple="multiple" size="5" name="goals">

                    <c:forEach items="${campaign.goalsSet}" var="goal">
                        <option value="${goal.id}"> ${goal.name} </option>
                    </c:forEach>

                </select>
            </div>

            <div class='right'>
                C-max : <input type="text" name="cmax" size="2"/>
                <input type="button" value="Установить" onclick="saveANYStrategy(this, ${campaignId})"/>
            </div>
        </form>

        <input type="button" onclick="removeAnyStrategy(this, ${campaignId})"
               value="Удалить стратегию компании"/>


    </div>



</c:forEach>
</br>
</br>
</body>
</html>
