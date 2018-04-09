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
                    <h2>DODAJ POSTĘPOWANIE</h2>                    
                </div>
            </div>
            <form:form method="POST" action="/addlawsuit" modelAttribute="lawsuit">
                <div class="row">
                    <div class="col-lg-2">
                        <form:input type="text" path="courtFileReference" placeholder="Sygnatura"/>
                        </div>
                        <div class="col-lg-2">
                            <form:select path="CourtDepartment" placeholder="Wybierz wydzial" class="chosen-select" tabindex="2">
                                <c:forEach items="${lists}" var="t">
                                    <form:option value="${t.departmentId}">${t.courtDepartmentName}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <td><input type="submit" value="Submit"/>
                    </div>
            </form:form>
        </div>
    </body>
</html>