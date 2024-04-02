package com.ohgiraffers.section01.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*필기.
        *  서블릿이 수행하는 역할은 크게 3가지로 나눈다
        *   1. 요청받기 - HttpMethod GET 과 POST 요청에 따라서 parameter로 전달받은 데이터를 꺼낸다
        *   2. 비즈니스 로직 처리 - ex) DB 접속과 CRUD 관련된 로직 작성(나중에 스프링을 배우면 더 집중해서 배울것이다)
        *   3. 응답하기 - 문자열로 동적인 웹(HTML 태그) 페이지를 만들고 스트림을 이용하여 보낸다*/

        String hi = "안녕하세요";

        StringBuilder responseBuilder = new StringBuilder();

        responseBuilder.append("<!doctype HTML>\n")
                .append("<html>\n")
                .append("<head></head>")
                .append("<body>\n")
                .append("<h1>"+hi+"</h1>")
                .append("</body>\n")
                .append("</html>");

        // 인코딩 방식이 정해져 있지 않아 한글이 깨진다
        // 이를 해결하기 위해 직접 set 통해 속성값을 집어 넣는것이다
        // 해당 웹페이지에서 F12 를 하면 ResponseHeader 에 contentType 이 set 된것을 확인할수있다
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter pw = resp.getWriter();
        pw.write(responseBuilder.toString());
        pw.flush();
        pw.close();


    }
}
