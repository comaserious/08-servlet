
<!--지시자 태그(page, include, taglib) 지시자 태그가 있다-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>JSP Simple States</h1>
    <%-- JSP에는 총 5가지의 태그가 존재한다
      1. 지시자 태그     <%@      %>
      2. 주석 태그
      3. 선언 태그       <%!      %>
      4. 스크립트릿 태그  <%       %>
      5. 표현 태그       <%=      %>
      --%>
    <!--html 주석-->
    <%--jsp 주석--%>

    <!--선언(declare) 태그-->
    <%--변수를 선언하는 태그이다--%>
    <%!
        private String name;
        private int age;
    %>
    <!--스크립트릿 태그-->
    <%--특정한 로직을 설정하는 태그이다 자바에서 사용한 소스코드를 그대로 사용할 수 있다--%>
    <%
        name = "leeee";
        age = 31;
        System.out.println("name = " + name);
        System.out.println("age = " + age);

        for(int i = 0 ; i <name.length();i++){
            System.out.println(name.charAt(i));
        }
    %>

    <!--표현(expression) 태그-->
    <%--만들어낸 값들을 실제 웹상에 표현하기 위한 태그이다--%>
    name : <%= name %>
    <br>
    age : <%= age %>

</body>
</html>
