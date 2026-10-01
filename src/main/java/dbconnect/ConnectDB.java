package dbconnect;
import java.sql.*;
public class ConnectDB {
	public static Connection con=null;
	public static Connection connect()
	{
		if(con==null)
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver"); //load the driver
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "");
				
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return con;
	}
	
	
}