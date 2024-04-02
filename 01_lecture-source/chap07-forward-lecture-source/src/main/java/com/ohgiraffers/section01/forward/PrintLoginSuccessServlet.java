package com.ohgiraffers.section01.forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/print")
public class PrintLoginSuccessServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getAttribute("userId").toString();
        String pass= req.getAttribute("pass").toString();
        System.out.println("forward 에게서 받은 userId = " + userId);
        System.out.println("forward 에게서 받은 pass = " + pass);

        StringBuilder responseText = new StringBuilder();

        responseText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head></head>\n")
                .append("<body>\n")
                .append("<h1>\n")
                .append(userId+"님 로그인 성공하셨습니다")
                .append("</h1>\n")
                .append("</body>\n")
                .append("</html>");

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.print(responseText.toString());
        pw.close();

        // url 창을 확인해보면 response는 분명 /print 에서 했지만 /forward 라고 적혀있다
        // 이것은 forward가 print 에게 위임을 했을때 print 가 아닌 forward로 작성되게 되어 있다
    }
}
