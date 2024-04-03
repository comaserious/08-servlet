package com.ohgiraffers.menu.controller;

import com.ohgiraffers.menu.model.service.MenuPriceCalculator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/menu/order")
public class MenuOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*필기.
        *  서블릿의 역할
        *   1. 요청 받은 값 확인및 검증
        *   2. 비즈니스로직 처리
        *   3. 응답 페이지 생성후 응답=>jsp로 위임*/

        String menuName = req.getParameter("menuName");
        int count = Integer.parseInt(req.getParameter("count"));

        System.out.println("menu = " + menuName);
        System.out.println("count = " + count);

        // 비즈니스 로직
        // menuName, count 를 넘겨서 우리가 선택한 메뉴와 갯수에 대한 총 가격을 반환
        int orderPrice = new MenuPriceCalculator().calcOrderPrice(menuName,count);

        req.setAttribute("menuName", menuName);
        req.setAttribute("count",count);
        req.setAttribute("orderPrice",orderPrice);

        //forward 방식
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/5_response.jsp");
        rd.forward(req,resp);


    }
}
