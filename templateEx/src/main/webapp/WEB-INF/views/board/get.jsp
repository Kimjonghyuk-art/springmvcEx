<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 상세보기 -->
	<h3>게시글 상세보기</h3>

	<table>
		<thead>
			<tr>
				<th>게시물 번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일시</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<td>${board.bno}</td>
				<td>${board.title}</td>
				<td>${board.content}</td>
				<td>${board.writer}</td>
				<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/></td>
			</tr>
		</tbody>
	</table>
	
	<button type="button" onclick="location.href='boardUpdate?bno=${board.bno}'">수정</button>
	<button type="button" onclick="location.href='boardDelete?bno=${board.bno}'">삭제</button>
	<!-- 댓글 -->
	
	<h4>댓글</h4>
	<form>
		<input type="hidden" name="bno" id="bno" value="${board.bno}">

		<div>
			<label for="replyer">작성자</label> <input name="replyer" id="replyer">
		</div>
		<div>
			<label for="reply">내용</label> <input name="reply" id="reply">
		</div>

		<button type="button" id="btnInsert">등록</button>

	</form>

	<h3>댓글 리스트</h3>

	<div id="replyList">
		<!-- 	<div data-rno="1">
		<span class="reWriter">댓글작성자</span>
		<span class="reContent">내용</span>
		<span class="reDate">작성일시</span>
		<span class="btnReUpd"><button>수정</button></span>
		<span class="btnReDel"><button>삭제</button></span>

	</div> -->
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
	<script>
	$(function() {
		replySelect();
		insertReply();
		deleteReply();
		updateReply();
		
		function makedata(obj) {
			let node = `<div data-rno="\${obj.rno}">
				<span class="reWriter">\${obj.replyer}</span>
				<span class="reContent">\${obj.reply}</span>
				<span class="reDate">\${obj.replyDate}</span>
				<span><button type="button" class="btnReUpd">수정</button></span>
				<span><button type="button" class="btnReDel">삭제</button></span>
			</div>`;
			$("#replyList").append(node);
		}
		
		function replySelect() {
		let url = "/mvc/getReplyList/${board.bno}";	
			$.ajax(url).done(function(objs){
				for(obj of objs){
					makedata(obj);
				}
			})
		}
		
		function insertReply() {
			
			$("#btnInsert").on("click", function() {
				let data = {};
				data.bno = $("#bno").val();
				data.replyer = $("#replyer").val();
				data.reply = $("#reply").val();
				console.log(data);
				let url = "/mvc/reply";
				console.log($("#reply").val());
			 	$.ajax({
					url : url,
					method : "POST",
					data : {bno : $("#bno").val(),
						replyer : $("#replyer").val(),
						reply : $("#reply").val()}
					
				}).then(function(result) {
					makedata(result);
					location.reload();
				})   
			})
		}
		
		function deleteReply() {
			
			$("#replyList").on("click",".btnReDel",function() {
				  
				  let rno= $(this).parent().parent().data("rno");
				let divtag = $(this).parent().parent();	
				
				 $.ajax({
					url: "/mvc/reply/" + rno,
					method : "delete"
				}).then (function(result) {
					console.log(result);
					divtag.remove();
				}) 
				
				
			});	
		}
		
		function updateReply() {
			
			$("#replyList").on("click",".btnReUpd", function () {
				
				let inputTag = $("<input placeholder='내용입력'>");
				let btnTag = $("<button type='button'>수정하기</button>");
				let rno= $(this).parent().parent().data("rno");
				let divTag = $(this).parent().parent();
				divTag.append(inputTag,btnTag);
				
				btnTag.on("click",function () {
					
					$.ajax({
						url : "/mvc/reply",
						method : "put",
						data : JSON.stringify({rno : rno, reply : $(inputTag).val() }),
						contentType: "application/json; charset=utf-8",
					}).then(function(result) {
						if(result != null) {
							location.reload();
						}
					})
					
				})
				
				
				
			})
			
		}
		
	})
</script>

</body>
</html>