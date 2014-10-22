<jsp:include page="includes/head.jsp" />
<jsp:include page="includes/header.jsp" />
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Begin Body -->
<div class="container">
    <div class="row">
         <div class="col col-sm-3">
            <jsp:include page="includes/sidebar.jsp" />    
        </div>  
        <div class="col col-sm-9">
            <div class="panel">
                <h1>User Profile</h1>
                <c:url var="userImage" value="/resources/userpics/${currentUser.username}_${currentUser.profileImage}"/>
                <div class="userImage" style="background: url(${userImage})"></div>
                <p>${currentUser.firstName}</p>
                
                
                
                <div class="clear"></div>
                <hr>
            </div>
        </div> 
    </div>
</div>
<jsp:include page="includes/footer.jsp" />                      
</body>
</html>