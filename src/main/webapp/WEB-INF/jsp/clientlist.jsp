<%-- 
    Document   : addEvent
    Created on : 2017-10-19, 13:51:40
    Author     : Pilat
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <title>Place Autocomplete Address Form</title>
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
        <meta charset="utf-8">
    </head>

    <body>
        <div id="locationField">
            <input id="autocomplete" placeholder="Wpisz adres"
                   onFocus="geolocate()" type="text"></input>
        </div>

        <table id="address">
            <tr>
                <td class="label">Ulica</td>
                <td class="slimField"><input class="field" id="street_number"
                                             disabled="true"></input></td>
                <td class="wideField" colspan="2"><input class="field" id="route"
                                                         disabled="true"></input></td>
            </tr>
            <tr>
                <td class="label">Miasto</td>
                <td class="wideField" colspan="3"><input class="field" id="locality"
                                                         disabled="true"></input></td>
            </tr>
            <tr>
                <td class="label">Wojewodztwo</td>
                <td class="slimField"><input class="field"
                                             id="administrative_area_level_1" disabled="true"></input></td>
                <td class="label">Kod pocztowy</td>
                <td class="wideField"><input class="field" id="postal_code"
                                             disabled="true"></input></td>
            </tr>
            <tr>
                <td class="label">Kraj</td>
                <td class="wideField" colspan="3"><input class="field"
                                                         id="country" disabled="true"></input></td>
            </tr>
        </table>

        <!--RODZAJ ADRESU-->
        <select id="selectAdressType" name="adressType">
            <c:forEach items="${lists}" var="t">
                <option value="${t.adressTypeId}">${t.adressTypeName}</option>
            </c:forEach>
        </select><br><br>





        <!--UKRYTY FORMULARZ DO PRZEKAZANIA DANYCH-->
        <form method="post" action="/addadress">               
            <input type="hidden" name="adressStreetNumber1" id="adressStreetNumber1" value="">
            <input type="hidden" name="adressStreetName1" id="adressStreetName1" value="">
            <input type="hidden" name="adressCity1" id="adressCity1" value="">
            <input type="hidden" name="adressAdministrativeArea1" id="adressAdministrativeArea1" value="">
            <input type="hidden" name="adressPostalCode1" id="adressPostalCode1" value="">
            <input type="hidden" name="adressCountry1" id="adressCountry1" value="">
            <input type="hidden" name="adressType1" id="adressType1" value="">
            <!--GUZIK WYZWALA FUNKCJE I DODAJE DO FORMULARZA-->             
            <input type="submit" id="button1" >
        </form>
    </body>
</html>