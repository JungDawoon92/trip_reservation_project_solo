<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	background: #f8f8f8;
	padding: 60px 0;
}

#login-form>div {
	margin: 15px 0;
}

div {
	margin: 0 auto;
	margin-top: 50px;
}
h1 { text-align:center; 
	color: #007bff;}
</style>
</head>
<body>

	<div class="container">
		<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-success">  
				<div class="panel-heading"><img src="<%=request.getContextPath()%>/img/aqua_admin.png" class="img-rounded" alt="Cinque Terre" width="500" height="236"></div>
				<div class="panel-body">
					<form id="login-form" action="loginAction.ad" method="post">
						<div>
							<input type="text" class="form-control" name="admin_id"
								placeholder="Admin Id" autofocus>
						</div>
						<div>
							<input type="password" class="form-control" name="admin_pass"
								placeholder="Password">
						</div>
						<div>
							<button type="submit" class="form-control btn btn-primary">로그인</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>