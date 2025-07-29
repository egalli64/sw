<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logged</title>
<link rel="icon" href="data:;base64,=">
<link rel="stylesheet" type="text/css" href="/css/simple.css">
</head>
<body>
    <h1>Logged</h1>
    <c:choose>
        <c:when test="${name eq null}">
            <p>Can't login</p>
        </c:when>
        <c:otherwise>
            <p>Welcome back, ${name}!</p>
        </c:otherwise>
    </c:choose>
    <%@include file="/fragment/footer.html"%>
</body>
</html>