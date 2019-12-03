
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


<hr>


<script>


	$(document).on('click', '#btnEdit', function(e) {

		e.preventDefault();
		$("#form").submit();
	});
</script>

<form name="form" id="form" role="form" method="post"
	action="${pageContext.request.contextPath}/Profile/EditProfile">

	<input type="hidden" class="form-control" name="identifier"
		id="identifier">

	<script type="text/javascript">
		$("#identifier").prop('readonly', true);
		$("#identifier").val('<c:out value="${identifier.identifier}"/>');
	</script>

</form>

<div class="container bootstrap snippet">

	<div class="row">
		<div class="col-sm-3">
			<!--left col-->

			<div class="text-center">
				<img src="<c:out value="${identifier.person_image}"/>"
					class="avatar img-square img-thumbnail" alt="avatar">
			</div>
			<br>

		</div>
		<!--/col-3-->
		<div class="col-sm-9">
			<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#home">개인 정보</a></li>
				<li><a data-toggle="tab" href="#messages">인사 기록</a></li>
			</ul>


			<div class="tab-content">
				<div class="tab-pane active" id="home">
				
					<div class="form-group">

						<div class="col-xs-6">
							<label for="first_name"><h4>공무원증 번호</h4></label>
							<h4>
								<font color="#4d79ff">${identifier.ID_CARD_SERIAL}</font>
							</h4>
						</div>

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
							<label for="phone"><h4>임용 일자</h4></label>
							<h4>
								<font color="#4d79ff">${identifier.WOR_KDATE}</font>
							</h4>
						</div>
					</div>

					<div class="form-group">
						<div class="col-xs-6">
							<label for="mobile"><h4>예상퇴직 일자</h4></label>
							<h4>
								<font color="#4d79ff">${identifier.END_WORK_DATE}</font>
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
								<font color="#4d79ff">${identifier.POSITION}</font>
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
							<label for="password2"><h4>직무</h4></label>
							<h4>
								<font color="#4d79ff">${identifier.JOBS}</font>
							</h4>
						</div>
					</div>


				</div>


				<!--/tab-pane-->
				<div class="tab-pane" id="messages">

					<div class="container">
						<div class="table-responsive" >
							<table class="table table-striped table-sm" style="width: 800px;">
							
								<colgroup>
									<col style="width: 30px;"/>     
									<col style="width: 200px;"/>         
							   	    <col style="width: 70px;"/>         
								</colgroup>

								<thead>
									<tr>
										<th>번호</th>
										<th>내용</th>
										<th>일자</th>
									</tr>

								</thead>

								<tbody>

									<c:choose>

										<c:when test="${empty record}">
											<tr>
												<td colspan="3" align="center">데이터가 없습니다.</td>
											</tr>
										</c:when>

										<c:when test="${!empty record}">

											<c:forEach var="list" items="${record}">
												<tr>
													<td>${list.bid}</td>
													<td>${list.content}</td>
													<td>${list.reg_dt}</td>
												</tr>

											</c:forEach>


										</c:when>

									</c:choose>

								</tbody>

							</table>


						</div>

						<div>
					</div>
						<!--/tab-pane-->
					</div>
				</div>

			</div>
			<!--/tab-pane-->
		</div>
		<!--/tab-content-->

	</div>
	<!--/col-9-->
	<button type="button" class="btn btn-sm btn-primary" id="btnEdit">개인 정보 수정</button>
</div>
<!--/row-->
