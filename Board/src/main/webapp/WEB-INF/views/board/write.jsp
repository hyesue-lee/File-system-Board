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
<title>게시물 작성하기</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />

<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">

	
	$(document).ready(function(){
		console.log('브라우저 디버깅 수동 로그');
		
		var msg = "${msg}";
		if(msg != "") alert(msg);
		
	});
	
	//jQuery event(click) 처리 
	$(document).ready(function(){
		$('#btnWrite').on('click', function(){ //완료클릭 >글쓰기 
		var frm = document.writeForm;

			frm.action = "<c:url value='/board/write.do'/>";
			frm.submit();
			
		});
	});
	
</script>




</head>
<body>


	
		<div class="center">
		<h1>글쓰기</h1>
		</div>


					<form name="writeForm" id="writeForm" method="post">
					
							<!-- board write table -->
							<table border="1">
								<tbody>
									<tr>
										<th>제목</th>
										<td class="left">
										<input type="text" name="title" title="제목 입력박스" style="width:80%"/>
										</td>
									</tr>
									<tr>
										<th>내용</th>
										<td lass="left">											
										<textarea rows="20" cols="100" name="content" ></textarea>									
										</td>
									</tr>
									
						
								</tbody>
							</table><!-- //board write table -->

							<!-- button -->
							<div class="center">
							<input type="button" value="작성취소" title="작성취소" onclick="javascript:window.history.back();"/> 
																							<%--뒤로가기  --%>
							<input type="button" value="완료" title="완료" id="btnWrite"/>
							</div>
							<!-- //bottom button -->

					
					</form>


</body>
</html>