<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery test</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function insert(){
		var value = $('.text1').val();
		$('.text2').val(value);
	}
</script>
</head>
<body>
	<input type="text" class="text1">
	<input type="button" value="입력" onClick="insert()"/><br>
	결과: <input type="text" class="text2" disabled>
</body>
</html>