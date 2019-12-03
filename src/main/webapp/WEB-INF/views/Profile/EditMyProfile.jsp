<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="utf-8">
<title>개인 정보 수정하기</title>

<!-- jQuery -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<!-- common CSS -->
<link rel="stylesheet" href="/resources/common/css/common.css">


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


</head>


<script>
	$(document).ready(function() {

		$("#uid").prop('readonly', true);
		$("#uid").val('<c:out value="${DBDATA.uid}"/>');
		
		$("#DBDATA.ID_CARD_SERIAL").prop('readonly', true);
		$("#DBDATA.ID_CARD_SERIAL").val('<c:out value="${DBDATA.ID_CARD_SERIAL}"/>');

	});

	$(document).on('click', '#btnEdit', function(e) {

		e.preventDefault();
		$("#form").submit();
	});
</script>
<div>
	<article>
		<div class="container col-md-7" role="main">
			<div class="card">
				<div class="card-header">개인 정보 수정</div>
				<div class="card-body">

					<form name="form" id="form" role="form" method="post"
						action="${pageContext.request.contextPath}/Profile/UpdateUser">

						<div class="form-group row">
							<input type="hidden" class="form-control" name="uid" id="uid" /> 
							<input type="hidden" class="form-control" name="ID_CARD_SERIAL" id="ID_CARD_SERIAL" /> 
						</div>

						<div class="form-group row">
							<label for="name" class="col-md-2 col-form-label text-md-right">이름:
							</label>
							<div class="col-md-4">
								<c:out value="${Profile.name}" />
							</div>

							<label for="LEVEL" class="col-md-2 col-form-label text-md-right">급수
								: </label>
							<div class="col-md-4">
								<c:out value="${Profile.LEVEL}" />
							</div>
						</div>

						<div class="form-group row">
							<label for="DEPARTMENT"
								class="col-md-2 col-form-label text-md-right">부서 : </label>
							<div class="col-md-4">
								<c:out value="${Profile.DEPARTMENT}" />
							</div>

							<label for="POSITION"
								class="col-md-2 col-form-label text-md-right">직책 : </label>
							<div class="col-md-4">
								<c:out value="${Profile.POSITION}" />
							</div>
						</div>

						<div class="form-group row">
							<label for="BIRTH" class="col-md-3 col-form-label text-md-right">생년월일</label>
							<div class="col-md-5">
								<c:out value="${Profile.BIRTH}"/>
							</div>
						</div>

						<div class="form-group row">
							<label for="pwd" class="col-md-3 col-form-label text-md-right">비밀번호</label>
							<div class="col-md-5">
								<input type="password" class="form-control" name="pwd" id="pwd"
									placeholder="비밀번호를 입력해 주세요" />
							</div>
						</div>
						<div class="form-group row">
							<label for="re_pwd" class="col-md-3 col-form-label text-md-right">비밀번호
								확인</label>
							<div class="col-md-5">
								<input type="password" class="form-control" id="re_pwd"
									placeholder="비밀번호를 다시 입력해 주세요" />
							</div>
						</div>
						<div class="form-group row">
							<label for="TELEP_HONE"
								class="col-md-3 col-form-label text-md-right">사무실 전화번호</label>
							<div class="col-md-5">
								<input type="text" class="form-control" id="TELEP_HONE"
									name="TELEP_HONE" placeholder="사무실 번호를 입력해 주세요" />
							</div>
						</div>
						<div class="form-group row">
							<label for="HAND_PHONE"
								class="col-md-3 col-form-label text-md-right">개인 연락처</label>
							<div class="col-md-5">
								<input type="text" class="form-control" id="HAND_PHONE"
									name="HAND_PHONE" placeholder="개인 연락처을 입력해 주세요" />
							</div>
						</div>
					</form>
				</div>
			</div>
			<div style="margin-top: 10px">
				<button type="button" class="btn btn-sm btn-primary" id="btnEdit">수정하기</button>
			</div>
			<script>
				$(document)
						.ready(
								function() {
									$('#uid').val(
											'<c:out value="${DBDATA.uid}"/>');
									$('#ID_CARD_SERIAL')
											.val(
													'<c:out value="${DBDATA.ID_CARD_SERIAL}"/>');
									$('#HAND_PHONE')
											.val(
													'<c:out value="${Profile.HAND_PHONE}"/>');
								
									$('#TELEP_HONE')
											.val(
													'<c:out value="${Profile.TELEP_HONE}"/>');

								});
			</script>
		</div>
	</article>
</div>
</body>
</body>
</html>

