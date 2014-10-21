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
                <h1>Add Apartment</h1>
                <form:form modelAttribute="newApartment" method="post">
                <p>
                    <label>Title : </label>
                    <form:input path="title" cssClass="form-control short" />
                </p>
                <p>
                    <label>Description : </label>
                    <form:input path="description" cssClass="form-control short" />
                </p>
                <p>
                    <label>Address : </label>
                    <form:input path="address" cssClass="form-control short" />
                </p>
                <p>
                    <label>Number of rooms : </label>
                    <form:input path="roomCount" cssClass="form-control short" />
                </p>
                <p>
                    <label>Rate per month : </label>
                    <form:input path="rate" cssClass="form-control short" />
                </p>
                <p>
                    <label>Facilities : </label>
                    <form:input path="facilities" cssClass="form-control short" />
                </p>
                <p>
                    <label>Status : </label>
                    <%--<form:input path="status" cssClass="form-control short" />--%>
                </p>
<!--                <p>
                    <label>Apartment Image : </label>
                    <%--<form:input path="apartImage" type="file" cssClass=" short" />--%>
                </p>-->
              
                <input class="btn btn-primary" type="submit" value="Submit"/>
                
                </form:form>


                <hr>
            </div>
        </div> 
    </div>
</div>
<jsp:include page="includes/footer.jsp" />                      
</body>
</html>