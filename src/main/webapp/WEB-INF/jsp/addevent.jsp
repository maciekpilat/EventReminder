<%-- 
    Document   : addEvent
    Created on : 2017-10-19, 13:51:40
    Author     : Pilat
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--link do css-->
<link href="../resources/css/addEvent.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dodaj wydarzenie</title>

    <!--link do jquery-->
    <script src="https://ajax.googleapis.com/ajax/libs/dojo/1.13.0/dojo/dojo.js"></script>
    <!--link do js-->
    <script src="../resources/js/addEvent.js"></script>
</head>

<body>

    <h1>Dodaj wydarzenie</h1>

    <h2> Typ wydarzenia:</h2><br>

    <div>

        <form id="eventCall" method="post">
            <select id="selectEventDrop" name="eventType">
                <c:forEach items="${enumValues}" var="type">
                    <option value="${type}">${type.name}</option>
                </c:forEach>
            </select><br><br>



            <!--        <form id="eventCall" method="post">-->
            <input type="text" name="eventNote" placeholder="opis wydarzenia">
            <input type="datetime" name="eventStartDate" placeholder="początek wydarzenia">
            <input type="datetime" name="eventEndDate" placeholder="koniec wydarzenia">    
            <input type="submit">
        </form>

<!--        <form id="eventHearing" method="post">
            <input type="text" name="eventNote" placeholder="opis wydarzenia">
            <input type="datetime" name="eventStartDate" placeholder="początek wydarzenia">
            <input type="datetime" name="eventEndDate" placeholder="koniec wydarzenia">    
            <input type="submit">
        </form>

        <form id="eventMail" method="post">
            <input type="text" name="eventNote" placeholder="opis wydarzenia">
            <input type="datetime" name="eventStartDate" placeholder="początek wydarzenia">
            <input type="datetime" name="eventEndDate" placeholder="koniec wydarzenia">
            <input type="text" name="senderMail" placeholder="nadwca">
            <input type="text" name="recieverMail" placeholder="odbiorca">    
            <input type="submit">
        </form>-->
    </div>
</body>



<!--<form action="addcase" method="post">-->


