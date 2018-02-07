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
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <a class="navbar-brand" href="${contextRoot}/home">Online
                    Shopping</a>
            </div>
        </div>
    </nav>

    <!-- Page Content -->
    <!-- Loading the home content -->
    <div class="content">

        <div class="container">
            <%-- this will be displayed if the credentials are wrong --%>
            <c:if test="${not empty message}">
                <div class="row">
                    <div class="col-md-offset-3 col-md-6">
                        <div class="alert alert-danger">
                            ${message}
                        </div>
                    </div>
                </div>
            </c:if>

                <%-- this will be displayed if the user logged out --%>
                <c:if test="${not empty logout}">
                    <div class="row">
                        <div class="col-md-offset-3 col-md-6">
                            <div class="alert alert-success">
                                    ${logout}
                            </div>
                        </div>
                    </div>
                </c:if>


            <div class="row">

                <div class="col-md-offset-3 col-md-6">

                    <div class="panel panel-primary">

                        <div class="panel-heading">
                            <h4>Login</h4>
                        </div>

                        <div class="panel-body">
                            <form action="${contextRoot}/login" method="POST"
                                  class="form-horizontal" id="loginForm">
                                <div class="form-group">
                                    <label for="username" class="col-md-4 control-label">Email:
                                    </label>
                                    <div class="col-md-8">
                                        <input type="text" name="username" id="username"
                                               class="form-control" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-md-4 control-label">Password:
                                    </label>
                                    <div class="col-md-8">
                                        <input type="password" name="password" id="password"
                                               class="form-control" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-offset-4 col-md-8">
                                        <input type="submit" value="Login" class="btn btn-primary" />
                                        <input type="hidden" name="${_csrf.parameterName}"
                                               value="${_csrf.token}" />
                                    </div>
                                </div>
                            </form>

                        </div>

                        <div class="panel-footer">
                            <div class="text-right">
                                New User - <a href="${contextRoot}/register">Register Here</a>
                            </div>
                        </div>

                    </div>

                </div>
            </div>

        </div>
    </div>

    <!-- Footer comes here -->
    <%@include file="./shared/footer.jsp" %>


    <!-- jQuery -->
    <script src="${contextRoot}/${js}/jquery.js"></script>

    <!-- jQuery Validator Plugin -->
    <script src="${contextRoot}/${js}/jquery.validate.js"></script>

    <!-- Bootstrap Core -->
    <script src="${contextRoot}/${js}/bootstrap.min.js"></script>

    <!-- my scripts -->
    <script src="${contextRoot}/${js}/navigation.js"></script>
    <script src="${contextRoot}/${js}/authorization.js"></script>
</body>

</html>
