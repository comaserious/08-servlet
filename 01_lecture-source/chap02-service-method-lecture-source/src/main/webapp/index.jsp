<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
    <h1 style="text-align: center">service() 메소드의 역할</h1>
    <h3>GET 방식의 요청</h3>
    <h4>a 태그의 href 속성값 변경</h4>
    <a href="request-service">서비스 메소드 요청하기</a>
    <h4>form  태그의 method 속성 get 으로 설정하기</h4>
    <form action="request-service" method="get">
        <input type="submit" value="get방식 전송">
    </form>

    <h3>POST 방식의 요청</h3>
    <h4>form 태그의 method 속성을 post 로 설정을 하면된다</h4>
    <form action="request-service" method="post">
        <input type="submit" value="POST 방식 요청 전송">
    </form>
</body>
</html>