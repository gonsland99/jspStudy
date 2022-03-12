<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script type="text/javascript">
      function fn_process(){
       $.ajax({
         type:"get",
         dataType:"text",
         async:false,  
//          url:"http://localhost:8081/ch16/ajaxTest1",
         url:"../ajaxTest1",
         data: {param:"Hello,jquery"},
         
         success:function (data,textStatus){
            $('#message').append(data);
         },
         error:function(data,textStatus){
            alert("에러가 발생했습니다.");ㅣ
         },
         complete:function(data,textStatus){
            alert("작업을완료 했습니다");
         }
      });	
   }		
</script>
</head>
<body>
<input type="button" value="전송하기" onClick="fn_process()" /><br><br>
<div id="message"></div>
</body>
</html>