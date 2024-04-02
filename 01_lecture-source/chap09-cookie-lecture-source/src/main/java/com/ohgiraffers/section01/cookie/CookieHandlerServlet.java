package com.ohgiraffers.section01.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName=req.getParameter("firstName");
        String lastName=req.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

//        resp.sendRedirect("redirect");

        /*필기. 쿠기 조리법
         *  1. 쿠키를 생성한다
         *  2. 생성한 쿠키에 만료 시간을 정한다
         *  3. 응답 헤더에 쿠키를 담는다
         *  4. 응답을 보낸다*/

        // 쿠키를 생성 ( 쿠키 생성자에 매개변수로 key(string) 와 value를 집어 넣는다
        Cookie firstNameCookie = new Cookie("firstName",firstName);
        Cookie lastNameCookie = new Cookie("lastName",lastName);

        // 만료기간 설정
        firstNameCookie.setMaxAge(60*60*24); // 초단위 이다(s)
        lastNameCookie.setMaxAge(60*60*24);

        //response 헤더에 등록
        resp.addCookie(firstNameCookie);
        resp.addCookie(lastNameCookie);

        //응답을 보낸다
        resp.sendRedirect("redirect");
    }
}
