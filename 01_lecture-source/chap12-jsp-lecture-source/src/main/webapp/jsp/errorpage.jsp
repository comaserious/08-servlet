
<%--자신이 에러페이지 인지 아닌지 알려줘야한다
지시자 태그내에 isErrorPage를 true 로 설정해줘야 exception을 사용할수 있다--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String exceptionType = exception.getClass().getName();
        String exceptionMessage = exception.getMessage();
    %>
    <h1><%=exceptionType%></h1>
    <hr>
    <h1><%=exceptionMessage%></h1>
</body>
</html>
