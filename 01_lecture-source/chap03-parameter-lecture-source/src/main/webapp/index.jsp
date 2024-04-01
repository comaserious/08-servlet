<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
    <h1>Request Parameter</h1>
    <h3>GET 방식의 요청</h3>
    <h4>form 태그를 이용한 get 방식 요청</h4>
    <form action="querystring" mehtod="get">
      <label>이름 :</label>
      <input type="text" name="name">
      <br>
      <label>나이 :</label>
      <input type="number" name="age">
      <br>
      <label>생일 :</label>
      <input type="date" name="birthday">
      <br>
      <label>성별 :</label>
      <input type="radio" name="gender" id="male" value="m">
      <label for="male">남성</label>
      <input type="radio" name="gender" id="female" value="f">
      <label for="female">여성</label>
      <br>
      <label>국적:</label>
      <select name="national">
        <option value="kor">한국</option>
        <option value="chn">중국</option>
        <option value="jpn">일본</option>
        <option value="etc">기타</option>
      </select>
      <label>취미 : </label>
      <input type="checkbox" name="hobby" id="movie" value="movie"><label for="movie">영화</label>
      <input type="checkbox" name="hobby" id="music" value="music"><label for="music">음악</label>
      <input type="checkbox" name="hobby" id="sleep" value="sleep"><label for="sleep">잠자기</label>
      <br>
      <input type="submit" value="GET 요청">
    </form>

    <hr>
    <h4>a 태그의 href 속성에 직접 파라미터를 쿼리스트링 형태로 작성하여 get 요청</h4>
    <a href="querystring?name=홍길동&age=22&birthday=2024-04-08&gender=m&national=jpn&hobby=movie&hobby=music&hobby=sleep">
      쿼리스트링을 이용한 값 전달
    </a>
    <hr>
    <h4>포스트 방식요청</h4>
    <form action="formdata" method="post">
      <label>이름 :</label>
      <input type="text" name="name">
      <br>
      <label>나이 :</label>
      <input type="number" name="age">
      <br>
      <label>생일 :</label>
      <input type="date" name="birthday">
      <br>
      <label>성별 :</label>
      <input type="radio" name="gender" id="male1" value="m">
      <label for="male">남성</label>
      <input type="radio" name="gender" id="female1" value="f">
      <label for="female">여성</label>
      <br>
      <label>국적:</label>
      <select name="national">
        <option value="kor">한국</option>
        <option value="chn">중국</option>
        <option value="jpn">일본</option>
        <option value="etc">기타</option>
      </select>
      <label>취미 : </label>
      <input type="checkbox" name="hobby" id="movie1" value="movie"><label for="movie">영화</label>
      <input type="checkbox" name="hobby" id="music1" value="music"><label for="music">음악</label>
      <input type="checkbox" name="hobby" id="sleep1" value="sleep"><label for="sleep">잠자기</label>
      <br>
      <input type="submit" value="POST 요청">
    </form>
</body>
</html>