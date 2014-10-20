<jsp:include page="includes/head.jsp" />
<jsp:include page="includes/header.jsp" />

<!-- Begin Body -->
<div class="container">
	<div class="row">
  		<div class="col col-sm-3">
              	
                    <jsp:include page="includes/sidebar.jsp" />    
                    
                    
      		</div>  
      		<div class="col col-sm-9">
              <div class="panel">
              <h1>User Login</h1>
              
              
              <c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm'
			action="<c:url value='/j_spring_security_check' />" method='POST'>

			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' name='username'></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="submit" /></td>
				</tr>
			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
              
              
              
              	<h1><a href="#"><i class="glyphicon glyphicon-user"></i> <i class="glyphicon glyphicon-chevron-down"></i></a></h1>
              
              	<hr>
              	<h4><a href="http://bootply.com/">Bootply</a></h4>
              	<hr>
             	</div>
      	</div> 
  	</div>
</div>



	<!-- script references -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="resources/js/bootstrap.min.js"></script>
		<script src="resources/js/scripts.js"></script>
	</body>
</html>