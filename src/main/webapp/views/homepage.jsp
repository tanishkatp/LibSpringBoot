<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.domain.Books , java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books Listing</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
h1 {text-align: center;}
h3{text-align: right;}
</style>
</head>
<body>
<h1>Books Listing</h1>
<h3><form:form action="new">
                        <input type="submit" value="Add Book"/>
                    </form:form></h3>    
	<table class = "table table-striped">
		<tr>
			<th>Book Code</th>
			<th>Book Name</th>
			<th>Author</th>
			<th>Date Added</th>
			<th>Actions</th>
		</tr>
		<c:forEach var = "book" items = "${books}">
		<tr>
			<td>${book.bookCode}</td>
			<td>${book.bookName}</td>
			<td>${book.author}</td>
			<td>${book.dateAdded}</td>
			<td><form:form action="/edit/${book.bookCode}">
                        <input type="submit" value="EDIT"/>
                    </form:form>
				<form:form action="/delete/${book.bookCode}">
                        <input type="submit" value="DELETE"/>
                    </form:form>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>