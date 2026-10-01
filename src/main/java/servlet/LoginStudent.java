package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnect.*;


/**
 * Servlet implementation class LoginStudent
 */
@WebServlet("/LoginStudent")
public class LoginStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Connection con= ConnectDB.connect();
		ResultSet rs =null;
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String status="Approved";
		PrintWriter pw=response.getWriter();
			    try
			    {
				    PreparedStatement pstmt=con.prepareStatement("select * from student_tbl where email=? and password=? and status=?");
					pstmt.setString(1, email);
					pstmt.setString(2, password);
					pstmt.setString(3, status);
					 rs = pstmt.executeQuery();
				    if(rs.next())
					{
				    	String emailid=rs.getString(7);
					   UserInfo.setEmail(emailid);
					   String year=rs.getString("year");
					   UserInfo.setYear(year);
					   String branch=rs.getString("branch");
					   UserInfo.setBranch(branch);
					   String roll=rs.getString("rollno");
					   UserInfo.setRollno(roll);
					   int id1=rs.getInt("id");
					   UserInfo.setId(id1);
					  
					 System.out.println("Login Successful");
					 

						response.setContentType("text/html");
						pw.println("<script type=\"text/javascript\">");
						pw.println("alert('Login Successful');");
						pw.println("</script>");
						RequestDispatcher rd=request.getRequestDispatcher("StudentDashboard.html");
						rd.include(request, response);
	
				    	
						
				    }
				    else
				    {
						 System.out.println("Login Failed");

						 	response.setContentType("text/html");
							pw.println("<script type=\"text/javascript\">");
							pw.println("alert('Wrong email or password');");
							pw.println("</script>");
							RequestDispatcher rd=request.getRequestDispatcher("index.html");
							rd.include(request, response);
						
				    	
				    	
				    }
				    
			    }
			    
			    catch(Exception e)
			    {
			    	System.out.println(e.getMessage());
			    }
		    	    
		   
	}



}
