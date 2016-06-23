<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
    <title>Bookish</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="/js/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="span8">
            <a class="navbar-brand" href="https://www.thoughtworks.com">
                Brand
            </a>
            <ul class="nav nav-pills">
                <li role="presentation" class="active"><a href="#1">Books</a></li>
            </ul>
        </div>
        <div class="tab-content">
            <div class="tab-pane active" id="1">
                <br/>
                <c:forEach items="${books}" var="book">
                    <a href="/book/${book.asin}">${book.title}</a>
                    <br/>
                    <hr/>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/js/jquery-1.9.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/js/bootstrap/js/bootstrap.min.js"></script>


</body>
</html>