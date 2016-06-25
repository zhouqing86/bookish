<%@ page language="java" pageEncoding="UTF-8"%>
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
            <hr/>
        </div>
        <div class="tab-content">
            <div class="tab-pane active" id="1">
                <br/>
                总页数: ${books.totalPages}, 总记录数: ${books.totalElements}
                <br/>
                <hr/>
                <c:forEach items="${books.content}" var="book">
                    <div class="col-sm-8 col-md-4 height-200">
                        <img src="http://localhost:9999/images/thumbnails/${book.asin}.jpg" height="100"/> <br/>
                        <a href="/book/${book.asin}">${book.title}</a>
                        <br/>
                        <c:forEach items="${book.authors}" var="author">
                            ${author} &nbsp;&nbsp;
                        </c:forEach>
                        </br>
                        出版日期: ${book.published_at} <br/>
                    </div>
                </c:forEach>
                <div class="clear clearfix"/>
                <ul id="books-pagination" class="pagination col-md-12">
                </ul>
            </div>
        </div>
    </div>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/js/jquery-1.9.1.min.js"></script>
<script src="/js/jquery.twbsPagination.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/js/bootstrap/js/bootstrap.min.js"></script>


<script type="text/javascript">
    $('#books-pagination').twbsPagination({
        totalPages: "${books.totalPages}",
        visiblePages: 10,
        first:"&laquo;",
        last:"&raquo;",
        prev:"",
        next:"",
        href:"/books?page={{number}}&pageSize=10",
        onPageClick: function (event, page) {
        }
    });
</script>

<style type="text/css">
    .height-200 {
        height:200px;
    }
</style>

</body>
</html>