package servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dbconnect.ConnectDB;

/**
 * Servlet implementation class UploadTimetable
 */
@WebServlet("/UploadTimetable")
@MultipartConfig(maxFileSize = 1024*1024*10,//10MB
fileSizeThreshold=1024*1024*2,	//2MB
maxRequestSize=1024*1024*50) //50MB
public class UploadTimetable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadTimetable() {
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
		doGet(request, response);int id=0;
		//int id1=UserInfo.getId();
		Part file=request.getPart("image");
		String filename=getSubmittedFileName(file);
		System.out.println(filename);
		//Getvalue.setDocfilename(filename);
		String path="C:/Users/r3sys.com/workspace/Student Performance Analysis Web App/WebContent/timetable/"+filename;
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
			String s="insert into timetable_tbl values(?,?,?)";	
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, 0);
			pstmt.setString(2, "");
			pstmt.setTimestamp(3,timestamp);
			pstmt.executeUpdate();
			ResultSet rs=pstmt.executeQuery("select * from timetable_tbl");
			while(rs.next()){
			id=rs.getInt("id");
			}
			PreparedStatement ps1=con.prepareStatement("update  timetable_tbl set image=? where id=?");
			ps1.setString(1, filename);
			ps1.setInt(2, id);
			int n = ps1.executeUpdate();
			if(n>0)
			{
				System.out.println("Item Inserted Successfully");
				request.getSession().setAttribute("msg", "Document Inserted Successfully..!!");
				response.sendRedirect("addTimetableHod.jsp"); 
			}
			else
			{
				System.out.println("Item Failed to Insert");
				request.getSession().setAttribute("msg", "Document Failed To Insert..!!");
				response.sendRedirect("addTimetableHod.jsp"); 
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
