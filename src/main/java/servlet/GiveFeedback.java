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
import dbconnect.*;
/**
 * Servlet implementation class GiveFeedback
 */
@WebServlet("/GiveFeedback")
public class GiveFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiveFeedback() {
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
		PrintWriter pw=response.getWriter();

		String des=request.getParameter("description");
		try
		{
			Connection con = ConnectDB.connect();
			PreparedStatement ps1 = con.prepareStatement("insert into feedback_tbl values(?,?,?,?,?,?)");
			ps1.setInt(1, 0);
			ps1.setString(2, des);
			ps1.setString(3, UserInfo.getRollno());
			ps1.setString(4, UserInfo.getYear());
			ps1.setString(5, UserInfo.getBranch());
			ps1.setString(6, UserInfo.getEmail());
			int i = ps1.executeUpdate();
			if(i>0)
			{
				System.out.println("Feedback Added successfully");
				response.setContentType("text/html");
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Feedback Added successfully');");
				pw.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("feedback.html");
				rd.include(request, response);
				//response.sendRedirect("feedback.html");
			}
			else
			{
				System.out.println("failed to add");
				response.setContentType("text/html");
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Failed To Add');");
				pw.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("StudentDashboard.html");
				rd.include(request, response);
				//response.sendRedirect("StudentDashboard.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}