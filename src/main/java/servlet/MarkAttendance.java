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

import dbconnect.*;


/**
 * Servlet implementation class MarkAttendance
 */
@WebServlet("/MarkAttendance")
public class MarkAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarkAttendance() {
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
		String status[]=request.getParameterValues("status");
	
		PrintWriter pw=response.getWriter();
		try
		{
			
			String date=request.getParameter("date");
			
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

				String s="insert into attendance_tbl values(?,?,?,?,?,?,?)";	
				PreparedStatement pstmt;
				pstmt = con.prepareStatement(s);
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, rollno);
				pstmt.setString(4, year);
				pstmt.setString(5,branch);
                pstmt.setString(6,status[count]);
                System.out.println(id+" : "+status[count]);  

                pstmt.setString(7,date);

				count++;
				id++;
				int j = pstmt.executeUpdate();
				 if(j>0)
					{
					i++; 
					}	
			}
			 
			 if(i>0)
				{
				System.out.println(i+ "record inserted");
				System.out.println("Feedback Added successfully");
				response.setContentType("text/html");
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Attendance Added successfully');");
				pw.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("markAttendance.jsp");
				rd.include(request, response);
					//response.sendRedirect("markAttendance.jsp"); 
				}
				else
				{
					System.out.println("Failed ");
					response.setContentType("text/html");
					pw.println("<script type=\"text/javascript\">");
					pw.println("alert('Failed to Mark Attendance');");
					pw.println("</script>");
					RequestDispatcher rd=request.getRequestDispatcher("markAttendance.jsp");
					rd.include(request, response);
					//response.sendRedirect("markAttendance.jsp"); 	
				}
			 }
			
			
		
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
