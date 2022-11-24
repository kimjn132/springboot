<%@page import="com.springlec.base.model.regcampDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.springlec.base.dao.ClientDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Hoping 메인페이지</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/style.css">
<style type="text/css">
@import
	url('https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800')
	;

@import
	url('https://fonts.googleapis.com/css2?family=Ubuntu&display=swap');

#redheart {
	position: absolute;
	top: 20px;
	left: 15px;
	width: 50px;
	height: 50px;
	visibility: hidden;
}

#btn2 {
	position: absolute;
	top: 25px;
	left: 15px;
	background-color: rgba(0, 0, 0, 0);
	border-color: rgba(0, 0, 0, 0);
	color: red;
	font-weight: bolder;
}

#if {
	width: 0px;
	height: 0px;
	border: 0px;
}
</style>

</head>
<body>
	<!-- Header -->
	<%@ include file="Nav.jsp"%>
	<!-- Header End -->
	<%-- 카드 --%>
	<div class="box container mymcontainer">
		<div class="row">

			<c:forEach items="${HomeList}" var="dto">
				<div class="col-md">
					<div class="card mycard">
						<a href="regcampDetail?regSeq=${dto.regSeq}"> <img
							src="./images/${dto.regImage1}" class="card-img-top myimage" alt="...">
						</a>
						<div class="card-body mycbody">
							<p class="card-text">${dto.regDetailaddress}</p>
							<h5 class="card-title myctitle">${dto.regName}</h5>
							<p class="card-text myctext">${dto.regTel}</p>
						</div>

					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<!-- Foot -->
	<%@ include file="Foot.jsp"%>
	<!-- Foot End -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>