<%-- 
    Document   : addEvent
    Created on : 2017-10-19, 13:51:40
    Author     : Pilat
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker3.css">    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js">        


    <title>Dodaj wydarzenie</title>

    <!--link do js-->
    <!--<script src="../resources/js/addEvent.js"></script>-->
    <!--    <link href="../resources/css/addEvent.css" rel="stylesheet" type="text/css">-->
</head>
<body>
    <h1>Dodaj wydarzenie</h1>
    <h2> Typ wydarzenia:</h2><br>

    <!--<div>-->
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
        <!--bootstrap datetime picker START-->      
        <div class="container">
    <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
                <div class='input-group date' id='datetimepicker1'>
                    <input type='text' class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker1').datetimepicker();
            });
        </script>
    </div>
</div>

        <!--bootstrap datetime picker END-->            
    <!--</div>-->

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
<!--</div>-->
</body>