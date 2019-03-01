<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- tag library 선언 : c tag --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<head>
<style type="text/css">
table{
border:1px solid;
height:100px;
margin: auto;
text-align:center;
}
th,td{
padding: 20px;
}
.center{
text-align:center;
margin-top:10px;
}
.left{
text-align:left;
}
input[type=button]{
font-size: 15px; 
padding: 20 20 20 20px; 
}

</style>
<title>게시글 수정</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />

<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	
	//jQuery event(click) 처리 
	$(document).ready(function(){
		
		
		$('#btnUpdate').on('click', function(){ // 
		
			if(confirm("수정하시겠습니까?")){								
			var frm = document.updateForm;

			frm.action = "<c:url value='/board/update.do'/>";
			frm.submit();
			}
		});
		
	});
	
</script>

</head>
<body>

				
		<div class="center">
		<h1>게시글 수정</h1>
		</div>

		<form name="updateForm" id="updateForm" method="post">
				<!--  table -->
				<table border=1>
					<tbody>
						<tr>
							<th>제목</th>
							<td class="left">
							<input type="hidden" name="title" value="${params.title}"/>
							<input type="text" name="titleNew" title="제목 입력박스" value="${params.title}" style="width:80%"/>
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td>											
							<textarea rows="20" cols="100" id="content" name="content">${params.content}</textarea>									
							</td>
						</tr>

					</tbody>
				</table>
	
				<!--  button -->
				<div class="center">
					<input type="button" value="취소" title="수정취소" onclick="javascript:window.history.back();"/> 															
					<input type="button" value="수정완료" title="수정완료" id="btnUpdate"/>
				</div>
		</form>
</body>
</html>




