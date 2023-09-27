<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>    
</head>
<body>
	<h2>To do 등록하기</h2>
	<form action="/memo/insert" method="post">
		제목<input type="text" name="inputTitle">
		메모<input type="text" name="inputContent">
		<button onclick="showAlert()">등록하기</button>
	</form>
	
	<script>
        function showAlert() {
            window.alert("등록되었습니다.");
        }
	</script>
</body>
</html>