
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<!DOCTYPE html>

<html>

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


<script>
	$(document).ready(function() {

		$("#reg_id").prop('readonly', true);
		$("#reg_id").val('<c:out value="${DBDATA.name}"/>');
		$("#uid").prop('readonly', true);
		$('#uid').val('${DBDATA.uid}');

	});

	$(document).on('click', '#btnSave', function(e) {

		e.preventDefault();
		$("#form").submit();
	});

	$(document)
			.on(
					'click',
					'#btnList',
					function(e) {

						e.preventDefault();

						location.href = "${pageContext.request.contextPath}/board/ShowBoardList";

					});
</script>

</head>

<body>

	<article>

		<div class="container" role="main">

			<h2>글 쓰기</h2>

			<form name="form" id="form" role="form" method="post"
				action="${pageContext.request.contextPath}/board/writeBoard">
				
				
				<input type="hidden"
						class="form-control" name="uid" id="uid">
						
				<input type="hidden"
						class="form-control"  name="reg_id" id="reg_id">
				
				<div class="mb-3">


				</div>

				<div class="mb-3">

					<label for="title">제목</label> <input type="text"
						class="form-control" name="title" id="title"
						placeholder="제목을 입력해 주세요">

				</div>



				<div class="mb-3">

					<label for="reg_id">작성자</label> 
					<div>
								<c:out value="${DBDATA.name}"/>
					</div>

				</div>



				<div class="mb-3">

					<label for="content">내용</label>
					<textarea class="form-control" rows="5" name="content" id="content"
						placeholder="내용을 입력해 주세요"></textarea>

				</div>



				<div class="mb-3">

					<label for="tag">TAG</label> <input type="text"
						class="form-control" name="tag" id="tag" placeholder="태그를 입력해 주세요">

				</div>



			</form>

			<div>

				<button type="button" class="btn btn-sm btn-primary" id="btnSave">작성</button>

				<button type="button" class="btn btn-sm btn-primary" id="btnList">취소</button>

			</div>

		</div>

	</article>

</body>

</html>

