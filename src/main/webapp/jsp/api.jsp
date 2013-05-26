<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="api_defined" type="java.lang.boolean"--%>
<%--@elvariable id="activeUser" type="com.astrazeneca.d2m.entities.UserEntity"--%>
<c:if test="${empty api_defined}">
    <c:url value="/" var="homepage_url" scope="request"/>
    <c:url value="/clients" var="clients_url" scope="request"/>
    <c:url value="/cars" var="cars_url" scope="request"/>
    <c:url value="/sellers" var="sellers_url" scope="request"/>
    <c:url value="/insurances" var="insurances_url" scope="request"/>
    <c:url value="/sales" var="sales_url" scope="request"/>

    <script type="text/javascript">
        window.homepageApiUrl = '${homepage_url}';
        window.clientsApiUrl = '${clients_url}';
        window.sellersApiUrl = '${sellers_url}';
        window.carsApiUrl = '${cars_url}';
        window.insurancesApiUrl = '${insurances_url}';
        window.salesApiUrl = '${sales_url}';
    </script>
    <c:set var="api_defined" value="true" scope="request"/>
</c:if>