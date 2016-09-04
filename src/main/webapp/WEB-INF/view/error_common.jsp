<%--
  Auth : nicekkong@gmail.com
  Date : 2016. 9. 3. 오후 2:09
  Desc : 공통 에러 처리 화면
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Common Error</title>
</head>
<body>
    <h1>&ltException Info.&gt</h1>
    <h4>${exception.getMessage()}</h4>

    <ul>
        <c:forEach items="${exception.getStackTrace()}" var="stack">
            <li>${stack.toString()}</li>
        </c:forEach>
    </ul>
</body>
</html>