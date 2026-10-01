<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.sql.*" %>
    <%@page import="dbconnect.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Railway Accident Prevention using IOT</title>
</head>
<body>

<%
int id = Integer.parseInt(request.getParameter("id"));
try
{
	Connection con = ConnectDB.connect();
	PreparedStatement ps = con.prepareStatement("update student_tbl set status=? where id=?");
	ps.setString(1, "Disapproved");
	ps.setInt(2,id);
	
	int i = ps.executeUpdate();
	{
		response.sendRedirect("approveStudent.jsp");
	}
}
catch(Exception e)
{
	e.printStackTrace();
}

%>




</body>
</html>