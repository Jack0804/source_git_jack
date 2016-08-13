<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta name="description" content="" />
<meta name="author" content="" />
<!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
<title>Free Responsive Admin Theme - ZONTAL</title>
<!-- BOOTSTRAP CORE STYLE  -->
<link href="/resources/bootstrap/assets/css/bootstrap.css"
	rel="stylesheet" />
<!-- FONT AWESOME ICONS  -->
<link href="/resources/bootstrap/assets/css/font-awesome.css"
	rel="stylesheet" />
<!-- CUSTOM STYLE  -->
<link href="/resources/bootstrap/assets/css/style.css" rel="stylesheet" />
<!-- HTML5 Shiv and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<header>
		<div class="container">
			<div class="row">
				

			</div>
		</div>
	</header>
	<!-- HEADER END-->
	<div class="navbar navbar-inverse set-radius-zero">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/board/list"> <img
					src="/resources/bootstrap/assets/img/logo.png" />
				</a>

			</div>

			<div class="left-div">
				<div class="user-settings-wrapper">
					<ul class="nav">

						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#" aria-expanded="false"> <span
								class="glyphicon glyphicon-user" style="font-size: 25px;"></span>
						</a>
							<div class="dropdown-menu dropdown-settings">
								<div class="media">
									<a class="media-left" href="#"> <img
										src="/resources/bootstrap/assets/img/64-64.jpg" alt=""
										class="img-rounded" />
									</a>
									<div class="media-body">
										<h4 class="media-heading">Jhon Deo Alex</h4>
										<h5>Developer & Designer</h5>

									</div>
								</div>
								<hr />
								<h5>
									<strong>Personal Bio : </strong>
								</h5>
								Anim pariatur cliche reprehen derit.
								<hr />
								<a href="#" class="btn btn-info btn-sm">Full Profile</a>&nbsp; <a
									href="login.html" class="btn btn-danger btn-sm">Logout</a>

							</div></li>


					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- LOGO HEADER END-->
	<section class="menu-section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="navbar-collapse collapse ">
						<ul id="menu-top" class="nav navbar-nav navbar-right">
							<li><a href="/board/list">글 목록</a></li>
							<li><a class="menu-top-active" href="/board/register">글
									등록</a></li>
							<li><a href="/board/login">로그인</a></li>
						</ul>
					</div>
				</div>

			</div>
		</div>
	</section>
	<!-- MENU SECTION END-->
	<div class="content-wrapper">
		<div class="container">
			<div class="row">
					<h4 class="page-head-line">Dashboard</h4>
			</div>

			<div class="row">
				<div class="row">
					<hr />
					<div class="Compose-Message">
						<div class="panel panel-success">
							<div class="panel-heading">글 작성 게시판입니다.</div>
							<div class="panel-body">
							
								<form action ="/board/modify" method="post">
									<label> 작성자  </label> 
									<input type="text" name ="writer" class="form-control" value='${modify.writer}' readonly/> 
									<label> 제목을 입력하세요  </label> 
									<input type="text" name ="title" class="form-control" value='${modify.title}'/> 
									<label>내용을 입력하세요  </label>
									<textarea rows="9" name ="contents" class="form-control ">${modify.writer}</textarea>
									
									<input type="hidden" name ="bno" class="form-control" value='${modify.bno}'/> 
									<hr />
								<table>
								<tr>
									<th>
										<button class="btn btn-success">
										<span class="glyphicon glyphicon-ok"></span> 수정 완료 </button>&nbsp;
									</th>	
								</form>
								
									<th>
										<a  href="/board/view?bno=${modify.bno}" class="btn btn-warning"><span
                     						class="glyphicon glyphicon-remove"></span>취소</a>
									</th>
								</tr>
								</table>
							</div>
							<div class="panel-footer text-muted">
								<strong>Note : </strong>Please note that we track all messages
								so don't send any spams.
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- CONTENT-WRAPPER SECTION END-->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					&copy; 2015 YourCompany | By : <a
						href="http://www.designbootstrap.com/" target="_blank">DesignBootstrap</a>
				</div>

			</div>
		</div>
	</footer>
	<!-- FOOTER SECTION END-->
	<!-- JAVASCRIPT AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
	<!-- CORE JQUERY SCRIPTS -->
	<script src="/resources/bootstrap/assets/js/jquery-1.11.1.js"></script>
	<!-- BOOTSTRAP SCRIPTS  -->
	<script src="/resources/bootstrap/assets/js/bootstrap.js"></script>
</body>
</html>
