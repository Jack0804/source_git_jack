<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<style type="text/css">

*{
width: 800px; 
margin: auto; 
margin-left: expression(((document.body.clientWidth>800) ? ((document.body.clientWidth-800)/2) : 0) + "px"); 
}

img.t{
	width:10%
}


</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>


</head>
<body>
	<h1> ${msg} 님, 환영합니다.</h1> 
	<div class="leftdiv">
	<img width=10%  alt="" src="../../images/1.jpg" class="t">
	<img width=10%  alt="" src="../../images/2.jpg" class="t">
	<img width=10%  alt="" src="../../images/3.jpg" class="t">
	
		<h1>공지글</h1>
	<table border="1">
		<tr>
			<td>제목</td>
			<td>내용</td>
			<td>작성자</td>
			<td>수정 날짜</td>
		</tr>
	<c:forEach items="${result}" var="result">
		<tr>
			<td> <a href ="/board/viewpage?rid=${result.rid}"> ${result.rtitle}</a></td>
			<td> <a href ="/board/viewpage?rid=${result.rid}"> ${result.rcontent}</a></td>
			<td> <a href ="/board/viewpage?rid=${result.rid}"> ${result.mid}</a></td>
			<td> <a href ="/board/viewpage?rid=${result.rid}"> ${result.modifydate}</a></td>
		</tr>
		
	</c:forEach>
				
	</table>
	
	</div>
	
	<div class="rightdiv">
	<form action = "/board/sharelist" method = "get">
		<button> 공유글 보기</button><br>
	</form>
	</div>
	<br/>
	

	