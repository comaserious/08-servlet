package com.ohgiraffers.section02.annotation;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

// xml 방식과 달리 어노테이션은 클래스 선언부 위에 @WebServlet 과 value 값으로 index의 href 값을 집어 넣으면
//자동으로 연결하여 해당 하이퍼링크 작동시 연결된 이 클래스를 실행시킨다
@WebServlet(value="/annotation-lifeCycle")
public class LifeCycleTestServlet extends HttpServlet {

    private int initCount =1;
    private int serviceCount =1;
    private int destroyCount =1;

    public LifeCycleTestServlet(){}

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service 어노테이션 호출 : "+serviceCount++);
    }

    @Override
    public void destroy() {
        System.out.println("destroy 어노테이션 호출 : "+destroyCount++);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init 어노테이션 호출 : "+initCount++);
    }
}
