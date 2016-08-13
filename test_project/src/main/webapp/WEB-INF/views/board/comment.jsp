<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<div class="header">
		<a id="menu" class="button menu" href="#menu">M</a>
		<h1 class="title">Layout03</h1>
		<a id="settingMenu" class="button setting" href="#settings">Settings</a>
	</div>

	<div class="popMenu">
		<fieldset>
			<input type="text" name="title" placeholder="제목을 넣으삼">
		</fieldset>
		<fieldset>
			<input type="text" name="writer" placeholder="작성자">
		</fieldset>
		<a class="addJob">ADD</a> <a class="cancelJob"> Cancel</a>
	</div>

	<div class='section'>
		<ul class="list">
		</ul>

		<div class="addDiv">
			<button class="addBtn">글쓰기</button>
		</div>

		<div class="more">
			<button>더보기</button>
		</div>

	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script src="../resources/js/comment.js"></script>


	<script>
		$(document).ready(function() {

			var todoListUL = $(".list");
			var totalCount = 0;
			var currentPage = 1;
			var popMenu = $(".popMenu");

			console.log("START READY");

			todoManager.getCommentData(1, displayList); // todoController.js 
			console.log("222222222");

			function displayList(arr) {
				
				console.log("arr = " + arr.commentList[0].bno);
				var str = "";
			
				$.each(arr.commentList, function(idx, obj) {
					
					console.log(obj.cno);	// 절대암기
				    str += "<li>" +obj.cno+ ":" + obj.contents + "</a></li>";
				    
	            });

				todoListUL.html(str); // 화면 출력
				
			}
		});
	</script>


	</script>
</body>
</html>