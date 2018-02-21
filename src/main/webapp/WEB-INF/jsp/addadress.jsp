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
<!--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker3.css">    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js">        -->


    <title>Dodaj wydarzenie</title>

    <!--link do js-->
    <!--<script src="../resources/js/addEvent.js"></script>-->
    <!--    <link href="../resources/css/addEvent.css" rel="stylesheet" type="text/css">-->
</head>
<body>
    <h1>Dodaj adres</h1>

    
    <div>
	<input type="text"  id="w-input-search" value="">
	<span>
	  <button id="button-id" type="button">Search</button>
	</span>
  </div>

  <script>
  $(document).ready(function() {

	$('#w-input-search').autocomplete({
		serviceUrl: '${pageContext.request.contextPath}/addadress',
		paramName: "streetName",
		delimiter: ",",
	   transformResult: function(response) {

		return {
		  //must convert json to javascript object before process
		  suggestions: $.map($.parseJSON(response), function(item) {

		      return { value: item.streetName, data: item.streetId };
		   })

		 };

            }

	 });

  });
  </script>


   
       
</body>