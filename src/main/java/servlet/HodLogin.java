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

import dbconnect.ConnectDB;

/**
 * Servlet implementation class HodLogin
 */
@WebServlet("/HodLogin")
public class HodLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HodLogin() {
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
		PrintWriter pw=response.getWriter();

			    try
			    {
				    PreparedStatement pstmt=((Connection) con).prepareStatement("select * from dept_tbl where email=? and password=?");
					pstmt.setString(1, email);
					pstmt.setString(2, password);
					 rs = pstmt.executeQuery();
				    if(rs.next())
					{
				    	/* email=rs.getString("email");
					    UserInfo.setEmail(email);*/
					   
					 System.out.println("Login Successful");


						response.setContentType("text/html");
						pw.println("<script type=\"text/javascript\">");
						pw.println("alert('Login Successful');");
						pw.println("</script>");
						RequestDispatcher rd=request.getRequestDispatcher("HodDashboard.html");
						rd.include(request, response);	
				    }
				    else
				    {
						System.out.println("Login Failed");
						response.setContentType("text/html");
						pw.println("<script type=\"text/javascript\">");
						pw.println("alert('Wrong email or password');");
						pw.println("</script>");
						RequestDispatcher rd=request.getRequestDispatcher("hodLogin.html");
						rd.include(request, response);
						
				    }
				    
			    }
			    
			    catch(Exception e)
			    {
			    	System.out.println(e.getMessage());
			    }
		    	    
		   
	}



}
