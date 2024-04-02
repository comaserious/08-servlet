package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        //세션 생성
        HttpSession session = req.getSession();
        /*session 기본 유지 만료시간이 존재한다 30분 1800초*/
        System.out.println("session 의 기본 만료시간 : "+session.getMaxInactiveInterval());

        session.setMaxInactiveInterval(60*10);  //10분
        System.out.println("session 의 변경후 만료시간 :"+session.getMaxInactiveInterval());

        //session 은 부라우저 당 한개씩 고유한 아이디를 가지고 하나의 인스턴스를 이용한다.
        // 매번 반복할때마다 동일한 session id를 반환한다

        System.out.println("session 의 아이디"+session.getId());

        /*필기.
        *  만든 session 에 공유할 값 담기
        *  setAttribute(String key,Object value) 형태로 담는다
        *  getAttribute(String key) <= 값을 얻을때*/

        session.setAttribute("firstName",firstName);
        session.setAttribute("lastName",lastName);

        resp.sendRedirect("redirect");





    }
}
