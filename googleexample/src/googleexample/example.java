package googleexample;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;

public class example {

	public static void main(String[] args) {
	
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","nikhil");
		Statement stmt=con.createStatement();
		System.out.println("insert the record");
		String sql="insert into count values (295)";
		stmt.executeUpdate(sql);
		
	} catch (Exception e) {
		System.out.println(e);
		
	}
		

	}

}
