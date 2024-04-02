package com.ohgiraffers.section01.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    // redirect 의 경우 url을 값을 바꾸는 것이기 때문에 doGet 을 사용한다
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);
        /*필기.
        *  null 값이 나온다
        *  why? request 객체는 1회 요청시 하나의 객체를 만들게 되는데
        *  cookie 에서 생성된 request 로 값을 얻고 cookie 에서 다시 redirect 로 request가 발생하게 된다
        *  따라서 두개의 객체가 생성된것이기 때문에 값을 공유할수 없게 되는 것이다*/

        /*필기.
        *  쿠키를 사용하는 방법
        *  1. request 에서 쿠키목록을 배열 행태로 꺼내온다
        *  2. 쿠키의 getName 과 getValue를 이용해 쿠키에 담긴 값을 꺼낸다
        * */

        Cookie[] cookies=req.getCookies();

        for(int i =0; i < cookies.length;i++){
            System.out.println("[cookie]"+cookies[i].getName()+" : "+cookies[i].getValue());

            if("firstName".equals(cookies[i].getName())){
                firstName = cookies[i].getValue();
            }else if(cookies[i].getName().equals("lastName")){
                lastName = cookies[i].getValue();
            }
        }

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
        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        PrintWriter pw = resp.getWriter();
        pw.print(responseText.toString());
        pw.close();

        /*필기.
        *  쿠키는 텍스트 파일 형태로 클라이언트 컴퓨터에 저장된다
        *  그렇기 때문에 개인 PC라면 상관이 없지만
        *  공용 PC 이면 보안에 많이 취약하다
        *  세션은 쿠키와 유사한 형태로 key-value 쌍으로
        *  저장되지만, 서버에서 관리되므로 보안에 우수하다*/
    }
}
