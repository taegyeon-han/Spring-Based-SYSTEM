
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- login form {s} -->

<form:form class="form-signin" name="form" id="form" role="form"
	modelAttribute="LoginVO" method="POST"
	action="${pageContext.request.contextPath}/loginprocess.do">

	<div class="text-center mb-4">
		<h1 class="h3 mb-3 font-weight-normal">공무원 인사관리</h1>
	</div>
	<div class="form-label-group">
		<form:input path="uid" id="uid" class="form-control"
			placeholder="User ID" required="" autofocus="" />
		<label for="uid" class="sr-only">아이디</label>
	</div>
	<div class="form-label-group">
		<form:password path="pwd" id="pwd" class="form-control"
			placeholder="User Password" required="" />
		<label for="pwd" class="sr-only">비밀번호</label>
	</div>

	<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>

	<div class="text-center mb-4">
		<span style="font-size: 11pt;"> <a href="#"
			onClick="fn_btnSignupClick()">가입하기</a>
		</span>
	</div>
	<script>
		function fn_btnSignupClick() {
			location.href = "${pageContext.request.contextPath}/signup";
		}
	</script>

	<script>
		<c:if test="${not empty msg}">
		alert("${msg}");

		</c:if>
		
	</script>
	<p class="mt-5 mb-3 text-muted text-center">
		© 2019. XX시 공무원 인사관리 시스템<br> 담당자 : OOO 주무관 <br> 연락처 :
		XXX-XXXX (내선 OOOO)
	</p>

</form:form>

<!-- login form {e} -->
