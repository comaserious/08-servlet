package com.ohgiraffers.section01.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/headers")
public class RequestHeaderPrintServlet extends HttpServlet {

    /*필기.
        헤더란?
        우리가 데이터를 전송할 때 이게 무슨 데이터야. 라고 알려주는 역할이다
        1. General Header - 요청과 응답 모두 적용되는 헤더, 상태 메세지를 나타낸다
        2. Request Header - 조회될 리소스(정보)나 클라이언트 자체에 대한 상세 정보 포함
        3. Response Header - 응답에 대한 부가적인 정보를 갖고 있는 헤더
        4. Entity Header - 컨텐츠 길이, MIME 타입과 같은 body에 대한 상세 정보를 포함한다
    * */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Enumeration<String> headernames =req.getHeaderNames();

        while(headernames.hasMoreElements()){
            System.out.println(headernames.nextElement());
        }

        // accept header  : 클라이언트에서 웹서버로 request  할 시, 요청할 수 있는 메세지에 담기는 헤더
        // 쉽게 설명하면, 나는 (text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7)
        // 이것들만 수용할 수 있어
        System.out.println("accept :" + req.getHeader("accept"));

        // 쿠키의 아이디를 가지고 있다
        System.out.println("cookie : "+req.getHeader("cookie"));
    }
}
