<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Book</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
h1 {text-align: center;}
.myDiv{position: absolute;
		left: 50%;
		top: 50%;
		transform: translate(-50%, -50%);
		border: 5px solid #afa1a1;
		padding: 5px;
		background: #F2F2DD;
		}
</style>
</head>
<body>
<div class = "myDiv">
<form action="editBook">
	Book Code:<input type="text" name="bookcode" value=<%= request.getAttribute("bookcode")%> readonly >
	<br/><br/>
	Book Name:<input type="text" name="bookname">
	<br/><br/>
	Author:<input type = "text" name="author">
	<br><br>
	Added On :<input type="text" value=<%= (new java.util.Date()).toLocaleString() %> readonly >
	<br>
<input type="submit">
</form>
</div>
</body>
</html>