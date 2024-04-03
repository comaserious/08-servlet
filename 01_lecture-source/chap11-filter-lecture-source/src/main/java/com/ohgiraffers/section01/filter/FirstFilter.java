package com.ohgiraffers.section01.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

// * 은 언제나 전체다
//즉 /first/로 시작하는 모든 url은 이 필터클래스를 거쳐야만 한다
@WebFilter("/first/*")
public class FirstFilter implements Filter {

    public FirstFilter(){
        System.out.println("first filter 인스턴스 생성됨~~");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        /*필기.
        *  필터의 인스턴스가 최초로 생성될때 호출되는 메소드*/
        System.out.println("Filter init() 호출됨...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        /*필기.
        *  servlet 으로 request 가 전달되기 전에 요청을 가로채는 메소드*/

        System.out.println("Filter의 doFitler() 메소드 호출됨....");

        /*필기. 필터에서 처리할 코드를 작성하는 것이다*/

        /*필기. 처리를 한뒤 다음 필터 혹은 서블릿의 doGet/doPost 를 호출한다*/
        filterChain.doFilter(servletRequest,servletResponse);

        /*필기. 서블릿에서 처리후에 다시 수행할 내용이 있다면 작성하는 공간*/
        System.out.println("servlet 요청 수행 완료");
    }

    @Override
    public void destroy() {
        /*필기.
        *  필터 인스턴스가 소멸될때 호출되는 메소드(=톰켓을 종료할때)*/
        System.out.println("Filter destroy() 메소드 호출됨...");
    }
}
