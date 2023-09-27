<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>To do 수정하기</h2>
	<form action="/memo/update" method="post">
		제목<input type="text" name="updateTitle" value="${todo.title}">
		메모<input type="text" name="updateContent" value="${todo.content}">
		<button onclick="showAlert()">수정하기</button>
	</form>
	
	<script>
        function showAlert() {
            window.alert("수정되었습니다.");
        }
	</script>
</body>
</html>