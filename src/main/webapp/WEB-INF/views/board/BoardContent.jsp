
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>글 내용</title>

<script>


//댓글를 띄우기 위해 JSON 가져오기
function showReplyList(){
		var url = "${pageContext.request.contextPath}/board/ShowReplyList";
		var paramData = {"bid" : "${boardContent.bid}"};
		$.ajax({
            type: 'POST',
            url: url,
            data: paramData,
            dataType: 'json',
            success: function(result) {
               	var htmls = "";
               	
            htmls += '<div>';
            htmls += '<h3>';
            htmls += ' 리플  : ' + result.length;
            htmls += '</h3>';
            htmls += '</div>';
            htmls += '</br>';
            
			if(result.length < 1)
			{
				htmls += "<h2>등록된 댓글이 없습니다</h2>";

			} else {
                  
	                    $(result).each(function(){

	                     htmls += '<div class="media text-muted pt-3" id="rid' + this.rid + '">';

	                     htmls += '<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:32x32">';

	                     htmls += '<title>Placeholder</title>';

	                     htmls += '<rect width="100%" height="100%" fill="#007bff"></rect>';

	                     htmls += '<text x="50%" fill="#007bff" dy=".3em">32x32</text>';

	                     htmls += '</svg>';

	                     htmls += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">';

	                     htmls += '<span class="d-block">';

	                     htmls += '<strong class="text-gray-dark">' + this.reg_id + '</strong>';

	                     htmls += '<span style="padding-left: 7px; font-size: 9pt">';

	                     //htmls += '<a href="javascript:void(0)" onclick="fn_editReply(' + this.rid + ', \'' + this.reg_id + '\', \'' + this.content + '\' )" style="padding-right:5px">수정</a>';

	                     htmls += '<a href="javascript:void(0)" onclick="fn_deleteReply(' + this.rid + ')" >삭제</a>';

	                     htmls += '</span>';

	                     htmls += '</span>';

	                     htmls += this.content;

	                     htmls += '</p>';

	                     htmls += '</div>';
	                     
	                     
	                });	//each end
			}
				$("#replyList").html(htmls);
            }	   // Ajax success end
		});	// Ajax end
	}
	
//댓글 저장 버튼 클릭 이벤트
$(document).on('click', '#btnReplySave', function(){
	
	var url = "${pageContext.request.contextPath}/board/WriteReply";
	var replyContent = $('#content').val();
	var replyReg_id = $('#reg_id').val();

	var paramData = JSON.stringify({
			"content": replyContent
			, "reg_id": replyReg_id
			, "bid":'${boardContent.bid}'
	});
	var headers = {"Content-Type" : "application/json"
			, "X-HTTP-Method-Override" : "POST"};
	$.ajax({

		url : url
		, headers : headers
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result)
		{
			showReplyList();
			$('#content').val('');
			$('#reg_id').val('');
		}

		, error: function(error){
			console.log("에러 : " + error);
		}
	});
});

//댓글 삭제
function fn_deleteReply(rid){
	
	var url = "${pageContext.request.contextPath}/board/DeleteReply";
	var paramData = {"rid": rid};
	
	$.ajax({
		url: url
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result)
		{
			if(result.length < 1)
			{
				htmls.push("등록된 댓글이 없습니다.");
			}
			
			showReplyList();

		}
		, error: function(error){
			console.log("에러 : " + error);
		}
	});
}

//댓글 표시 호출 함수
$(document).ready(function()
{
	showReplyList();
});


	//목록으로
	$(document).on('click', '#btnList', function(){
		location.href = "${pageContext.request.contextPath}/board/ShowBoardList";
	});
	
	//글 수정 버튼 클릭 이벤트
	$(document).on('click', '#btnUpdate', function(){

		var url = "${pageContext.request.contextPath}/board/EditForm";
		url = url + "?bid="+ ${boardContent.bid};
		url = url + "&uid="+encodeURIComponent('${DBDATA.uid}');
		url = url + "&mode=edit";
		
		location.href = url;

	});

	//글 삭제 버튼 클릭 이벤트
	$(document).on('click', '#btnDelete', function()
	{
    	 var url = "${pageContext.request.contextPath}/board/deleteBoard";
   		 url = url + "?bid=" + ${boardContent.bid};
   		 url = url + "&uid="+encodeURIComponent('${DBDATA.uid}');
		location.href = url;

	});

</script>


</head>

<body>

	<article>

		<div class="container" role="main">

			<h2>글 내용</h2>

			
			<div class="bg-white rounded shadow-sm">
				<div class="board_title"> 제목 : ${boardContent.title}</div>
				<div class="board_info_box">
					<span class="board_author"> 작성자 : ${boardContent.reg_id} <br>
					</span><span class="board_date"> 작성 날짜 : ${boardContent.reg_dt}</span>
				</div>
				<br>
				<div class="board_content"> 글 내용<br> ${boardContent.content}</div>
				<br>
				<div class="board_tag">TAG : ${boardContent.tag}</div>

			</div>


			<div style="margin-top : 20px">

				<button type="button" class="btn btn-sm btn-primary" id="btnUpdate">수정</button>

				<button type="button" class="btn btn-sm btn-primary" id="btnDelete">삭제</button>

				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>

			</div>
		
			<!-- Reply List {s}-->

			<div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
				<div id="replyList"></div>

			</div> 
			
			<!-- Reply Form {s} -->

			<div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">

				<form:form name="form" id="form" role="form" modelAttribute="ReplyVO" method="post">
				<form:hidden path="bid" id="bid"/>

				<div class="row">

					<div class="col-sm-10">

						<form:textarea path="content" id="content" class="form-control" rows="3" placeholder="댓글을 입력해 주세요"></form:textarea>

					</div>

					<div class="col-sm-2">

						<form:input path="reg_id" class="form-control" id="reg_id" placeholder="댓글 작성자"></form:input>
						<button type="button" class="btn btn-sm btn-primary" id="btnReplySave" style="width: 100%; margin-top: 10px"> 댓글작성 </button>

					</div>

				</div>

				</form:form>

			</div>

			<!-- Reply Form {e} -->

		</div>

		

	</article>

</body>


</html>