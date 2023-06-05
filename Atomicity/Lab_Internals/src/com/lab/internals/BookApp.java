package com.lab.internals;
import java.sql.*;
public class BookApp {
	   
	   static String connectionURL = "jdbc:sqlserver://172.16.51.44;" +"databaseName=221047011;integratedSecurity=false;user=nagesh;password=nagesh@786";
	   
	   public static void main(String[] args) throws SQLException
	   {
		   Connection connection = null;
		   Statement st = null;
	
		   try 
		   {
			   connection = DriverManager.getConnection(connectionURL);
			   connection.setAutoCommit(false);
			   st=connection.createStatement();
	  
			   String query1="INSERT INTO Book_Count VALUES(105)";
			   String query2="INSERT INTO Book_Details VALUES(105,'djfhbufcbfoihihefhnoicfhnofwnfhoioefnegwff','Finance','Eric')";
	    
			   st.executeUpdate(query1);
			   st.executeUpdate(query2);
	    
			   connection.commit();
			   System.out.println("Row Inserted");
	    } 
	
	catch (SQLException e) 
	{
	    System.out.println("Rollback");
	    connection.rollback();
	    e.printStackTrace();
	}
	
	finally {
	    System.out.println("Closing the connection.");
	    if (connection != null) 
	    	try 
	    { 
	    		connection.close(); 
	    		} 
	    catch (SQLException ignore) {}
	}
	
}
}