<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- jQuery -->

<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<!-- Bootstrap CSS -->

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">


<!-- common CSS -->

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/common/css/common.css">

<!--메뉴바 추가 부분-->

<script>
	$(document).on('click', '#logout', function(e) {

		e.preventDefault();
		location.href = "${pageContext.request.contextPath}/board/logout.do";

	});
	
	
</script>


<nav class="navbar navbar-expand-sm navbar-dark bg-dark">

	<a class="navbar-brand" href="#">공무원 인사관리 시스템</a>

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarsExample03" aria-controls="navbarsExample03"
		aria-expanded="false" aria-label="Toggle navigation">

		<span class="navbar-toggler-icon"></span>

	</button>

	<div class="collapse navbar-collapse" id="navbarsExample03">

		<ul class="navbar-nav mr-auto">

			<li class="nav-item active"><a class="nav-link"
				href="${pageContext.request.contextPath}/Profile/MyProfile">본인 인사정보 조회
				 <span class="sr-only">(current)</span>
			</a></li>

			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/board/ShowBoardList">자유게시판</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/board/userList">직원 조회</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/Profile/EditMyProfile">개인 정보 수정하기</a></li>
		</ul>
	</div>

	<ul class="navbar-nav mr-auto">
		<li style="color: #ffffff;"><c:out value="${DBDATA.name}" /> 님
			반갑습니다&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		<li>
			<button class="btn btn-sm btn-primary" name="logout" id="logout">로그아웃</button>
		</li>
	</ul>

</nav>
