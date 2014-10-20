<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-static">
    <div class="container">
      <a class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
        <span class="glyphicon glyphicon-chevron-down"></span>
      </a>
      <div class="nav-collapse collase">
        <ul class="nav navbar-nav">  
          <li><a href="/ars/">Home</a></li>
          <li><a href="#">Link</a></li>
          <li><a href="#">Link</a></li>
        </ul>
        <ul class="nav navbar-right navbar-nav">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-search"></i></a>
            <ul class="dropdown-menu" style="padding:12px;">
                <form class="form-inline">
     				<button type="submit" class="btn btn-default pull-right"><i class="glyphicon glyphicon-search"></i></button><input type="text" class="form-control pull-left" placeholder="Search">
                </form>
              </ul>
          </li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i> <i class="glyphicon glyphicon-chevron-down"></i></a>
            <ul class="dropdown-menu">
              <li><a href="login">Login</a></li>
              <li><a href="user/profile">Profile</a></li>
              <li class="divider"></li>
              <li><a href="#">About</a></li>
             </ul>
          </li>  
        </ul>
      </div>		
    </div>
</nav><!-- /.navbar -->


<header class="masthead">
  <div class="container">
    <div class="row">
      <div class="col col-sm-6">
        <h1><a href="#" title="scroll down for your viewing pleasure">Apartment Rental Service</a>
            <p class="lead">Select of your choice <i class=""></i> Make Booking => Rent </p></h1>
      </div>
      <div class="col col-sm-6">
        <div class="well pull-right">
          <img src="//placehold.it/280x100/E7E7E7">        
        </div>
      </div>
    </div>
  </div>
    
      
  <div class="container">
	<div class="row">
      <div class="col col-sm-12">
        
        <div class="panel">
        <div class="panel-body">
          You may want to put some news here  <span class="glyphicon glyphicon-heart-empty"></span>
        </div>
        </div>
        
      </div>
  	</div>
  </div>
</header>
    