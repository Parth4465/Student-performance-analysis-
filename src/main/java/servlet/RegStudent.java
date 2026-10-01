package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnect.ConnectDB;

/**
 * Servlet implementation class RegStudent
 */
@WebServlet("/RegStudent")
public class RegStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegStudent() {
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
		String name,mobile,year,branch,rollno;
		name = request.getParameter("name");
		rollno = request.getParameter("rollno");
		mobile = request.getParameter("mobile");
		year = request.getParameter("year");
		branch = request.getParameter("branch");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		PrintWriter pw=response.getWriter();

		try
		{
			Connection con = ConnectDB.connect();
			PreparedStatement ps1 = con.prepareStatement("insert into student_tbl values(?,?,?,?,?,?,?,?,?,?)");
			ps1.setInt(1, 0);
			ps1.setString(2, name);
			ps1.setString(3,rollno);
			ps1.setString(4, mobile);
			ps1.setString(5, year);
			ps1.setString(6, branch);
			ps1.setString(7, email);
			ps1.setString(8, contact);
			ps1.setString(9, password);
			ps1.setString(10,"Pending");
			int i = ps1.executeUpdate();
			if(i>0)
			{
				System.out.println("Registered successfully");
				response.setContentType("text/html");
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Registered successfully');");
				pw.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.include(request, response);
				//response.sendRedirect("index.html");
			}
			else
			{
				System.out.println("failed to register");
				response.setContentType("text/html");
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Failed To Register');");
				pw.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.include(request, response);
				//response.sendRedirect("index.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}