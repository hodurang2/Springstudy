<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  #paging a {
    margin: 10px;
  }
</style>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

</head>
<body>
  
  <h1>상세보기</h1> // 상세보기는 키값을 전달한다
  <form id="frm_detail" method="post">
    <div>게시글 번호 : ${bbs.bbsNo}</div>
    <div>작성자 : ${bbs.editor}</div>
    <div>제목 : <input type="text" name="title" value ="${bbs.title}" required ></div>
    <div>내용 : <input type="text" name="contents" value="${bbs.contents}" ></div>
    <div>작성일 : ${bbs.createdAt}</div>
    <div>수정일 : ${bbs.modifiedAt == null ? '없음' : bbs.modifiedAt}</div>
    <input type="hidden" name="bbsNo" value="${bbs.bbsNo}">
    <button type="button" id="btn_modify">수정</button>
    <button type="button" id="btn_delete">삭제</button>
  </form>
  
  <script>
  
    var frmDetail = $('#frm_detail');
    var frmDelete = $('#frm_delete');
    const modifyResult = '${modifyResult}';
    const removeResult = '${removeResult}';
  
    // 수정
    $('#btn_modify').click(() => {
    	frmDetail.attr('action', '${contextPath}/modify.do');
    	frmDetail.submit();
    })
  
    // 삭제
    $('#btn_delete').click(() => {
    	if(confirm('삭제할까요?')){
      	frmDetail.attr('action', '${contextPath}/delete.do');
      	frmDetail.submit();
    	}
    })
    
    if(modifyResult !== ''){
      if(modifyResult === '1'){
        alert('수정 성공');
      } else {
        alert('수정 실패');
      }
    }
    
    if(removeResult !== ''){
      if(removeResult === '1'){
        alert('삭제 성공');
      } else {
        alert('삭제 실패');
      }
    }
    
  </script>
</body>
</html>
