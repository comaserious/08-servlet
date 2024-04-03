package com.ohgiraffers.section01.filter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/first/filter")
public class FirstFilterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("doGet Servlet 요청 확인");

//        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter pw = resp.getWriter();

        pw.println("<html>");
        pw.println("<head></head>");
        pw.println("<body>");
        pw.println("<h3>필터 확인용 서블릿 요청 확인 완료 </h3> ");
        pw.println("</body>");
        pw.println("</html>");
        pw.close();
    }

}
