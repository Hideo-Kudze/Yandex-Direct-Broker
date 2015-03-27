<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 08.09.14
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="/resources/xlsUplopad.js"></script>
</head>
<body>

<div>
    <input id="xlsUpload" type="file" data-url="rest/controller/upload" value="Загрузить excel" multiple/>
    <br/>
    <input id="uploadButton" type="button" value="Загрузить xls." onclick="uploadXls()"/>
</div>

</body>
</html>
