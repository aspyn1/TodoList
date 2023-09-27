<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resources/css/main-style.css">

<!-- fontaswesom 아이콘 사용할 수 있는 스크립트 연결-->
<script src="https://kit.fontawesome.com/ac58eafae7.js"
	crossorigin="anonymous"></script>
</head>
<body>

	<main>
	
		<div class="left"></div>
		
		<div class="center">
			<c:choose>
				<c:when test="${empty sessionScope.loginMember}">
					<h2>투 두 리스트 로그인</h2>
						<form action="/login" method="POST" name="login-form" id="loginFrm">
							<fieldset class="id-pw-area">
								<section>
									아이디<input type="text" name="inputId">
									패스워드<input type="password" name="inputPw">
								</section>
								
								<section>
									<button>로그인</button>
								</section>
								
								<section class="signup-find-area">
								<a href="/signup">회원가입</a>
								</section>				
							</fieldset>
						</form>
				</c:when>
				
				<c:otherwise>
					<article class="login-area">
						<h2>${sessionScope.loginMember.memberNickname}의 투 두 리스트</h2>
						<c:choose>
							<c:when test="${empty sessionScope.tdList}">								
								<h3>해야할 일이 없습니다!</h3>
								<a href="/WEB-INF/views/insert.jsp">등록하기</a>
							</c:when>
							<c:otherwise>
								<c:forEach var="todo" items="${tdList}">
									<div class="todo-list">
										<span>${todo.todoTitle}</span>
										<span>(${todo.todoMemo})</span>
										<span>${todo.todoDate}</span>
										<span>
											<a href="/update">수정</a>
											<a href="/delete">삭제</a>
										</span>
									</div>
									<a href="/WEB-INF/views/insert.jsp">등록하기
										
									</a>
									<a href="/member/logout">로그아웃</a>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</article>
				</c:otherwise>
				
			</c:choose>
		</div>
		
		<div class="right"></div>
		
	</main>

</body>
</html>