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
<title>상세페이지</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){ //onload=init() 대신할수있는 펑션. 
		var msg = '${msg}'; // 문자열은 '' 해주어야함..
		if(msg != ''){ // 문자열이므로 null아님.
			alert(msg);
		}
		
		$('#btnDelete').on('click', function(){
			if(confirm("삭제하시겠습니까?")){
				var frm = document.readForm;
				frm.action = "<c:url value='/board/delete.do?title=${params.title}'/>";
				frm.submit(); // 마지막에 쏴줘야 !넘어감. 
			}
		});
	});

</script>
</head>

<body>



				
		<div class="center">
		<h1>게시글 조회</h1>
		</div>
		<form method="post" name ="readForm">
			
				<!-- board detail table -->
				<table border=1>

					<tbody>
					
						<tr>
							<th>제목</th>
							<td class="left" colspan="5">${ params.title }</td>
						</tr>
						
						<tr>
							<th>내용</th>
							<td style="width:90%; height:200px; vertical-align:top; padding:0 0 0 20px ">
								<div class="left">
								${ params.content }
								</div>
							</td>
						</tr>

						
					</tbody>
				</table>
				<!-- //board detail table -->
				
				<!-- button -->

				<div class="center">
						<a href="<c:url value ='/board/goToUpdate.do?title=${ params.title }'/>">
							 <input type="button" value="수정" title="수정" /> 
						</a>
						
						<input type="button" value="삭제" title="삭제" id="btnDelete"/> 

						<a href="<c:url value ='/board/list.do'/>">
							<input type="button" value="목록" title="목록"/>
						</a>
						
				</div>

				<!-- //bottom button -->

		</form>



</body>
</html>