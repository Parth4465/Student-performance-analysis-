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
 * Servlet implementation class UpdatePassword
 */
@WebServlet("/UpdatePassword")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePassword() {
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
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String pass;
		try
		{
			PrintWriter pw=response.getWriter();

			Connection con = ConnectDB.connect();
			PreparedStatement ps = con.prepareStatement("select * from student_tbl where email=?");
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				pass=rs.getString("password");
				System.out.println("Old Password ="+pass);
			}
			
			PreparedStatement ps1 = con.prepareStatement("update student_tbl set password=? where email=?");
			ps1.setString(1, password);
			ps1.setString(2, email);
			int i = ps1.executeUpdate();
			
			if(i>0)
			{
				System.out.println("Password Updated successfully");
				response.setContentType("text/html");
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Password Updated successfully');");
				pw.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
			else
			{
				System.out.println("failed to update");
				response.setContentType("text/html");
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Failed to update Password');");
				pw.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}