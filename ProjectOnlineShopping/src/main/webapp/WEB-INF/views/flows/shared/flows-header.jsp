<%--
  Created by IntelliJ IDEA.
  User: IOAdmin
  Date: 18.01.2018
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="resources/assets/css" var="css"/>
<spring:url value="resources/assets/js" var="js"/>
<spring:url value="resources/assets/images" var="images"/>

<c:set value="${pageContext.request.contextPath}" var="contextRoot"/>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Shopping - ${title}</title>

    <!-- script for active menu, navigation.js -->
    <script>
        window.menu = '${title}';
        window.contextRoot = '${contextRoot}';
    </script>

    <!-- Bootstrap Core CSS -->
    <link href="${contextRoot}/${css}/bootstrap.min.css" rel="stylesheet">
    <link href="${contextRoot}/${css}/bootstrap-readable-theme.css" rel="stylesheet">

    <!-- Bootstrap DataTables CSS -->
    <link href="${contextRoot}/${css}/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${contextRoot}/${css}/shop-homepage.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<!-- Navigation -->
<%@include file="flows-navbar.jsp"%>

<!-- Page Content -->
<div class="content">