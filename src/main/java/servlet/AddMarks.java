package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnect.ConnectDB;

/**
 * Servlet implementation class AddMarks
 */
@WebServlet("/AddMarks")
public class AddMarks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMarks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String subject=request.getParameter("subject");
		String marks=request.getParameter("marks");
		String date=request.getParameter("date");
		String total=request.getParameter("total");
		PrintWriter pw=response.getWriter();
		try
		{			
			Connection con=ConnectDB.connect();
		
			int count =0;
			int i =0;
			PreparedStatement p=con.prepareStatement("select * from student_tbl");
		
			 ResultSet r=p.executeQuery();
			 while(r.next())
			 {
				int id=r.getInt("id");
				String rollno=r.getString("rollno");
				String name=r.getString("name");
				String year=r.getString("year");
				String branch=r.getString("branch");
			 
				String s="insert into marks_tbl values(?,?,?,?,?,?,?,?,?)";	
				PreparedStatement pstmt;
				pstmt = con.prepareStatement(s);
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, rollno);
				pstmt.setString(4, year);
				pstmt.setString(5,branch);
                pstmt.setString(6,subject);
                pstmt.setString(7,total);
                pstmt.setString(8,marks);
                pstmt.setString(9,date);
				count++;
				id++;
				i=pstmt.executeUpdate();
			 }
			 if(i>0)
				{
				System.out.println(i+ "record inserted");
				response.setContentType("text/html");
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Marks Added Successfully');");
				pw.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("addMarks.jsp");
				rd.include(request, response);
					//response.sendRedirect("addMarks.jsp"); 
				}
				else
				{
					System.out.println("Failed ");
					response.setContentType("text/html");
					pw.println("<script type=\"text/javascript\">");
					pw.println("alert('Failed to Add');");
					pw.println("</script>");
					RequestDispatcher rd=request.getRequestDispatcher("addMarks.jsp");
					rd.include(request, response);
					//response.sendRedirect("addMarks.jsp"); 	
				}
			 }
			
			
		
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
