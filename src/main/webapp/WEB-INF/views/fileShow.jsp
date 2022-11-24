<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호스트 정보 확인페이지</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/style.css"> 


</head>
<body>



<%-- nav --%>

<%-- nav include   22.11.14 호식 수정 
				   22.11.15 호식 수정 - 디테일 추가 
--%>
<%@ include file = "hnav1.jsp" %>


 
 <main class="form-signin w-50 m-auto">
	<div align="center">
 

 
	<div class="box container mymcontainer">
	<div style="margin-bottom: 20px; font-weight: 500; font-size: 25px;">호스트 사진확인</div>

	<form action="hostMain" method="post" enctype="multipart/form-data">
		
		<table border="0">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="hId" size="20" value="<%=session.getAttribute("HID")%>"></td>
			</tr>
			<tr>
				<td>소개</td>
				<td><textarea name="hSummary" rows="10" cols="50">${fileView.hSummary}</textarea></td>
			</tr>
			<tr>
				<td>사진</td>
				<td><img src="./images/${fileView.hImage}" style="width:200px; height:400px;"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="호스트 회원가입" class="btn btn-primary" style="WIDTH: 210pt; HEIGHT: 40pt"></td>
			</tr>
		</table>
	</form>
	</div>
</div>
</main>
</body>
</html>