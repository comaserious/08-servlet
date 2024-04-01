package com.ohgiraffers.section01.servicemethod;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        HttpServletRequest httpRequest  = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) res;

        /*필기.
           httpRequest 의 getMethod() 메소드는 어떠한 http method
           메소드 요청이 들어 온것인지 문자열 헝태로 반환을 해준다*/
        String httpmethod = httpRequest.getMethod();
        System.out.println("httpmethod = " + httpmethod);
        // 출력값이 get 일경우
        if(httpmethod.equals("GET")){
            doGet(httpRequest,httpResponse);
        }
        else if(httpmethod.equals("POST")){
            doPost(httpRequest,httpResponse);
        }

        /*필기.
        *  GET, POST
        *  -HEAD, OPTIONS , PUT, DELETE, TRACE , CONNECT
        *  -하지만 대부분 GET 과 POST 방식을 대부분 사용한다(그나마 PUT , DELETE 정도이다)*/
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get 요청을 처리할 메소드 호출함!!!!!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post 요청을 처리할 메소드 호출함 !!!!");
    }
}
