<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="./client/css/index.css" />
    <title>AQUA</title>
  </head>
  <body>
    <jsp:include page="client/include/nav.jsp"/>
	
	    <div id="myCarousel" class="carousel slide" data-ride="carousel">
		    <!-- Indicators -->
		    <ol class="carousel-indicators">
		      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		      <li data-target="#myCarousel" data-slide-to="1"></li>
		      <li data-target="#myCarousel" data-slide-to="2"></li>
		      <li data-target="#myCarousel" data-slide-to="3"></li>
		      <li data-target="#myCarousel" data-slide-to="4"></li>
		    </ol>
		
		    <!-- Wrapper for slides -->
		    <div class="carousel-inner" role="listbox">
		      <div class="item active">
		        <img src="./img/seoul.jpg" alt="Image">
		      </div>
		      <div class="item">
		        <img src="./img/incheon.jpg" alt="Image">
		      </div>
		      <div class="item">
		        <img src="./img/busan.jpg" alt="Image">
		      </div>
		      <div class="item">
		        <img src="./img/jeju.jpg" alt="Image">
		      </div>
		      <div class="item">
		        <img src="./img/spring_jeju.jpg" alt="Image">
		      </div>
		    </div>
	
		    <!-- Left and right controls -->
		    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
		      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		      <span class="sr-only">Previous</span>
		    </a>
		    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
		      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		      <span class="sr-only">Next</span>
		    </a>
		</div>
		
		
<div class="container">
  <div class="row">
    <div class="col-sm-4">
      <jsp:include page="client/include/recentreview.jsp"></jsp:include>
      </div>
    <div class="col-sm-4">
      <jsp:include page="client/include/recentreview.jsp"></jsp:include>
    </div>
    <div class="col-sm-4">
      <jsp:include page="client/include/recentreview.jsp"></jsp:include>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>
  </body>
</html>
