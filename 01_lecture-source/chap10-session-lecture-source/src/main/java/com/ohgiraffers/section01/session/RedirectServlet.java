package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // session 을 공유하지 않았기 때문에 null 값이 출력된다
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        HttpSession session = req.getSession();
        System.out.println("session 의 아이디 확인 : "+session.getId());

        firstName = session.getAttribute("firstName").toString();
        lastName = session.getAttribute("lastName").toString();

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        StringBuilder responseText = new StringBuilder();
        resp.setContentType("text/html; charset=UTF-8");
        responseText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head></head>\n")
                .append("<body>\n")
                .append("<h1> firstName :"+firstName +"</h1>")
                .append("<h1> lastName : "+lastName+"</h1>")
                .append("</body>\n")
                .append("</html>");

        PrintWriter pw = resp.getWriter();
        pw.print(responseText.toString());
        pw.close();



    }
}
