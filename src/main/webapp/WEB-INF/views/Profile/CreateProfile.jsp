<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<head>
<title>개인 인사 정보 생성</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<link rel="stylesheet"
	href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script>
	$(document).on('click', '#btnSave', function(e) {

		e.preventDefault();
		$("#form").submit();
	});
</script>

</head>


<div class="container bootstrap snippet">

	<div class="row">
		<form:form name="form" id="form" role="form" method="post"
			modelAttribute="ProfileVO" enctype="multipart/form-data"
			action="${pageContext.request.contextPath}/Profile/CreateProfiling">

			<div class="col-sm-3">
				<!--사진 파트-->
				<div class="text-center">
					<div class="select_img">
						<img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png"
							class="avatar img-square img-thumbnail" alt="avatar">
					<label for="person_image">증명사진를 넣으세요</label>
					<input type="file" id="person_image" name="IMG" class="text-center center-block file-upload" />
					<script>
						$("#person_image").change(
								function() {
									if (this.files && this.files[0]) {
										var reader = new FileReader;
										reader.onload = function(data) 
										{
											$(".select_img img").attr("src",
													data.target.result).width(
													180);
										}
										reader.readAsDataURL(this.files[0]);
									}
								});
					</script>
					</div>
				</div>
			</div>

			<!--/col-3-->

			<div class="col-sm-9">
				<div class="col-xs-6">
					<label for="ID_CARD_SERIAL"><h3>공무원증 번호</h3></label>
					<form:input path="ID_CARD_SERIAL" id="ID_CARD_SERIAL"
						class="form-control" placeholder="내용을 입력해 주세요" />
				</div>

				<div class="col-xs-6">
					<label for="NAME"><h3>이름</h3></label>
					<form:input path="name" id="name" class="form-control"
						placeholder="내용을 입력해 주세요" />
				</div>


				<div class="col-xs-6">
					<label for="DEPARTMENT"><h3>부서</h3></label>
					<form:input path="DEPARTMENT" id="DEPARTMENT" class="form-control"
						placeholder="내용을 입력해 주세요" />
				</div>


				<div class="col-xs-6">
					<label for="POSITION"><h3>직책</h3></label>
					<form:input path="POSITION" id="POSITION" class="form-control"
						placeholder="내용을 입력해 주세요" />
				</div>

				<div class="col-xs-6">
					<label for="LEVEL"><h3>급수</h3></label>
					<form:input path="LEVEL" id="LEVEL" class="form-control"
						placeholder="내용을 입력해 주세요" />
				</div>

				<div class="col-xs-6">
					<label for="WOR_KDATE"><h3>임용일자</h3></label>
					<form:input path="WOR_KDATE" id="WOR_KDATE" class="form-control"
						placeholder="내용을 입력해 주세요" />
					<script>
						$(function() {
							$("#WOR_KDATE").datepicker(
									{
										dateFormat : 'yy.mm.dd',
										prevText : '이전 달',
										nextText : '다음 달',
										monthNames : [ '1월', '2월', '3월', '4월',
												'5월', '6월', '7월', '8월', '9월',
												'10월', '11월', '12월' ],
										monthNamesShort : [ '1월', '2월', '3월',
												'4월', '5월', '6월', '7월', '8월',
												'9월', '10월', '11월', '12월' ],
										dayNames : [ '일', '월', '화', '수', '목',
												'금', '토' ],
										dayNamesShort : [ '일', '월', '화', '수',
												'목', '금', '토' ],
										dayNamesMin : [ '일', '월', '화', '수',
												'목', '금', '토' ],
										showMonthAfterYear : true,
										changeMonth : true,
										changeYear : true,
										yearSuffix : '년'
									});
						});
					</script>
				</div>
				
				<div class="col-xs-6">
					<label for="BIRTH"><h3>생년월일</h3></label>
					<form:input path="BIRTH" id="BIRTH" class="form-control"
						placeholder="내용을 입력해 주세요" />
					<script>
						$(function() {
							$("#BIRTH").datepicker(
									{
										dateFormat : 'yy.mm.dd',
										prevText : '이전 달',
										nextText : '다음 달',
										monthNames : [ '1월', '2월', '3월', '4월',
												'5월', '6월', '7월', '8월', '9월',
												'10월', '11월', '12월' ],
										monthNamesShort : [ '1월', '2월', '3월',
												'4월', '5월', '6월', '7월', '8월',
												'9월', '10월', '11월', '12월' ],
										dayNames : [ '일', '월', '화', '수', '목',
												'금', '토' ],
										dayNamesShort : [ '일', '월', '화', '수',
												'목', '금', '토' ],
										dayNamesMin : [ '일', '월', '화', '수',
												'목', '금', '토' ],
										showMonthAfterYear : true,
										changeMonth : true,
										changeYear : true,
										yearSuffix : '년'
									});
						});
					</script>
				</div>
			</div>
		</form:form>
	</div>
	<button type="button" class="btn btn-sm btn-primary" id="btnSave">작성</button>
</div>


