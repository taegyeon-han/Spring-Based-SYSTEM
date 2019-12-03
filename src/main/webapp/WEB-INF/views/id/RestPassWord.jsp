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



<title>비밀번호 초기화</title>

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
		
		$("#uid").val('<c:out value="${IDVO.uid}"/>');
		$("#identifier").val('<c:out value="${IDVO.identifier}"/>');
		
	});

	$(document).on('click', '#btnSave', function(e) {

		e.preventDefault();
		button_event();
		window.close();  

	});

	$(document).on('click', '#btnCancel', function(e) {

		e.preventDefault();
		window.close(); 
	});
	
	function button_event() {

		if (confirm("<c:out value="${IDVO.name}"/>의 비밀번호를 초기화 하겠습니까?") == true) 
		{
			$("#form").submit();
		} else

		{ //취소
			return;
		}

	}
		
	
</script>


</head>

<body>

	<article>

		<div class="container" role="main">

			<h3>비밀번호 초기화</h3>

			<form name="form" id="form" role="form" method="post"
				action="/id/Reseting">

				<div class="mb-3">
				
						<input type="hidden"
						class="form-control" name="uid" id="uid" >
						<input type="hidden"
						class="form-control" name="identifier" id="identifier" >
						
						

					<label for="title">비밀번호 입력</label> <input type="password"
						class="form-control" name="pwd" id="pwd"
						placeholder="비밀번호를 입력 해 주세요">
					
				</div>


				<div class="mb-3">

					<label for="reg_id">비밀번호 재입력</label> <input type="password"
						class="form-control" name="re_pwd" id="re_pwd"
						placeholder="비밀번호를 다시 입력 해 주세요">

				</div>

			</form>

			<div>

				<button type="button" class="btn btn-sm btn-primary" id="btnSave">비밀번호 초기화</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnCancel">취소</button>

			</div>

		</div>

	</article>

</body>

</html>

