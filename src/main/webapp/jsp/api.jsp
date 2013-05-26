<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="api_defined" type="java.lang.boolean"--%>
<%--@elvariable id="activeUser" type="com.astrazeneca.d2m.entities.UserEntity"--%>
<c:if test="${empty api_defined}">
    <c:url value="/" var="homepage_url" scope="request"/>

    <script type="text/javascript">
        window.homepageApiUrl = '${homepage_url}';
    </script>
    <c:set var="api_defined" value="true" scope="request"/>
</c:if>