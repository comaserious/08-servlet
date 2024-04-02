package com.ohgiraffers.section02.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

@WebServlet("/headers")
public class ResponseHeaderPrintServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter pw = resp.getWriter();

        long currentTime = System.currentTimeMillis();

        pw.print("<h1>"+currentTime+"</h1>");

        pw.close();

        Collection<String> responseHeader =resp.getHeaderNames();
        Iterator<String> respIter = responseHeader.iterator();
        while(respIter.hasNext()){
            String headerName = respIter.next();
            System.out.println(headerName + " : "+resp.getHeader(headerName) );

        }
    }
}
