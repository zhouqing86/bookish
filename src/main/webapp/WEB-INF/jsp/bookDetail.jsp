<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
    <title>Bookish</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="/js/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<br>
<div class="container">
    <div class="row">
        <div class="span8">
            <a class="navbar-brand" href="https://www.thoughtworks.com">
                Brand
            </a>
            <ul class="nav nav-pills">
                <li role="presentation"><a href="/">Homepage</a></li>
            </ul>
        </div>
        <hr/>
    </div>
    Book Detail:
    <br/>
    <img src="http://localhost:9999/images/actuals/${book.asin}.jpg"/> <br/>
    标题: ${book.title}<br/>
    作者:
    <c:forEach items="${book.authors}" var="author">
        ${author} &nbsp;&nbsp;
    </c:forEach>
    </br>
    出版日期: ${book.published_at} <br/>

</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/js/jquery-1.9.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/js/bootstrap/js/bootstrap.min.js"></script>


</body>
</html>