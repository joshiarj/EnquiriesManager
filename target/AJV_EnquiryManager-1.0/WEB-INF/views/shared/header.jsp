<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="SITE_URL"  value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring Hibernate Banking</title>
        <style type="text/css">
            a {text-decoration: none !important;}
            a:hover{color: goldenrod;}
            .btn-link{text-decoration: none !important;}
            .btn-link:hover{color: goldenrod;}
            .btn-link:focus,
            .btn-link:active:focus{outline:none;}
            .btn-link:focus{text-decoration:none;}
        </style>
    </head>
    <body style="background:black">
        <div class="container" id="top-header" style="background:palegoldenrod;">
            <!--style="background:lightcyan; position:fixed; width: 88%;">-->
            <table style="width: 100%; height: 40px; vertical-align: middle; table-layout: fixed">
                <tr>
                    <td><a href="${SITE_URL}"><span class="glyphicon glyphicon-home"></span> Home</a></td>
                    <td align="center"><img src="${SITE_URL}/img/logo.png" height="35" width="200"/></td>
                    <td align="right">
                        <c:if test="${empty loggedIn}">
                            <a href="${SITE_URL}/user/register"><span class="glyphicon glyphicon-user"></span> Register</a> | 
                            <a href="${SITE_URL}/login"><span class="glyphicon glyphicon-log-in"></span> Log In</a>
                        </c:if>
                        <c:if test="${not empty loggedIn}">
                            Hello, ${loggedInUser.username}! | 
                            <a href="${SITE_URL}/logout"><span class="glyphicon glyphicon-log-out"></span> Log Out</a>
                        </c:if>
                    </td>
                </tr>
            </table>
        </div>
        <div class="container" style="background:white">