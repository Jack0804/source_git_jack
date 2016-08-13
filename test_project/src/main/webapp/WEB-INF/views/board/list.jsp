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

<!-- bootStarp 사용하려면 -->
<!-- 
	원하는 부트스트랩 파일을 다운로드
	/src/main/webapp/resources 경로 아래 bootstrap를 붙여넣기
	href에 해당되는 경로들을 boot스트랩 경로로 설정
 -->

<title>Free Responsive Admin Theme - ZONTAL</title>
<!-- BOOTSTRAP CORE STYLE  -->
<!-- BOOTSTRAP의 resource 적용 -->
<link href="/resources/bootstrap/assets/css/bootstrap.css"
	rel="stylesheet" />
<!-- FONT AWESOME ICONS  -->
<link href="/resources/bootstrap/assets/css/font-awesome.css"
	rel="stylesheet" />
<!-- CUSTOM STYLE  -->
<link href="/resources/bootstrap/assets/css/style.css" rel="stylesheet" />
<!-- HTML5 Shiv and Respond.js for IE8 support of HTML5 elements and media queries -->


</head>


<body>

<style>
.pageUL {
  list-style: none;
  
}

.pageUL li {
  float: left;
  margin: 10px;
  padding: 10px;
}

a {
  text-decoration: none;

}

.current{
  background-color:pink;
  font-weight: bold;
}

</style>

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
					src="../resources/bootstrap/assets/img/logo.png" />
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
							<li><a class="menu-top-active" href="/board/list">글 목록</a></li>
							<li><a href="/board/register">글 등록</a></li>
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
				<div class="col-md-12">
					<h1 class="page-head-line">Data Tables</h1>
				</div>
			</div>

			<div class="row">
				<!--    Context Classes  -->
				<div class="panel panel-default">
					<div class="panel-heading">Context Classes</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>	<!-- 메인화면 가운데 테이블을 사용한 게시판목록 출력 -->
										<th>글 번호</th>
										<th>글 제목</th>
										<th>작성자</th>
										<th>등록날짜</th>
										<th>수정날짜</th>
										<th>조회수</th>
										<th>댓글수</th>
									</tr>
								</thead>
								<tbody>
								<!-- BoardController.java에서 list 메소드에 Model을 사용하여 Key값 "result"를 가져온다. -->		
									<c:forEach items="${result}" var="list">
										<tr>
											<td>${list.bno}</td>
											<td><a href="/board/view?bno=${list.bno}"> ${list.title}[${list.comments}] </a></td>
											<td>${list.writer}</td>
											<td>${list.regDate}</td>
											<td>${list.modifyDate}</td>
											<td>${list.hits}</td>
											<td>${list.comments}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

							<ul class="pageUL">
								<c:if test="${pageMaker.prev }">
									<li><a href='list?page=${pageMaker.start -1}'>이전</a></li>
								</c:if>

								<c:forEach begin="${pageMaker.start }" end="${pageMaker.end}" var="idx">
									<li
										class='<c:out value="${idx == pageMaker.page?'current':''}"/>'>
										<a href='list?page=${idx}'>${idx}</a>
									</li>
								</c:forEach>

								<c:if test="${pageMaker.next }">
									<li><a href='list?page=${pageMaker.end +1}'>다음</a></li>
								</c:if>
							</ul>

						</div>
					</div>
					<!--  end  Context Classes  -->
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
	<script src="../resources/bootstrap/assets/js/jquery-1.11.1.js"></script>
	<!-- BOOTSTRAP SCRIPTS  -->
	<script src="../resources/bootstrap/assets/js/bootstrap.js"></script>
</body>
</html>
