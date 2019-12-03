<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<script>
//이전 버튼 이벤트

<c:if test="${not empty msg}">
alert("${msg}");
</c:if>

	

	function fn_RestPassWord(identifier){
		var url = "${pageContext.request.contextPath}/id/RestPassWord";
		url = url + "?identifier="+encodeURIComponent(identifier);
		window.open(url, "수정하기", "width=500, height=400, toolbar=no, menubar=no, scrollbars=no, resizable=no" );  
	}


</script>

<article>
	<div class="container">
		<h2>직원 비밀번호 초기화</h2>
		<div class="table-responsive">
			<table class="table table-striped table-sm">
				<colgroup>
					<col style="width: 15%;" />
					<col style="width: 15%;" />
				</colgroup>
				<thead>
					<tr>
						<th>공무원증 번호</th>
						<th>이름</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty IDList}">
							<tr>
								<td colspan="6" align="center">데이터가 없습니다.</td>
							</tr>
						</c:when>
						<c:when test="${!empty IDList}">
							<c:forEach var="list" items="${IDList}">
								<tr>
									<td><c:out value="${list.ID_CARD_SERIAL}" /></td>
									<td><a href="#" onClick='fn_RestPassWord("<c:out value="${list.identifier}"/>")'> <c:out value="${list.name}" /> </a></td>
								</tr>
							</c:forEach>
						</c:when>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
</article>
