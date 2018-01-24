<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="template/header.jsp" %>
    <body>
        
        
        <c:if test="${empty sessionScope.persona}">
            <%@include file="login.jsp" %>
        </c:if>
        <c:if test="${not empty sessionScope.persona}">
            <%@include file="template/menu.jsp" %>
        </c:if>
                
        <%@include file="template/footer.jsp" %>
    </body>
</html>
