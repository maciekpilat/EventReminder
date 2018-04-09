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
        <meta charset="utf-8">
        <title>Bootstrap + Chosen</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}bootstrap/css/bootstrap.css" />
        <style>
            body { margin-bottom: 144px; }
            header { margin: 72px 0 36px; }
            header h1 { font-size: 54px; }
        </style>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script src="http://harvesthq.github.io/chosen/chosen.jquery.js"></script>
        <!--<script src="${pageContext.request.contextPath}resources/js/jsScripts.js"></script>-->

        <script>
            $(function () {
                $('.chosen-select').chosen();
                $('.chosen-select-deselect').chosen({allow_single_deselect: true});
            });
        </script>
    </head>
    <body>
        <a href="https://github.com/alxlit/bootstrap-chosen"></a>

        <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <h2>DODAJ POSTĘPOWANIE</h2>                    
                    </div>
                    </div>
            <div class="row">
                <div class="col-lg-2">
                    <input type="text" name="CourtFileReference" placeholder="Sygnatura">
                </div>
                <div class="col-lg-2">
                    <select placeholder="Wybierz wydzial" class="chosen-select" tabindex="2">
                        <c:forEach items="${lists}" var="t">
                            <option value="${t.departmentId}">${t.courtDepartmentName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-lg-2">
                    <select type="text" name="" placeholder="Wybierz typ strony">
                        <c:forEach items="${listPartyType}" var="t">
                            <option value="${t.partyTypeId}">${t.partyTypeName}</option>
                        </c:forEach> 
                    </select>
                </div>
            </div>
<!--POWOD-->
                <div class="row">
                    <div class="col-lg-3">
                        <h2>Dodaj powoda</h2>                    
                    </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-2">
                            <input type="text" name="clientTitle" placeholder="Tytul">
                        </div>  
                        <div class="col-lg-2">
                            <input type="text" name="clientFirstName" placeholder="Imie">
                        </div>  
                        <div class="col-lg-2">
                            <input type="text" name="clientLastName" placeholder="Nazwisko">
                        </div>
                        <div class="col-lg-2">
                            <input type="text" name="clientCompanyName" placeholder="Firma">
                        </div>
                    </div>
                    <!--ADRES-->    
                    <div id="locationField">
                        <div class="row">
                            <div class="col-lg-2">
                                <input id="autocomplete" placeholder="Wpisz adres" onFocus="geolocate()" type="text">
                            </div>
                        </div>
                        <table>
                            <div class="row">
                                <div class="col-lg-2">
                                    <input class="field" id="street_number" disabled="true" placeholder="Ulica">                               
                                </div>
                                <div class="col-lg-2">
                                    <input class="field" id="route" disabled="true">
                                </div>
                                <div class="col-lg-2">
                                    <input class="field" id="locality" disabled="true" placeholder="Miasto">
                                </div>
                                <div class="col-lg-2">
                                    <input class="field" id="administrative_area_level_1" placeholder="Wojewodztwo" disabled="true">
                                </div>
                                <div class="col-lg-2">
                                    <input class="field" id="postal_code" disabled="true" placeholder="Kod pocztowy">
                                </div>
                                <div class="col-lg-2">
                                    <input class="field" placeholder="Kraj" id="country" disabled="true">
                                </div>
                        </table>
                        <!--KONIEC POWOD-->
                        
                        <!--POZWANY-->
                <div class="row">
                    <div class="col-lg-3">
                        <h2>Dodaj pozwanego</h2>                    
                    </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-2">
                            <input type="text" name="clientTitle" placeholder="Tytul">
                        </div>  
                        <div class="col-lg-2">
                            <input type="text" name="clientFirstName" placeholder="Imie">
                        </div>  
                        <div class="col-lg-2">
                            <input type="text" name="clientLastName" placeholder="Nazwisko">
                        </div>
                        <div class="col-lg-2">
                            <input type="text" name="clientCompanyName" placeholder="Firma">
                        </div>
                    </div>
                    <!--ADRES-->    
                    <div id="locationField">
                        <div class="row">
                            <div class="col-lg-2">
                                <input id="autocomplete" placeholder="Wpisz adres" onFocus="geolocate()" type="text">
                            </div>
                        </div>
                        <table>
                            <div class="row">
                                <div class="col-lg-2">
                                    <input class="field" id="street_number" disabled="true" placeholder="Ulica">                               
                                </div>
                                <div class="col-lg-2">
                                    <input class="field" id="route" disabled="true">
                                </div>
                                <div class="col-lg-2">
                                    <input class="field" id="locality" disabled="true" placeholder="Miasto">
                                </div>
                                <div class="col-lg-2">
                                    <input class="field" id="administrative_area_level_1" placeholder="Wojewodztwo" disabled="true">
                                </div>
                                <div class="col-lg-2">
                                    <input class="field" id="postal_code" disabled="true" placeholder="Kod pocztowy">
                                </div>
                                <div class="col-lg-2">
                                    <input class="field" placeholder="Kraj" id="country" disabled="true">
                                </div>
                        </table>
                        <!--KONIEC POZWANY-->
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
                        </script>
                        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAKquDS_WCnGAUZWXhzbNzky2P6q3GtW88&libraries=places&callback=initAutocomplete"
                        async defer></script>
                        <!--ADRES KONIEC-->
                    </div>
                </div>
            </div>
    </body>
</html>
