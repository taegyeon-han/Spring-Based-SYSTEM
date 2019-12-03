
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
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<head>
<title>인사정보</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>


<div class="container bootstrap snippet">

	<div class="row">
		<div class="col-sm-3">
			<!--left col-->

			<div class="text-center">
				<img
					src="http://localhost:8080<c:out value="${identifier.person_image}"/>"
					class="avatar img-square img-thumbnail" alt="avatar">
			</div>
			<br>


		</div>
		<!--/col-3-->
		<div class="col-sm-9">

			<div class="tab-content">
				<div class="tab-pane active" id="home">
					

					<div class="form-group">

						<div class="col-xs-6">
							<label for="first_name"><h4>이름</h4></label>
							<h4>
								<font color="#4d79ff">${identifier.name}</font>
							</h4>
						</div>
					</div>

					<div class="form-group">

						<div class="col-xs-6">
							<label for="last_name"><h4>급수</h4></label>
							<h4>
								<font color="#4d79ff">${identifier.LEVEL}</font>
							</h4>
						</div>
					</div>
					
					<div class="form-group">

						<div class="col-xs-6">
							<label for="last_name"><h4>재직상태</h4></label>
							<h4>
								<font color="#4d79ff">${identifier.STATUS}</font>
							</h4>
						</div>
					</div>
					
						<div class="form-group">

						<div class="col-xs-6">
							<label for="last_name"><h4>생년월일</h4></label>
							<h4>
								<font color="#4d79ff">${identifier.BIRTH}</font>
							</h4>
						</div>
					</div>

					<div class="form-group">

						<div class="col-xs-6">
							<label for="email"><h4>부서</h4></label>
							<h4>
								<font color="#4d79ff">${identifier.DEPARTMENT}</font>
							</h4>
						</div>
					</div>

					<div class="form-group">

						<div class="col-xs-6">
							<label for="email"><h4>직책</h4></label>
							<h4>
								<font color="#4d79ff">${identifier.POSITION}></font>
							</h4>
						</div>
					</div>


					<div class="form-group">

						<div class="col-xs-6">
							<label for="password"><h4>사무실 전화번호</h4></label>
							<h4>
								<font color="#4d79ff">${identifier.TELEP_HONE}</font>
							</h4>
						</div>
					</div>


					<div class="form-group">

						<div class="col-xs-6">
							<label for="password2"><h4>개인연락처</h4></label>
							<h4>
								<font color="#4d79ff">${identifier.HAND_PHONE}</font>
							</h4>
						</div>
					</div>


					<div class="form-group">

						<div class="col-xs-6">
							<label for="password2"><h4>이메일</h4></label>
							<h4>
								<font color="#4d79ff">${identifier.EMAIL}</font>
							</h4>
						</div>
					</div>

					<div class="form-group">

						<div class="col-xs-6">
							<label for="password2"><h4>업무 내용</h4></label>
							<h4>
								<font color="#4d79ff">${identifier.JOBS}</font>
							</h4>
						</div>
					</div>

		

				</div>


			</div>
			<!--/tab-content-->
		</div>
	</div>
	<!--/col-9-->
</div>
<!--/row-->
