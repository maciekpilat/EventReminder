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
            <div class="page-header">
            </div>
            <div class="row">
                <div class="col-lg-3">
                    <select placeholder="Wybierz wydzial" class="chosen-select" tabindex="2">
                        <c:forEach items="${lists}" var="t">
                             <option value="${t.departmentId}">${t.courtDepartmentName}</option>
                        </c:forEach>
                            <!-- <option value=""></option><option value="United States">United States</option><option value="United Kingdom">United Kingdom</option><option value="Afghanistan">Afghanistan</option><option value="Albania">Albania</option><option value="Algeria">Algeria</option><option value="American Samoa">American Samoa</option><option value="Andorra">Andorra</option><option value="Angola">Angola</option><option value="Anguilla">Anguilla</option><option value="Antarctica">Antarctica</option><option value="Antigua and Barbuda">Antigua and Barbuda</option>--></select>
                </div>
            </div>
        </div>
    </body>
</html>

