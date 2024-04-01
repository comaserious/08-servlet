package com.ohgiraffers.section01.queryString;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;


@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {
    /*필기.
    *  HttpServlet 클래스의 service 메소드는 요청방식에 따라
    *  GET 요청에 대해서 doGet() 메소드를 호출하면서
    *  request 와 response 를 전달한다*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        System.out.println("name = " + name);

        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("age = " + age);

        java.sql.Date date = Date.valueOf(request.getParameter("birthday"));
        System.out.println("date = " + date);

        String gender = request.getParameter("gender");
        if(gender.equals("m")) {
            System.out.println("남성입니다");
        }
        else{
            System.out.println("여성입니다");
        }

        String nation = request.getParameter("national");
        System.out.println("nation = " + nation);

        // checkbox 다중으로 입력을 받을 수 있어, 선택된 값이 문자열 배열로 전달된다
        // getParameter() => x , getParameterValues() =>o
        System.out.println("취미 :");
        String[] hobbies  = request.getParameterValues("hobby");

        for(String hobby : hobbies){
            System.out.print(hobby+" ");
        }






    }
}
