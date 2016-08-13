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
							<li><a href="/board/list">글 목록</a></li>
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
				
					<div class="panel-heading">
								Context Classes
				
						 <a style='float:right' href="/board/delete?bno=${view.bno}" class="btn btn-warning"><span
                     			class="glyphicon glyphicon-remove"></span>삭제</a>
							
							<a style='float:right'>&nbsp; </a>

						<%-- <form style='float:right' action ="/board/modify?bno=${view.bno}" method="get"> --%>
							<a style='float:right' href="/board/modify?bno=${view.bno}" class="btn btn-success"><span
                     			class="glyphicon glyphicon-pencil"></span> 수정 </a>								
					</div>
					
					
					
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th>글 번호</th>
										<th>내용</th>
										<th>작성자</th>
									</tr>
								</thead>
								<tbody>
										<tr>
											<th>${view.bno}</th>
											<th>${view.contents}</th>
											<th>${view.writer}</th>
										</tr>
								</tbody>
							</table>


							<div class="row">
								<!-- <div class="col-md-12"> -->
									<div class="panel panel-default">
										<div class="panel-body">
											<div class="panel-group" id="accordion">
												<div class="panel panel-default">
													<div class="panel-heading">
														<h4 class="panel-title">
															<a data-uri="/comment/list/${view.bno}" data-toggle="collapse" 
																		data-parent="#accordion" href="#collapseOne" 
																		class="collapsed">댓글</a>
														</h4>
													</div>
													<div id="collapseOne" class="panel-collapse collapse" style="height: 0px;">
														<div class="panel-body replyLi"></div>
													</div>
												</div>
											</div>
										</div>
									</div>
								<!-- </div> -->
							</div>
											
							<!-- 댓글 내용 <textarea rows="3" class="form-control" id = "contents" readonly></textarea> -->
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
					&copy; 2015 YourCompany | By : 
					<a href="http://www.designbootstrap.com/" target="_blank">DesignBootstrap</a>
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
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script src="../resources/js/comment.js"></script>
	
	
	
	<!-- 코멘트관련 스크립트 -->
	<script>
		$(document).ready(function(){
			
			var commentList = $(".replyLi");
			var comment 	= $(".panel-title");	// 댓글목록 클래스값 전달.
			var bno   		= ${view.bno};
			var replyList
			
			// comment 클래스에서 a태그부분 사용
			comment.on("click", "a", function () {	// 댓글 누를 시,
				
				var $this = $(this);				// 누른 버튼의정보값을 전달.
				var uri   = $this.attr("data-uri");	// 주소값 추출.
				
				commentManager.getCommentData(uri, displayList);	// callback함수 전달.
				
				function displayList(arr) {

					replyList = arr;
					var str="";
					
					$.each(arr, function(idx, obj) {
						
							/* console.log(obj.cno);	// 절대암기 */
						    str += "<li class = commentList>" +obj.writer+ ":" + obj.contents + "&nbsp" 
						    + "<a data-idx="+idx+" data-cno=" + obj.cno 
						    + " name = 'modify' class='btn btn-success btn-xs mod'>수정</a>"+"&nbsp"
						    
						    + "<a data-cno=" +obj.cno+ " name = 'delete' class='btn btn-danger btn-xs del'>삭제</a></li>"
						    + "<div data-cno="+obj.cno+" id=cno"+obj.cno+"></div>";	// 해당하는 번호의 영역
						   
			        });//Edn forEach
					
					str += "<div class = 'commentRegister'>"
						   +"내용 <input data-bno="+bno+" type='textArea' name = 'contents'>"
						   +"<input type='submit' id = 'commit' class = 'btn' value = '등록'>" + "</div>";
					
					// 화면 출력
					commentList.html(str);
					
					// 등록 버튼 
					$('#commit').on('click', function () {
					     var obj = {};
					 					     
					     obj.bno       = $(".commentRegister input[name='contents']").attr('data-bno');
					     obj.contents  = $(".commentRegister input[name='contents']").val();

					     console.log("obj.bno =" + obj.bno);
					     console.log("obj.contents =" + obj.contents);
						 
					     commentManager.addData(obj, function () {
					     	commentManager.getCommentData("/comment/list/"+obj.bno, displayList); // displayList -> 새로고침 역할 
					     });
					});
					
					
					// 삭제 버튼
					$('.del').on('click', function () {
						console.log("START DELETE");
						
						var obj = {};
						
						obj.bno = $(".commentRegister input[name='contents']").attr('data-bno');
						obj.cno = $(".commentList a[name ='delete']").attr('data-cno');
						
						commentManager.deleteData(obj, function () {
					     	commentManager.getCommentData("/comment/list/"+obj.bno, displayList); // displayList -> 새로고침 역할
						});
					});
					
					
					// 수정 버튼
					$('.mod').on('click', function () {
						
						var $this =$(this);
						console.log("START MODIFY");
						
						var idx = $this.attr('data-idx');
						var bno = replyList[idx].bno;
						var cno = $this.attr('data-cno');
						var contents =  replyList[idx].contents;

						console.log("bno = "+bno);
						console.log("contents =" +contents);
						
						var str = "<textarea  id='contents' rows='2' cols='50'>"+ contents +"</textarea>";
						
						str += "<a data-cno='" + cno + "' name = 'delete' class='btn btn-warning btn-xs complete'>완료</a>";
						
						$('#cno'+cno).html(str);
						
						
						$('.complete').on('click', function () {
							
							var obj = {};
							
							obj.bno = bno;
							obj.cno = cno;
							obj.contents = $('#contents').val();
							
							console.log("$('#contents').val() =" +$('#contents').val());
							
							commentManager.updateData(obj, function () {
						     	commentManager.getCommentData("/comment/list/"+obj.bno, displayList); // displayList -> 새로고침 역할
						     	
						     	$('#cno'+cno).html("");
							});
						
						});
						
						//commentList.html(str);
					
					});
										
				}//End display
			});//End Click
			
		}); //end ready						 
	</script>
	
</body>
</html>
