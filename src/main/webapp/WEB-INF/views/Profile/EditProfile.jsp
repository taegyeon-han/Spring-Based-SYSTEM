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
<title>개인 인사 정보 수정</title>
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
	$(document).on('click', '#btnEdit', function(e) {

		e.preventDefault();
		$("#form").submit();
	});

	
	$(document).on('click', '#btndelete', function(e) {

		e.preventDefault();
		button_event();
	});
	
	function button_event() {

		if (confirm("경고! 정말 삭제하시겠습니까? 모든 자료가 삭제 됩니다!") == true) {
			$("#form1").submit();
		} else

		{ //취소
			return;
		}

	}
	
</script>

<script>

function fn_contentView(bid){
	var url = "${pageContext.request.contextPath}/Profile/deleteRecord";
	url = url + "?bid="+bid;
	location.href = url;
}

function fn_contentEdit(bid){
	var url = "${pageContext.request.contextPath}/Profile/EditRecord";
	url = url + "?bid="+bid;
	window.open(url, "수정하기", "width=500, height=400, toolbar=no, menubar=no, scrollbars=no, resizable=no" );  
}

</script>

<script>
	$(function() {
		$("#WOR_KDATE").datepicker(
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

<script>
	$(function() {
		$("#BIRTH").datepicker(
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


<script>
	$(document)
			.ready(
					function() {

						$("#identifier").val(
								'<c:out value="${identifier.identifier}"/>');
						$("#name").val('<c:out value="${identifier.name}"/>');
						$("#ID_CARD_SERIAL")
								.val(
										'<c:out value="${identifier.ID_CARD_SERIAL}"/>');
						$("#WOR_KDATE").val(
								'<c:out value="${identifier.WOR_KDATE}"/>');
						$("#BIRTH").val('<c:out value="${identifier.BIRTH}"/>');
						$("#LEVEL").val('<c:out value="${identifier.LEVEL}"/>');
						$("#DEPARTMENT").val(
								'<c:out value="${identifier.DEPARTMENT}"/>');
						$("#POSITION").val(
								'<c:out value="${identifier.POSITION}"/>');
						$("#EMAIL").val('<c:out value="${identifier.EMAIL}"/>');
						$("#REASON").val(
								'<c:out value="${identifier.REASON}"/>');
			

				});
</script>

</head>

<form:form name="form1" id="form1" role="form" method="post"
	modelAttribute="ProfileVO"
	action="${pageContext.request.contextPath}/Profile/deletingProfile">

	<form:input path="identifier" id="identifier" type="hidden"
		class="form-control" />
</form:form>



<div class="container bootstrap snippet">

	<div class="row">
		<form:form name="form" id="form" role="form" method="post"
			modelAttribute="ProfileVO" enctype="multipart/form-data"
			action="${pageContext.request.contextPath}/Profile/UpdateProfile">

			<div class="col-sm-3">
				<!--사진 파트-->
				<div class="text-center">
					<div class="select_img">
						<img src="<c:out value="${identifier.person_image}"/>"
							class="avatar img-square img-thumbnail" alt="avatar"> <label
							for="person_image">증명사진를 넣으세요</label> <input type="file"
							id="person_image" name="IMG"
							class="text-center center-block file-upload" />
							
						<script>
							$("#person_image")
									.change(
											function() {
												if (this.files && this.files[0]) {
													var reader = new FileReader;
													reader.onload = function(
															data) {
														$(".select_img img")
																.attr(
																		"src",
																		data.target.result)
																.width(180);
													}
													reader
															.readAsDataURL(this.files[0]);
												}
											});
						</script>
					</div>
				</div>
			</div>

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
								<form:input path="ID_CARD_SERIAL" id="ID_CARD_SERIAL"
									name="ID_CARD_SERIAL" class="form-control"
									placeholder="내용을 입력해 주세요" />
									
									<form:input path="identifier" id="identifier"
									name="identifier" class="form-control" type="hidden" />
							</div>

							<div class="col-xs-6">
								<label for="first_name"><h4>이름</h4></label>
								<form:input path="name" id="name" name="name"
									class="form-control" placeholder="내용을 입력해 주세요" />


							</div>
						</div>

						<div class="form-group">

							<div class="col-xs-6">
								<label for="last_name"><h4>재직상태</h4></label>
								<form:input path="STATUS" id="STATUS"
									value="${identifier.STATUS}" name="STATUS" class="form-control"
									placeholder="내용을 입력해 주세요" />
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-xs-6">
								<label for="last_name"><h4>휴직 사유</h4></label>
								<form:input path="REASON" id="REASON"
									value="${identifier.REASON}" name="REASON" class="form-control"
									placeholder="내용을 입력해 주세요" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-xs-6">
								<label for="phone"><h4>급수</h4></label>
								<form:input path="LEVEL" id="LEVEL" name="LEVEL"
									class="form-control" placeholder="내용을 입력해 주세요" />

							</div>
						</div>

						<div class="form-group">
							<div class="col-xs-6">
								<label for="mobile"><h4>임용일자</h4></label>
								<form:input path="WOR_KDATE" id="WOR_KDATE" name="WOR_KDATE"
									class="form-control" placeholder="내용을 입력해 주세요" />

							</div>
						</div>


						<div class="form-group">

							<div class="col-xs-6">
								<label for="last_name"><h4>생년월일</h4></label>
								<form:input path="BIRTH" id="BIRTH" name="BIRTH"
									class="form-control" placeholder="내용을 입력해 주세요" />


							</div>
						</div>

						<div class="form-group">
							<div class="col-xs-6">
								<label for="last_name"><h4>부서</h4></label>
								<form:input path="DEPARTMENT" id="DEPARTMENT" name="DEPARTMENT"
									class="form-control" placeholder="내용을 입력해 주세요" />
							</div>
						</div>

						<div class="form-group">

							<div class="col-xs-6">
								<label for="email"><h4>직책</h4></label>
								<form:input path="POSITION" id="POSITION" name="POSITION"
									class="form-control" placeholder="내용을 입력해 주세요" />

							</div>
						</div>

						<div class="form-group">

							<div class="col-xs-6">
								<label for="email"><h4>이메일</h4></label>
								<form:input path="EMAIL" id="EMAIL" name="POSITION"
									class="form-control" placeholder="내용을 입력해 주세요" />

							</div>
						</div>

						<div class="form-group">

							<div class="col-xs-6">
								<label for="email"><h4>업무내용</h4></label>
								<textarea id="JOBS" rows="5" name="JOBS" class="form-control"
									value="${identifier.JOBS}" placeholder="내용을 입력해 주세요" /></textarea>

							</div>
						</div>

					</div>


					<!--/tab-pane-->
					<div class="tab-pane" id="messages">

						<div class="container">
							<div class="table-responsive">
								<table class="table table-striped table-sm"
									style="width: 800px;">

									<colgroup>
										<col style="width: 10px;" />
										<col style="width: 300px;" />
										<col style="width: 60px;" />
										<col style="width: 10px;" />
										<col style="width: 10px;" />
									</colgroup>

									<thead>
										<tr>
											<th>번호</th>
											<th>내용</th>
											<th>일자</th>
											<th> </th>
											<th> </th>
											
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
														<td><a href="#" onClick="fn_contentView(<c:out value="${list.bid}"/>)" ><font color="#ff0000">삭제</font></a></td>
														<td><a href="#" onClick="fn_contentEdit(<c:out value="${list.bid}"/>)"><font color="#0000ff">수정</font></a></td>
													</tr>

												</c:forEach>


											</c:when>

										</c:choose>

									</tbody>

								</table>


							</div>

						</div>
							<!--/tab-pane-->
						</div>
						
					</div>
					
				</div>
		</form:form>
	</div>
	<button type="button" class="btn btn-sm btn-primary" id="btnEdit">수정</button>
	<button type="button" class="btn btn-sm btn-primary" id="btndelete">삭제</button>
					
</div>