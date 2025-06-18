<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring View by JSP</title>
<link rel="icon" href="data:;base64,=">
<link rel="stylesheet" type="text/css" href="/css/simple.css">
</head>
<body>
    <h1>Spring View by JSP</h1>
    <c:choose>
        <c:when test="${message eq null}">
            <p>No message specified</p>
        </c:when>
        <c:when test="${message eq ''}">
            <p>Empty message specified</p>
        </c:when>
        <c:otherwise>
            <p>${message}</p>
        </c:otherwise>
    </c:choose>
    <%@include file="/fragment/footer.html"%>
</body>
</html>