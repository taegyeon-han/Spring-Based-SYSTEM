<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<script>
//이전 버튼 이벤트

<c:if test="${not empty msg}">
alert("${msg}");
</c:if>

function fn_prev(page, range, rangeSize) {
		var page = ((range - 2) * rangeSize) + 1;

		var range = range - 1;

	
		var url = "${pageContext.request.contextPath}/board/userList";

		url = url + "?page=" + page;

		url = url + "&range=" + range;

		location.href = url;

	}


  //페이지 번호 클릭

	function fn_pagination(page, range, rangeSize, searchType, keyword) {

		var url = "${pageContext.request.contextPath}/board/userList";

		url = url + "?page=" + page;

		url = url + "&range=" + range;


		location.href = url;	


	}


	//다음 버튼 이벤트

	function fn_next(page, range, rangeSize) {

		var page = parseInt((range * rangeSize)) + 1;

		var range = parseInt(range) + 1;

		
		var url = "${pageContext.request.contextPath}/board/userList";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		location.href = url;
	}
	
	$(document).on('click', '#btnSearch', function(e){

		e.preventDefault();
		var url = "${pageContext.request.contextPath}/board/userList";
		url = url + "?searchType=" + $('#searchType').val();
		url = url + "&keyword=" + encodeURIComponent($('#keyword').val());
		
		location.href = url;
		console.log(url);

	});	
	

	function fn_contentView(identifier){
		var url = "${pageContext.request.contextPath}/Profile/UserProfile";
		url = url + "?identifier="+encodeURIComponent(identifier);
		location.href = url;
	}
	


</script>

<article>
	<div class="container">
		<h2>직원 검색</h2>
		<div class="table-responsive">
			<table class="table table-striped table-sm">
				<colgroup>
					<col style="width: auto;" />
					<col style="width: auto;" />
					<col style="width: auto;" />
					<col style="width: auto;" />
					<col style="width: auto;" />
					<col style="width: auto;" />
					<col style="width: auto;" />
					<col style="width: auto;" />
					<col style="width: auto;" />
					<col style="width: auto;" />
					<col style="width: auto;" />
				</colgroup>
				<thead>
					<tr>
						<th>계급</th>
						<th>재직유무</th>
						<th>이름</th>
						<th>부서</th>
						<th>직책</th>
						<th>사무실 전화 번호</th>
						<th>개인연락처</th>
						<th>EMAIL</th>
						<th>임용일</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty userList}">
							<tr>
								<td colspan="6" align="center">데이터가 없습니다.</td>
							</tr>
						</c:when>
						<c:when test="${!empty userList}">
							<c:forEach var="list" items="${userList}">
								<tr>
									<td><c:out value="${list.LEVEL}" /></td>
									<td><c:out value="${list.STATUS}" /></td>
									<td><a href="#" onClick='fn_contentView("<c:out value="${list.identifier}"/>")'> <c:out value="${list.name}" /> </a></td>
									<td><c:out value="${list.DEPARTMENT}" /></td>
									<td><c:out value="${list.POSITION}" /></td>
									<td><c:out value="${list.TELEP_HONE}" /></td>
									<td><c:out value="${list.HAND_PHONE}" /></td>
									<td><c:out value="${list.EMAIL}" /></td>
									<td><c:out value="${list.WOR_KDATE}" /></td>
								</tr>
							</c:forEach>
						</c:when>
					</c:choose>
				</tbody>
			</table>
		</div>
		<!-- pagination{s} -->
		<div id="paginationBox">
			<ul class="pagination">
				<c:if test="${pagination.prev}">
					<li class="page-item"><a class="page-link" href="#"
						onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}', '${pagination.searchType}', '${pagination.keyword}')">Previous</a></li>
				</c:if>
				<c:forEach begin="${pagination.startPage}"
					end="${pagination.endPage}" var="idx">
					<li
						class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> "><a
						class="page-link" href="#"
						onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}', '${pagination.searchType}', '${pagination.keyword}' )">
							${idx} </a></li>
				</c:forEach>
				<c:if test="${pagination.next}">
					<li class="page-item"><a class="page-link" href="#"
						onClick="fn_next('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}', '${pagination.searchType}', '${pagination.keyword}')">Next</a></li>
				</c:if>
			</ul>
		</div>
		<!-- pagination{e} -->
		<!-- search{s} -->
		<div class="form-group row justify-content-center">
			<div style="padding-right: 10px">
				<select class="form-control form-control-sm" name="searchType"
					id="searchType"><option value="name"
						<c:if test="${pagination.searchType eq 'name'}">selected</c:if>>이름</option>
					<option value="DEPARTMENT"
						<c:if test="${pagination.searchType eq 'DEPARTMENT'}">selected</c:if>>부서</option></select>
			</div>
			<div style="padding-right: 10px">
				<input type="text" class="form-control form-control-sm"
					name="keyword" id="keyword" value="${pagination.keyword}">
			</div>
			<div>
				<button class="btn btn-sm btn-primary" name="btnSearch"
					id="btnSearch">검색</button>
			</div>
		</div>
		<!-- search{e} -->
	</div>
</article>
