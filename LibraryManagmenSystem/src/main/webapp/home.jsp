<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.pack1.BookBean" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library Dashboard</title>

<style>
body{
    margin:0;
    font-family: Arial, sans-serif;
    background:#f4f6f9;
}

.navbar{
    background:#1e3a8a;
    color:white;
    padding:15px 30px;
    display:flex;
    justify-content:space-between;
    align-items:center;
}

.navbar h2{
    margin:0;
}

.navbar a{
    color:white;
    text-decoration:none;
    margin-left:15px;
    font-size:14px;
}

.container{
    width:90%;
    margin:30px auto;
}

table{
    width:100%;
    border-collapse:collapse;
    background:white;
    box-shadow:0 5px 15px rgba(0,0,0,0.1);
}

th, td{
    padding:12px;
    text-align:center;
    border-bottom:1px solid #ddd;
}

th{
    background:#2563eb;
    color:white;
}

tr:hover{
    background:#f1f5f9;
}

.btn{
    padding:6px 12px;
    border:none;
    border-radius:4px;
    cursor:pointer;
    font-size:13px;
}

.edit-btn{
    background:#f59e0b;
    color:white;
}

.delete-btn{
    background:#ef4444;
    color:white;
}

.add-btn{
    display:inline-block;
    margin-bottom:15px;
    padding:8px 15px;
    background:#2563eb;
    color:white;
    text-decoration:none;
    border-radius:5px;
}
</style>

</head>
<body>

<div class="navbar">
    <h2>Library Management - Admin Panel</h2>
    <div>
        Welcome, <%= application.getAttribute("name") %>
        <a href="logout">Logout</a>
    </div>
</div>

<div class="container">

    <a href="add.html" class="add-btn">+ Add Book</a>

    <table>
        <tr>
            <th>ID</th>
            <th>Book Name</th>
            <th>Author</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>

        <%
        ArrayList<BookBean> al = (ArrayList<BookBean>)request.getAttribute("books");
        if(al != null){
            for(BookBean bb : al){
        %>
        <tr>
            <td><%= bb.getBookId() %></td>
            <td><%= bb.getBookName() %></td>
            <td><%= bb.getBookAuthor() %></td>
            <td>₹ <%= bb.getPrice() %></td>
            <td>
                <button class="btn edit-btn">Edit</button>
                <button class="btn delete-btn">Delete</button>
            </td>
        </tr>
        <%
            }
        }
        %>

    </table>

</div>

</body>
</html>