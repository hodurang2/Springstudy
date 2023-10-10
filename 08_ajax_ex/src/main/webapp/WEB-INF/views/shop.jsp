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
<script>
  $(function(){
	  fnMemberInfo();
  })
  
  function fnMemberInfo(){
	  $('#btn_bmi').click(function(){
		  $.ajax({
			  type: 'get',
			  url: '${contextPath}/member/health.check',
			  data: 'memberNo=' + $('#memberNo').val(),
			  dataType: 'json',
			  success: function(resData) {
				  fnBmi(resData);
				  fnProfile();
			  }
		  })
	  })
  }
  function fnBmi(resData){
    $('#bmi_info').empty();
    $('#bmi_info').append('<ul><li>' + resData.name + '</li><li>' + resData.bmi + '</li><li>' + resData.state + '</li></ul>');
  }
  function fnProfile(){
	  $('#profile').empty();
	  $('#profile').append('<img src="${contextPath}/member/profile.display?memberNo=' + $('#memberNo').val() + '" width="192px">');
  }
  
</script>
</head>
<body>

  <div>
    <form action="">
      <div>
        검색결과건수
        <select id="prod">
          <option value="10">10</option>
          <option value="5">5</option>
          <option value="3">3</option>
          <option value="1">1</option>
        </select>
      </div>
      <div>
        <input type="radio" id="sortSimilar" name="sort">
        <label for="sortSimilar">유사도순</label>
        <input type="radio" id="sortDate" name="sort">
        <label for="sortDate">날짜순</label>
        <input type="radio" id="sortLprice" name="sort">
        <label for="sortLprice">낮은가격순순</label>
        <input type="radio" id="sortUprice" name="sort">
        <label for="sortUprice">높은가격순</label>
      </div>
      <div>
        <label for="search">검색어 입력</label>
        <input type="text" id="search" placeholder="검색어를 입력하세요">      
        <button type="button" id="btn_search">검색</button>
      </div>
    </form>
  </div>
  
  <hr>
  
  <div>
    <div id="profile"></div>
    <div id="bmi_info"></div>
  </div>
  

</body>
</html>