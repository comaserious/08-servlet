<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Date today = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시 mm분  ss초");

        String output = sdf.format(today);
    %>

    <h3><%= output %></h3>
</body>
</html>


<%--사실 body 안에 있는 코드만 구현해도 상관없다 왜냐하면 include를 사용하는 곳에서 이미
 html 부터 body 까지 구현했기 때문이다--%>