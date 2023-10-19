<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>
  
  <div id="detail">
    <h1>공지 상세화면</h1>
    <h3>공지번호 : ${notice.noticeNo}</h3>
    <h3>구분 : ${notice.gubun == 1 ? '긴급' : '일반'}</h3>
    <h3>제목 : ${notice.title}</h3>
    <h3>내용 : ${notice.content}</h3>
    <div>
      <button type="button" id="btn_edit">편집하기</button>
    </div>
  </div>
  
  <div id="edit">
    <div><h1>편집하기</h1></div>
    <form method="post" action="${contextPath}/notice/modify.do">
      <select name="gubun" id="gubun">
        <option value="2">일반</option>
        <option value="1">긴급</option>
      </select>
      <input type="text" name="title" id="title">
      <input type="text" name="content" id="content">
      <input type="hidden" name="noticeNo" id="noticeNo">
      <button>편집완료</button>
    </form>
    <div>
      <button type="button" id="btn_back">뒤로가기</button>
    </div>
    <script>
      $('#gubun').val('${notice.gubun}');
      $('#title').val('${notice.title}');
      $('#content').val('${notice.content}');
      $('#noticeNo').val('${notice.noticeNo}');
    </script>
  </div>
  <script>
    
    // 초기 화면
    $('#detail').show();
    $('#edit').hide();
    
    // 편집하러가기 클릭
    $('#btn_edit').click(function(){
    	$('#detail').hide();
      $('#edit').show();
    })
    
    // 뒤로가기 클릭
    $('#btn_back').click(function(){
      $('#detail').show();
      $('#edit').hide();
    })
    
    var modifyResult = '${modifyResult}';
    if(modifyResult !== ''){
    	if(modifyResult === '1'){
    		alert('공지사항이 수정되었습니다.');
    	} else {
    		alert('공지사항 수정을 실패했습니다.');
    	}
    }
    
  </script>

</body>
</html>