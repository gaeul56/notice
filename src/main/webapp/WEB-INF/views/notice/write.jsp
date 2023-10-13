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
<script>
$(function(){
    fnListContact();

  })

function fnListContact(){
	$('#btn_list').click(function(){
	  location.href = '${contextPath}/notice/list.do';
	})
  }
</script>
<body>

  <div>
    <h2>공지 작성하기</h2>
    <form method="post" action="${contextPath}/notice/add.do">
      <div>
        <label for="gubun">구분</label>
		<select>
			<option>일반</option>
			<option>긴급</option>
		</select>
      </div>
      <div>
	        <label for="title">제목</label>
	        <input type="text" id="title" name="title">
      </div>
     	 <label for="content">내용</label>
	      <div>
		  <textarea name="content" cols="40" rows="8"></textarea>
	      </div>
      <div>
        <button type="submit">작성등록</button>
		<button type="button" id="btn_list">목록</button>
      </div>
    </form>
  </div>

</body>
</html>
