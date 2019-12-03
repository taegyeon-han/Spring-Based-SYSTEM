<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="utf-8">

<!-- jQuery -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<!-- common CSS -->
<link rel="stylesheet"
	href="/resources/common/css/common.css">

<style>
body {
	padding: 0px
}

#tile_header {
	width: 100%;
}

#tile_body {
	width: 100%;
	float: left;
}
</style>



<!-- jQuery -->

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- Bootstrap CSS -->

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<!-- common CSS -->

<link rel="stylesheet" href="/resources/common/css/common.css">


<head>

<meta charset="UTF-8">



<title>글 쓰기</title>

<!-- jQuery -->

<script src="http://code.jquery.com/jquery-latest.min.js"></script>



<!-- Bootstrap CSS -->

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
	
	<link rel="stylesheet"
	href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
	

<script>
	$(document).ready(function() {

		$("#bid").val('<c:out value="${record.bid}"/>');
		$("#identifier").val('<c:out value="${record.identifier}"/>');
		
		$("#reg_dt").val('<c:out value="${record.reg_dt}"/>');
		$("#content").val('<c:out value="${record.content}"/>');

	});

	$(document).on('click', '#btnSave', function(e) {

		e.preventDefault();
		$("#form").submit();
		window.close();  


	});

	$(document)	.on('click','#btnList', function(e) {

	e.preventDefault();
	window.close();  

	});
	
	
	
	
	$(function() {
		$("#reg_dt").datepicker(
				{
					dateFormat : 'yy.mm.dd',
					prevText : '이전 달',
					nextText : '다음 달',
					monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
							'8월', '9월', '10월', '11월', '12월' ],
					monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월',
							'7월', '8월', '9월', '10월', '11월', '12월' ],
					dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
					dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
					showMonthAfterYear : true,
					changeMonth : true,
					changeYear : true,
					yearSuffix : '년'
				});
	});
	
	
</script>


</head>

<body>

	<article>

		<div class="container" role="main">

			<h3>인사 기록 수정 하기</h3>

			<form name="form" id="form" role="form" method="post"
				action="/Profile/EditingRecord">

				<div class="mb-3">
				
					<input type="hidden"
						class="form-control" name="bid" id="bid">
						
					<input type="hidden"
						class="form-control" name="identifier" id="identifier" >
						

					<label for="title">날짜</label> <input type="text"
						class="form-control" name="reg_dt" id="reg_dt"
						placeholder="제목을 입력해 주세요">
					
				</div>


				<div class="mb-3">

					<label for="reg_id">내용</label> <input type="text"
						class="form-control" name="content" id="content"
						placeholder="태그를 입력해 주세요">

				</div>

			</form>

			<div>

				<button type="button" class="btn btn-sm btn-primary" id="btnSave">수정</button>

				<button type="button" class="btn btn-sm btn-primary" id="btnList">취소</button>

			</div>

		</div>

	</article>

</body>

</html>

