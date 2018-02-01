<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="resources/assets/css" var="css"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Shopping - ${title}</title>

    <!-- Bootstrap Core CSS -->
    <link href="${contextRoot}/${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap Readable Theme -->
    <link href="${contextRoot}/${css}/bootstrap-readable-theme.css" rel="stylesheet">

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

    <div class="wrapper">

        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="${contextRoot}/home">Home</a>
                </div>
            </div>
        </nav>


        <div class="content">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12">

                        <div class="jumbotron">

                            <h1>${errorTitle}</h1>
                            <hr/>

                            <blockquote style="word-wrap:break-word">

                                ${errorDescription}

                            </blockquote>

                        </div>

                    </div>
                </div>
            </div>
        </div>


        <%@include file="./shared/footer.jsp" %>

    </div>

</body>
</html>