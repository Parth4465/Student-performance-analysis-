package servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import dbconnect.*;

/**
 * Servlet implementation class UploadNotice
 */
@WebServlet("/UploadNotice")
@MultipartConfig(maxFileSize = 1024*1024*10,//10MB
fileSizeThreshold=1024*1024*2,	//2MB
maxRequestSize=1024*1024*50) //50MB
public class UploadNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadNotice() {
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
		 int id=0;
		int id1=UserInfo.getId();
		Part file=request.getPart("image");
		String filename=getSubmittedFileName(file);
		System.out.println(filename);
		PrintWriter pw=response.getWriter();

		//Getvalue.setDocfilename(filename);
		String path="C:/Users/r3sys.com/workspace/Student Performance Analysis Web App/WebContent/notice/"+filename;
		try{
			FileOutputStream fos=new FileOutputStream(path);
			InputStream is =file.getInputStream();
			byte[] data=new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try{
			Connection con=ConnectDB.connect();
			long millis=System.currentTimeMillis();  
    		java.sql.Date date=new java.sql.Date(millis); 
    		long currentTimeMillis = System.currentTimeMillis();
    		Timestamp timestamp = new Timestamp(currentTimeMillis);
			String s="insert into notice_tbl values(?,?,?)";	
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, 0);
			pstmt.setString(2, "");
			pstmt.setTimestamp(3,timestamp);
			pstmt.executeUpdate();
			ResultSet rs=pstmt.executeQuery("select * from notice_tbl");
			while(rs.next()){
			id=rs.getInt("id");
			}
			PreparedStatement ps1=con.prepareStatement("update  notice_tbl set image=? where id=?");
			ps1.setString(1, filename);
			ps1.setInt(2, id);
			int n = ps1.executeUpdate();
			if(n>0)
			{
				System.out.println("Item Inserted Successfully");
				response.setContentType("text/html");
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Notice Added Successfully');");
				pw.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("addNotice.jsp");
				rd.include(request, response);
				//response.sendRedirect("addNotice.jsp"); 
			}
			else
			{
				System.out.println("Item Failed to Insert");
				response.setContentType("text/html");
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Failed To Add Notice');");
				pw.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("addNotice.jsp");
				rd.include(request, response); 
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
private String getSubmittedFileName(Part file) {
        
        for(String cd:file.getHeader("content-disposition").split(";"))
        {
        	if(cd.trim().startsWith("filename"))
        	{
        		String filename=cd.substring(cd.indexOf('=')+1).trim().replace("\"", "");
        				return filename.substring(filename.lastIndexOf('/')+1).substring(filename.lastIndexOf('\\')+1);
        	}
        }
        	return null;
        }

}
