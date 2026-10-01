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
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
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
		String rollno=request.getParameter("rollno");
		String mobile=request.getParameter("mobile");
		
		try
		{
			PrintWriter pw=response.getWriter();

			Connection con = ConnectDB.connect();
			PreparedStatement ps = con.prepareStatement("select * from student_tbl where rollno=?");
			ps.setString(1,rollno);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String n=rs.getString("mobile");
				System.out.println("Old Contact No ="+n);
			}
			PreparedStatement ps1 = con.prepareStatement("update student_tbl set mobile=? where rollno=?");
			ps1.setString(1, mobile);
			ps1.setString(2, rollno);
			int i = ps1.executeUpdate();
			if(i>0)
			{
				System.out.println("Contact Updated successfully");
				response.setContentType("text/html");
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Record Updated successfully');");
				pw.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("updateStudent.jsp");
				rd.include(request, response);
				//response.sendRedirect("updateStudent.jsp");
			}
			else
			{
				System.out.println("failed to update");
				response.setContentType("text/html");
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Record Failed to Update');");
				pw.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("updateStudent.jsp");
				rd.include(request, response);
				//response.sendRedirect("updateStudent.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}