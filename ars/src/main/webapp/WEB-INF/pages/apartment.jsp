<%-- 
    Document   : apartment
    Created on : Oct 21, 2014, 1:28:25 PM
    Author     : CKarki
--%>

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
                <h1>Apartments</h1>
                
                
          
                
                
                <p> ${newApartment.title}</p>
                <p> ${newApartment.description}</p>
                <p> ${newApartment.address.street}</p>
                <p> ${newApartment.address.city}</p>
                <p> ${newApartment.address.stateName}</p>
                <p> ${newApartment.address.zip}</p>
                <p> ${newApartment.roomCount}</p>    
                <p> ${newApartment.facilities}</p>  
                <p> ${newApartment.status}</p> 
                
                  
                    
             
                
            <div class="clear"></div>
                <hr>
            </div>
        </div> 
    </div>
</div>
<jsp:include page="includes/footer.jsp" />                      
</body>
</html>