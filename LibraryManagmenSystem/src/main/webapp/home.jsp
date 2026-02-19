<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.pack1.BookBean" %>
     <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%  out.println(request.getAttribute("name")+"<br><br>"); 
 ArrayList<BookBean> al = (ArrayList<BookBean>)request.getAttribute("books");
for(BookBean bb : al){
	 out.println(bb.getBookId()+" "+bb.getBookName()+" "+bb.getBookAuthor()+" "+bb.getPrice()+" <button>Edit</button><button>Delete</button>");
	 
}
out.println("<button>Logout</button>");



%>

</body>
</html>