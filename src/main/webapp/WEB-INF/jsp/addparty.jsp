<%-- 
    Document   : addEvent
    Created on : 2017-10-19, 13:51:40
    Author     : Pilat
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Bootstrap + Chosen</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}bootstrap/css/bootstrap.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script src="http://harvesthq.github.io/chosen/chosen.jquery.js"></script>

        <script>
            $(function () {
                $('.chosen-select').chosen();
                $('.chosen-select-deselect').chosen({allow_single_deselect: true});
            });
        </script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <h2>DODAJ STRONE</h2>                    
                </div>
            </div>
            <!--action - gdzie odeslac dane z formularza po nacisnieciu submit-->
            <form:form method="POST" action="/addparty" modelAttribute="party">
                <div class="row">

                    <div class="col-lg-2">
                        <form:select path="partyType" placeholder="Wybierz typ strony">
                            <c:forEach items="${lists}" var="t">
                                <form:option value="${t.partyTypeId}">${t.partyTypeName}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-2">
                        <input type="text" placeholder="Tytul" path="client.clientTitle"/>
                    </div>
                    <div class="col-lg-2">
                        <input type="text" placeholder="Imie" path="partyType.client"/>
                    </div>
                    <div class="col-lg-2">
                        <input type="text" placeholder="Nazwisko" path="client.clientLastName"/>
                    </div>
                    <div class="col-lg-2">
                        <input type="text" placeholder="Nazwa firmy" path="client.clientCompanyName"/>
                    </div>

                </div>
            </div>
        <td><input type="submit" value="Submit"/>
        </form:form>
    </body>
</html>
