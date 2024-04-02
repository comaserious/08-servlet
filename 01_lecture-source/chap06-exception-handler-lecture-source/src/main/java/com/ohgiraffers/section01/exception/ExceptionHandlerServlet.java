package com.ohgiraffers.section01.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*필기.
            Request 객체에는 parameter 영역과 attribute 영역이 존재한다
            attribute 영역에 무엇이 있는가?
         */
        Enumeration<String> attrNames = req.getAttributeNames();
        while(attrNames.hasMoreElements()){
            System.out.println(attrNames.nextElement());
        }

        System.out.println(req.getAttribute("jakarta.servlet.forward.request_uri"));


        String statusCode = req.getAttribute("jakarta.servlet.error.status_code").toString(); //에러코드 404 와 500을 받을수 있게되었다
        String message = req.getAttribute("jakarta.servlet.error.message").toString();

        StringBuilder errorPage = new StringBuilder();

        errorPage.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head></head>\n")
                .append("<body>\n")
                .append("<h1>\n")
                .append(statusCode)
                .append(" - ")
                .append(message)
                .append("</h1>\n")
                .append("</body>\n")
                .append("</html>");

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.print(errorPage.toString());
        pw.flush();
        pw.close();

    }
}
