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
 * Servlet implementation class AddHod
 */
@WebServlet("/AddHod")
public class AddHod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHod() {
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
		String name,contact,department;
		name = request.getParameter("name");
		contact = request.getParameter("contact");
		department = request.getParameter("department");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		PrintWriter pw=response.getWriter();

		try
		{
			Connection con = ConnectDB.connect();
			PreparedStatement ps1 = con.prepareStatement("insert into dept_tbl values(?,?,?,?,?,?)");
			ps1.setInt(1, 0);
			ps1.setString(2, name);
			ps1.setString(3, email);
			ps1.setString(4, contact);
			ps1.setString(5, department);
			ps1.setString(6, password);
			int i = ps1.executeUpdate();
			if(i>0)
			{
				System.out.println("Registered successfully");
				response.setContentType("text/html");
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Hod Added Successfully');");
				pw.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("addHOD.html");
				rd.include(request, response);
				//response.sendRedirect("addHOD.html");
			}
			else
			{
				System.out.println("failed to register");
				response.setContentType("text/html");
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Failed to Add');");
				pw.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("addHOD.html");
				rd.include(request, response);
				//response.sendRedirect("addHOD.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}