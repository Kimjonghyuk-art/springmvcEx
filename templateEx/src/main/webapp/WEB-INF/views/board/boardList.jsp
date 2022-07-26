<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="//cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css"
	rel="stylesheet" />
<script src="//cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
</head>

<script>
	$(function() {
		/* 	$('#myTable').DataTable(); */
		
		//$('[name="type"]').val('${cri.type}')
		
		function goPage(num) {
			/* $('#type').val('${cri.type}').prop("selected", true); */
			searchForm.pageNum.value = num;
			searchForm.submit();
			/* location.href="boardList?pageNum="+num */	
		}
		
		//수정, 삭제 메시지 출력
		var result1 = '${result1}';
		var result2 = '${param.result2}'; //파라미터로 날아간 값 읽기위해 param. 사용
		
		if(result1 != '') {
			const myModal = new bootstrap.Modal('#modalid',{});
			const modal = document.getElementById("modalid");
			$('#msg').html(result1);
				myModal.show(myModal);
			
		}
		
		var pagination = document.querySelector(".pagination");
		  pagination.onclick = function() {
		    event.preventDefault(); // 고유이벤트 속성 중지
		    if(event.target.tagName != 'A') return;

		   // console.log(document.pageForm.pagenum.value);
		    console.log(event.target.dataset.pagenum);
		    // 사용자가 클릭한 페이지 번호를 form에 넣고 서브밋을 보냅니다.
		   console.log(document.getElementById("pageNum").value)
		    pageForm.pageNum.value = event.target.dataset.pagenum;
		    document.pageForm.submit(); // 서브밋
		  }
		
		

	})
</script>

<body>
	<h3>게시판 리스트</h3>
	${cri}	
	<div class="card">
  <div class="card-header">
  <div class='row'>
		<div class="col-lg-12">
			<form name="searchForm">
				<select name="type">
					<option value="title" ${pageMaker.cri.type eq 'title' ? 'selected' : ''}>제목</option>
					<option value="content" ${pageMaker.cri.type eq 'content' ? 'selected' : ''}>내용</option>
					<option value="writer" ${pageMaker.cri.type eq 'writer' ? 'selected' : ''}>작성자</option>
				</select>
				<input type='text' name='keyword' value='${pageMaker.cri.keyword}' />
				<input type='hidden' name='pageNum' value='1'>
				<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
				<button class='btn btn-default'>Search</button>
			</form>
		</div>
	</div>
  
   
  </div>
  <div class="card-body">

	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>게시물 번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일시</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="b" items="${boardList}">
				<tr onclick="location.href='get?bno=${b.bno}'">
					<td>${b.bno}</td>
					<td>${b.title}</td>
					<td>${b.writer}</td>
					<td><fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<form name="pageForm">
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<c:if test="${pageMaker.prev}">
				<li class="page-item">
				<a class="page-link" href="#" data-pagenum="${pageMaker.startPage-1}">Previous</a>
				</li>
			</c:if>
			
			<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
				<li class="page-item ${pageMaker.cri.pageNum == num ? 'active':''}">
				<a class="page-link" href="#" data-pagenum='${num}'>${num}</a>
				</li>
			</c:forEach>
		
			<c:if test="${pageMaker.next}">
				<li class="page-item">
				<a class="page-link" href="#" data-pagenum="${pageMaker.endPage+1}">Next</a></li>
			</c:if>
		</ul>
	</nav>
	
	
   <input type="hidden" name="type" value="${pageMaker.cri.type}">
   <input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
	<input type="hidden" name="pageNum" id="pageNum" value="${pageMaker.cri.pageNum}">
  <input type="hidden" name="amount" value="${pageMaker.cri.amount}">

	<div id="btnContainer">
		<button type="button" onclick="location.href='boardInsert'">게시물
			등록</button>
	</div>
	</form>
</div>

</div>



<!-- Modal -->
<div class="modal fade" id="modalid" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div id="msg"></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Understood</button>
      </div>
    </div>
  </div>
</div>

</body>
</html>