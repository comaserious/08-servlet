
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1 style="text-align: center; color: red; ">Menu select</h1>
    <form action="/menu/order" method="post">
        <select name="menuName" id="menu">
            <option value="햄버거">1955햄버거</option>
            <option value="짜장면">짜장면</option>
            <option value="짬뽕">짬뽕</option>
            <option value="순대국">순대국</option>
        </select>
        <input type="number" min="0" max="100" step="1" name="count" placeholder="수량을 선택">
        <button type="submit">주문</button>
    </form>


</body>
</html>
