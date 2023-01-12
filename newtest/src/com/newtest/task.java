package com.newtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class task {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			for(;;) {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","nikhil");
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the choice");
			int choice=sc.nextInt();
			System.out.println("enter the choice 1.insert 2. update 3.fetch 4.exit");
			switch(choice) {
			case 1:Statement st = con.createStatement();
			      int a=st.executeUpdate("insert into jdbc.emp(id,name,salary)values(3,'pooja',2000)");
			      System.out.println(a);
			      System.out.println("inserted values");
			      break;
			case 2: PreparedStatement ps=con.prepareStatement("update jdbc.emp set name=? where id=?");
			         
			          System.out.println("enter name");
			          String name=sc.next();
			          System.out.println("enter id");
			          int id=sc.nextInt();
		
			           ps.setString(1,name);
			           ps.setInt(2,id);
	
			            ps.execute();
			           System.out.println("values updated successfully"); 
			           break;
			case 3: PreparedStatement p=con.prepareStatement("select*from jdbc.emp where salary=?");
			       
			       System.out.println("enter salary");
		         	double salary=sc.nextDouble();
			       p.setDouble(1,salary );
			       ResultSet rs=p.executeQuery();
			      while(rs.next()) {
				   System.out.println(rs.getInt(1));
				  System.out.println(rs.getString(2));
				  System.out.println(rs.getDouble(3));
				
			      } 
			      break;
			case 4:System.exit(0);     
			}
			
			}
			
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
	 }
	
 }