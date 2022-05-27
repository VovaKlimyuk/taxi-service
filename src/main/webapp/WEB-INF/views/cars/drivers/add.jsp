<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<style>
    <%@include file='/WEB-INF/views/css/table_dark.css' %>
</style>
<html>
<head>
    <title>Add driver to car</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/index.jsp"/>
<div class="formStyle">
    <form method="post" id="car" action="${pageContext.request.contextPath}/cars/drivers/add">
        <div class="formTitle">Choose car</div>
        <div class="formTitle">
            <select name="car_id">
                <c:forEach var="car" items="${cars}">
                    <option><c:out value="${car.id} ${car.model} ${car.manufacturer.name} "/></option>
                </c:forEach>
            </select>
        </div>
        <div class="formTitle">
            <h5 class="errorMassage">${errorMsg}</h5>
            <h5 class="successMassage">${successMsg}</h5>
        </div>
        <div class="formTitle">
            <input type="submit" name="add" form="car">
        </div>
    </form>
</div>
</body>
</html>