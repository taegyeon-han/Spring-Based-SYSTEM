<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
	//공무원증 번호 조회
	
	$(document).on('click', 'btn', function(e) {
		getPost(mode);
	});

	$(document).ready(function() {

		$('#ID_CARD_SERIAL').val('<c:out value="${DBDATA.ID_CARD_SERIAL}"/>');
		
		$("#name").prop('readonly', true);
		$('#name').val('<c:out value="${DBDATA.name}"/>');
		
		$("#LEVEL").prop('readonly', true);
		$('#LEVEL').val('<c:out value="${DBDATA.LEVEL}"/>');
		
		$("#DEPARTMENT").prop('readonly', true);
		$('#DEPARTMENT').val('<c:out value="${DBDATA.DEPARTMENT}"/>');
		
		$("#POSITION").prop('readonly', true);
		$('#POSITION').val('<c:out value="${DBDATA.POSITION}"/>');
		
		$("#identifier").prop('readonly', true);
		$("#identifier").val('<c:out value="${DBDATA.identifier}"/>');


	});

	function getPost(mode) 
	{
		var theForm = document.form;
		if (mode == "01") {
			theForm.method = "post";
			theForm.target = "_self";
			theForm.action = "${pageContext.request.contextPath}/login/insertUser";
			theForm.submit();
			
			
		} else if (mode == "02") {
			theForm.method = "post";
			theForm.target = "_self";
			theForm.action = "${pageContext.request.contextPath}/SearchID";
			theForm.submit();
		}
		
	}

</script>

<article>
	<div class="container col-md-7" role="main">
		<div class="card">
			<div class="card-header">등록하기</div>
			<div class="card-body">

				<form name="form" id="form" role="form" method="post">
						
					<div class="form-group row">
					
						<input type="hidden"  name="identifier" id="identifier"/>
							
						<label for="ID_CARD_SERIAL"
							class="col-md-3 col-form-label text-md-right">공무원증번호</label>
						<div class="col-md-5">
							<input type="text" class="form-control" name="ID_CARD_SERIAL"
								id="ID_CARD_SERIAL" placeholder="공무원증 번호를을 입력해 주세요" />
						</div>

						<input type=button name=btn class="btn btn-sm btn-primary"
							value="조회하기" onClick="getPost('02')">
					</div>

					<div class="form-group row">
						<label for="name" class="col-md-2 col-form-label text-md-right">이름
							: </label>
						<div class="col-md-4">
							<input type="text" style="border: none" class="form-control"
								name="name" id="name" />
						</div>

						<label for="LEVEL" class="col-md-2 col-form-label text-md-right">급수
							: </label>
						<div class="col-md-4">
							<input type="text" style="border: none" class="form-control"
								name="LEVEL" id="LEVEL" />
						</div>
					</div>
					<div class="form-group row">
						<label for="DEPARTMENT"
							class="col-md-2 col-form-label text-md-right">부서 : </label>
						<div class="col-md-4">
							<input type="text" style="border: none" class="form-control"
								name="DEPARTMENT" id="DEPARTMENT" />
						</div>

						<label for="POSITION"
							class="col-md-2 col-form-label text-md-right">직책 : </label>
						<div class="col-md-4">
							<input type="text" style="border: none" class="form-control"
								name="POSITION" id="POSITION" />
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
							<input type="text" class="form-control" name="TELEP_HONE"
								id="TELEP_HONE" placeholder="사무실 번호를 입력해 주세요" />
						</div>
					</div>
					<div class="form-group row">
						<label for="HAND_PHONE"
							class="col-md-3 col-form-label text-md-right">개인 연락처</label>
						<div class="col-md-5">
							<input type="text" class="form-control" name="HAND_PHONE"
								id="HAND_PHONE" placeholder="개인 연락처을 입력해 주세요" />
						</div>
					</div>

					<div class="form-group row">
						<label for="EMAIL" class="col-md-3 col-form-label text-md-right">이메일</label>
						<div class="input-group col-md-7">
							<div class="input-group-prepend">
								<span class="input-group-text">@</span>
							</div>
							<input type="text" class="form-control" name="EMAIL" id="EMAIL"
								placeholder="이메일을 입력해 주세요" />
						</div>
					</div>

				</form>

			</div>
		</div>
		<div style="margin-top: 10px">
			<input type=button name=btn class="btn btn-sm btn-primary"
				value="가입하기" onClick="getPost('01')">
		</div>
	</div>
</article>

