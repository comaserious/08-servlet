package com.ohgiraffers.section01.othersite;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/othersite")
public class OtherSiteRedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("get 요청 받은 후 naversite");

        resp.sendRedirect("http://www.naver.com");

        // forward 와 redirect 의 가장 큰 차이점은
        //url의 변화 여부이다
        // forward 의 경우 기존 request 를 받은 url이 그대로 이어가지만
        // redirect 의 경우 redirect로 연결된 최종의 url을 제공한다=>새로운 request를 생성한다고 볼수 있다

        /*필기.
        *  netwrok tap을 확인해보면 302번 코드와 함께
        *  naver 사이트로 이동하는것을 볼수 있다
        *  사용자 url 재작성이라고 불리우는 redirect 방식은
        *  302번 상태코드인 경우 요청에 대한 처리를 완료하였고,
        *  사용자의 url을 강제로 redirect 경로로 이동시키라는
        *  의미이다*/
    }
}
