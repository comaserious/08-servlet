package com.ohgiraffers.section02.formdata;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        System.out.println("name = " + name);

        /*필기.
        *  만약 클라이언트(프론트) 에서 요청한 데이터의
        *  key 와 value 를 하나하나 확인하기 힘들다?
        *  그러면 모든 데이터의 key 값을 이용하여
        *  전송된 값들을 일괄처리 할 수 있다*/

        //getParameterMap();

        Map<String,String[]> requestMap = request.getParameterMap();
        Set<String> keySet =requestMap.keySet();

        Iterator<String> keyIter = keySet.iterator();

        while(keyIter.hasNext()){
            String key =keyIter.next();
            String[] value = requestMap.get(key);
            for(String v : value){
                System.out.println(v);
            }
        }

        // 파라미터로 전달된 키 모록만 확인 할수도 있다
        //request.getParameterNames();

        Enumeration<String> names = request.getParameterNames();
        while(names.hasMoreElements()){
            System.out.println(names.nextElement());
        }

        /*요약하자면
        * GET 방식은 작성자가 작성한 값이 url 값에 그대로 들어난다는 것이다
        * 주로 어떠한 것을 검색하거나 조회를 할때 많이 사용한다
        * 반면에
        * POST 방식은 작성자가 작성한 값을 url 값에 들어내지 않는 방식으로
        * 데이터의 값이 중요한 정보를 가지고 있거나 개인정보로 보안을 요구할때
        * 사용을 한다 예를 들어 로그인 같은 것이다*/
    }
}
