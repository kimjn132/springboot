<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script type="text/javascript">
    
    function confirmLogout() {
        if( confirm("정말 로그아웃 하시겠습니까?") ) {
            location.href = "<c:url value ='cLogout'/>";
        }
    }
    
</script>
</head>
<body>

<div class="container">
   <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
     <a href="hostMain" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
		<svg class="mysvg" xmlns="http://www.w3.org/2000/svg" width="28" height="28" fill="currentColor" class="bi bi-house-heart" viewBox="0 0 16 16">
			<path d="M8 6.982C9.664 5.309 13.825 8.236 8 12 2.175 8.236 6.336 5.309 8 6.982Z"/>
			<path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.707L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.646a.5.5 0 0 0 .708-.707L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5ZM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5 5 5Z"/>
		</svg>
       <span class="mytitle"><b>Hoping Host</b></span>
     </a>
     
     <ul class="nav nav-pills">
     	<li class="nav-item" style="font-size: 14px;">
	     			<% if (session.getAttribute("HID") != null) { %>
	     		<a href="homeView" class="link-dark nav-link"> Change Client Mode</a>
	     			  <% } %>	
	     	</li>
     	<li class="nav-item">
		<svg class="dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" xmlns="http://www.w3.org/2000/svg" width="28" height="28" fill="currentColor" class="bi bi-person-lines-fill" viewBox="0 0 16 16">
		<path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm-5 6s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zM11 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5zm.5 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1h-4zm2 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2zm0 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2z"/>
		
		<ul class="dropdown-menu dropdown-menu-end">
			<li><a class="dropdown-item" href="myPage.do">내 정보</a></li>
			<li><a class="dropdown-item" href="bookList.do">예약목록</a></li>
			<li><a class="dropdown-item" href="askList.do">문의목록</a></li>
            <li><a class="dropdown-item" href="#">수입 및 예약건 통계</a></li>
            <li><a class="dropdown-item" href="host_review_list.do">후기관리</a></li>
            <li><a class="dropdown-item" href="campingAdd.do">캠핑장 추가</a></li>
            <li><a class="dropdown-item" href="javascript:void(0);" onclick="confirmLogout();">로그아웃</a></li>
		</ul>
		
		</svg>
		</li>
     </ul>
   </header>
 </div>

</body>
</html>