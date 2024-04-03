
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String menuName = request.getAttribute("menuName").toString();
        int count = Integer.parseInt(request.getAttribute("count").toString());
        int orderPrice = Integer.parseInt(request.getAttribute("orderPrice").toString());
    %>
    <h3>주문하신 음식 : <%= menuName%></h3>
    <h3>주문하신 음식의 수량 : <%= count%></h3>
    <h3>결제하실 금액 : <%= orderPrice%></h3>

</body>
</html>
