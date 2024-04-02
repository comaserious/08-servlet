package com.ohgiraffers.section02.otherservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("redirect servlet으로 오기 성공");

        StringBuilder redirectText = new StringBuilder();

        redirectText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head></head>\n")
                .append("<body>\n")

                .append("<h1>이 서블릿으로 redirect 성공!!!</h1>")

                .append("</body>\n")
                .append("</html>");

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.print(redirectText.toString());
        pw.flush();
        pw.close();

        /*필기.
        *  redirect를 하게 되면 url 이 재작성되어 새로고침할때
        *  redirect된 페이지에 대한 요청을 반복하게 된다
        *  즉, 이전 요청에 포함된 정보는 남아있지 않게 되고,
        *  url 이 변경되는것이 redirect 의 특징이다
        *  http 프로토콜에 의한 요청은 요청시 잠시 connection 을 맺고
        *  응답 시에도 잠시 connection 을 맺으며
        *  요청 단위 당 request 객체를 한개만 생성한다
        *  따라서 첫 요청 시의 request 와 현재 redirect 된
        *  페이지의 request 는 서로 다른 객체이므로
        *  redirect 를 쓰면 이전 서블릿의 값을 공유해서
        *  사용할 수 없다
        *  */

        /*필기.
        *  그러면 redirect 할때 값을 유지해서
        *  공유하면서 사용하는 방법은 뭘까?
        *  -쿠키 ,세션*/
    }
}
