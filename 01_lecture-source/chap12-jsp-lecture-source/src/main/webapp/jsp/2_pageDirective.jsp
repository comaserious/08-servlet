<%--페이지 임포트 또한 page 지시자를 통해서 import를 수행한다--%>
<%@ page import="java.util.Date" errorPage="errorpage.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Date date = new Date();
        System.out.println("date = " + date);
        String st = null;
        char ch = st.charAt(0); // nullPointException 고의로 발생


    %>
</body>
</html>
