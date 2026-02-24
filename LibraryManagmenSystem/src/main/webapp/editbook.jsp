<%@page import="com.pack1.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
BookBean bb = (BookBean)request.getAttribute("bean");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Book</title>

<style>

body{
    margin:0;
    font-family: Arial, sans-serif;
    background: linear-gradient(135deg, #1e293b, #334155);
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
}

/* Card */
.card{
    background:white;
    width:400px;
    padding:30px;
    border-radius:12px;
    box-shadow:0px 10px 25px rgba(0,0,0,0.3);
}

.card h2{
    text-align:center;
    margin-bottom:25px;
    color:#1e293b;
}

/* Input fields */
input[type="text"]{
    width:100%;
    padding:10px;
    margin:10px 0;
    border-radius:6px;
    border:1px solid #ccc;
}

/* Buttons */
.btn{
    width:100%;
    padding:10px;
    margin-top:15px;
    border:none;
    border-radius:6px;
    cursor:pointer;
    font-weight:bold;
}

.update-btn{
    background:#1e293b;
    color:white;
}

.back-btn{
    background:#e2e8f0;
}

</style>
</head>

<body>

<div class="card">

    <h2>Edit Book</h2>

    <form action="edited" method="post">

        <input type="hidden" name="bid" value="<%= bb.getBookId() %>" >

        <label>Book Name</label>
        <input type="text" name="bname" value="<%= bb.getBookName() %>">

        <label>Author</label>
        <input type="text" name="bauthor" value="<%= bb.getBookAuthor() %>">

        <label>Price</label>
        <input type="text" name="bprice" value="<%= bb.getPrice() %>">

        <button class="btn update-btn">Update Book</button>

    </form>

   <a href="home.jsp">
        <button class="btn back-btn">Cancel</button>
   </a>

</div>

</body>
</html>