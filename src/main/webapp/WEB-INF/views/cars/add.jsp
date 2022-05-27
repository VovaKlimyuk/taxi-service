<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<style>
    <%@include file='/WEB-INF/views/css/table_dark.css' %>
</style>
<html>
<head>
    <title>Add car</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/index.jsp"/>
    <div class="formStyle">
        <form method="post" id="car" action="${pageContext.request.contextPath}/cars/add">
            <div class="formTitle">Model</div>
            <div class="formTitle">
                <input type="text" name="model" form="car" required></br>
            </div>
            <div class="formTitle">Choose a Manufacturer</div>

            <div class="formTitle">
                <select name="manufacturer_id">
                    <c:forEach var="manufacturer" items="${manufacturers}">
                        <option><c:out value="${manufacturer.id} ${manufacturer.name} ${manufacturer.country} "/></option>
                    </c:forEach>
                </select>
            </div>
            <div class="formTitle">
                <h5 class="successMassage">${successMsg}</h5>
                <input type="submit" name="add" form="car">
            </div>
        </form>
    </div>
</body>
</html>
