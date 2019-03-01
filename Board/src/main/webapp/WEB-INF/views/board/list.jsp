<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- tag library 선언 : c tag --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style type="text/css">
table{
border:1px solid;
width:80%;
height:100px;
margin: auto;
text-align:center;
}
th,td{
padding: 20px;
}
.center{
text-align:center;
}
input[type=button]{
font-size: 15px; 
padding: 20 20 20 20px; 
}
</style>
<title>Board List</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

 
 
<script type ="text/javascript">

$(document).ready(function(){ //onload=init() 대신할수있는 펑션. 
	var msg = '${msg}'; // 
		if(msg != '') alert(msg);
	});
</script>

</head>
<body>

		<div class="center">
		<h1>게시판</h1>
		</div>


				<!-- board_area -->
				<div class="center">
					<form method="get">
						
		
							<!-- board list table -->
							<table border=1px>
								
								<colgroup>
									<col width=100px />
									<col width=500px />
								
								</colgroup>
								<thead>
									<tr>
										<th scope="col">번호</th>
										<th scope="col">제목</th>
				
									</tr>
								</thead>
								
								<tbody>
								
									<%-- items:컬렉션 반복 --%>
					<c:forEach items="${ list }" var="map" varStatus="status">
									
									
									<tr>
							
										<td>
										${status.count}
										
										</td>
									
										<td style="text-align:left;">
										
								
											<a href="<c:url value ='/board/read.do?title=${map}'/>">
											${map}</a>
										</td>
								
									</tr>
					</c:forEach>
								</tbody>
							</table>
							<!-- //board list table -->

						<br/>
						
									<!-- bottom button -->
							<div class="center">

									<a href="<c:url value ='/board/goToWrite.do'/>">
										<input type="button" value="글쓰기" title="글쓰기"/>
									</a>

							</div>
							<!-- //bottom button -->
					</form>
				</div>
				<!-- //board_area -->


</body>
</html>