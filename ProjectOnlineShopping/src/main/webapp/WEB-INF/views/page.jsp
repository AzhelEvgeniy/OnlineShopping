<%--
  Created by IntelliJ IDEA.
  User: IOAdmin
  Date: 18.01.2018
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set value="${pageContext.request.contextPath}" var="contextPath"/>

<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
${contextPath} says ${greeting}
</body>
</html>
