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
        <style>
            /* Always set the map height explicitly to define the size of the div
             * element that contains the map. */
            #map {
                height: 100%;
            }
            /* Optional: Makes the sample page fill the window. */
            html, body {
                height: 100%;
                margin: 0;
                padding: 0;
            }
        </style>
        <link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500">
        <style>
            #locationField, #controls {
                position: relative;
                width: 480px;
            }
            #autocomplete {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 99%;
            }
            .label {
                text-align: right;
                font-weight: bold;
                width: 100px;
                color: #303030;
            }
            #address {
/*                border: 1px solid #000090;
                background-color: #f0f0ff;*/
                width: 480px;
                padding-right: 2px;
            }
            #address td {
                font-size: 10pt;
            }
            .field {
                width: 99%;
            }
            .slimField {
                width: 80px;
            }
            .wideField {
                width: 200px;
            }
            #locationField {
                height: 20px;
                margin-bottom: 2px;
            }
        </style>
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
        <!--IKRYTY FORMULARZ DO PRZEKAZANIA DANYCH-->
        <form method="post" action="/addadress">               
            <input type="hidden" name="adressStreetNumber1" id="adressStreetNumber1" value="">
            <input type="hidden" name="adressStreetName1" id="adressStreetName1" value="">
            <input type="hidden" name="adressCity1" id="adressCity1" value="">
            <input type="hidden" name="adressAdministrativeArea1" id="adressAdministrativeArea1" value="">
            <input type="hidden" name="adressPostalCode1" id="adressPostalCode1" value="">
            <input type="hidden" name="adressCountry1" id="adressCountry1" value="">
<!--GUZIK WYZWALA FUNKCJE I DODAJE DO FORMULARZA-->             
        <input type="submit" id="button1" >
        </form>
        <script>

            var placeSearch, autocomplete;
            var componentForm = {
                street_number: 'short_name',
                route: 'long_name',
                locality: 'long_name',
                administrative_area_level_1: 'short_name',
                country: 'long_name',
                postal_code: 'short_name'
            };

            function initAutocomplete() {
                autocomplete = new google.maps.places.Autocomplete(
                        /** @type {!HTMLInputElement} */(document.getElementById('autocomplete')),
                        {types: ['geocode']});

                autocomplete.addListener('place_changed', fillInAddress);
            }

            function fillInAddress() {
                var place = autocomplete.getPlace();

                for (var component in componentForm) {
                    document.getElementById(component).value = '';
                    document.getElementById(component).disabled = false;
                }

                for (var i = 0; i < place.address_components.length; i++) {
                    var addressType = place.address_components[i].types[0];
                    if (componentForm[addressType]) {
                        var val = place.address_components[i][componentForm[addressType]];
                        document.getElementById(addressType).value = val;
                    }
                }
            }

            function geolocate() {
                if (navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(function (position) {
                        var geolocation = {
                            lat: position.coords.latitude,
                            lng: position.coords.longitude
                        };
                        var circle = new google.maps.Circle({
                            center: geolocation,
                            radius: position.coords.accuracy
                        });
                        autocomplete.setBounds(circle.getBounds());
                    });
                }
            }
            //      PRZESLANIE DANYCH DO CONTROLERA

            $(document).ready(function () {
                var button1 = document.getElementById("button1");

//                button1.onmouseover = function () {
//                    alert("DZIALAM");
//                };
// !!! pobieram dane z google autocomplete !!!
                button1.onmouseover = function getAdressData() {
                    var adressStreetNumber = document.getElementById("street_number").value;
                    var adressStreetName = document.getElementById("route").value;
                    var adressCity = document.getElementById("locality").value;
                    var adressAdministrativeArea = document.getElementById("administrative_area_level_1").value;
                    var adressPostalCode = document.getElementById("postal_code").value;
                    var adressCountry = document.getElementById("country").value;
                    console.log(adressStreetNumber);
                    console.log(adressStreetName);
                    console.log(adressCity);
                    console.log(adressAdministrativeArea);
                    console.log(adressPostalCode);
                    console.log(adressCity);
                    
// !!! wstawiam dane do ukrytego formularza !!!
                    document.getElementById('adressStreetNumber1').value = adressStreetNumber;
                    document.getElementById('adressStreetName1').value = adressStreetName;
                    document.getElementById('adressCity1').value = adressCity;
                    document.getElementById('adressAdministrativeArea1').value = adressAdministrativeArea;
                    document.getElementById('adressPostalCode1').value = adressPostalCode;
                    document.getElementById('adressCountry1').value = adressCountry;
                };
            });
        </script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAKquDS_WCnGAUZWXhzbNzky2P6q3GtW88&libraries=places&callback=initAutocomplete"
        async defer></script>
    </body>
</html>