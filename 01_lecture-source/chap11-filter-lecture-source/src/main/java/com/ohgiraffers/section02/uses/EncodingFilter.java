package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*xml 방식으로 필터를 등록*/

public class EncodingFilter implements Filter {

    public EncodingFilter(){
        System.out.println("전체영역 필터 인스턴스 생성");
    }
    private String encodingType;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("전체 영역 필터 인스턴스 생성후 init 생성");
        /*필기. xml 에 설정한 init-param 의 key 를 이용하여 config 에서 값을 꺼낼수 있다 */
        encodingType=filterConfig.getInitParameter("encoding-type");


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("전역 필터 dofilter 발동");
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setContentType(encodingType);
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("전역필터 dofilter로 돌아옴");
    }

    @Override
    public void destroy() {

    }
}
