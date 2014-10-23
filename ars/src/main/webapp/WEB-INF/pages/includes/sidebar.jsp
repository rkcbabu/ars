<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sidebar">
    <ul class="nav nav-stacked">
        <li><h3 class="highlight">Channels <i class="glyphicon glyphicon-dashboard pull-right"></i></h3></li>
        <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name == null}">
                <li><a href="<c:url value="/register" />">Register</a></li>
            
            </c:when>
            <c:otherwise>
                <li><a href="<c:url value="/apartment/add" />">Add Apartment</a></li>
                <li><a href="<c:url value="/profile" />">My Profile</a></li>
            
            </c:otherwise>
        </c:choose>
        
    </ul>
</div>