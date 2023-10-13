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
    fnModifyResult();
    fnDeleteContact();
    fnListContact();
  })
  
  function fnModifyResult(){
    var modifyResult = '${modifyResult}';
    if(modifyResult !== ''){
      if(modifyResult === '1'){
        alert('공지사항이 수정되었습니다.');
      } else {
        alert('공지사항 수정이 실패했습니다.');
      }
    }
  }
  
  function fnDeleteContact(){
	$('#btn_delete').click(function(){
	  if(confirm('공지사항을 삭제할까요?')){
	    $('#frm_detail').attr('action', '${contextPath}/notice/delete.do');
	    $('#frm_detail').submit();
	  }
	})
  }

  function fnListContact(){
	$('#btn_list').click(function(){
	  location.href = '${contextPath}/notice/list.do';
	})
  }
  
</script>
</head>
<body>
<h1>공지사항 편집하</h1>
  <div>
    <form id="frm_detail" method="post" action="${contextPath}/notice/modify.do">
      <div>
        <label for="gubun" >구분</label>
        <input type="text" id="gubun" name="gubun"  value="${notice.gubun}">
      </div>
      <div>
        <label for="title">제목</label>
        <input type="text" id="title" name="title" value="${notice.title}">
      </div>
      <div>
        <label for="content">내용</label>
        <input type="text" id="content" name="content" value="${notice.content}">
      </div>
      <hr>
      <div>
        <input type="hidden" name="notice_no" value="${notice.notice_no}">
        <button type="submit">편집</button>
        <button type="button" id="btn_delete">삭제</button>
        <button type="button" id="btn_list">목록</button>
      </div>
    </form>
  </div>

</body>
</html>
