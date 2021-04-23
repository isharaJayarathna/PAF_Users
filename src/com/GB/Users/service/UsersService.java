package com.GB.Users.service;
import java.sql.*;
import com.GB.Users.util.DBconnection;
import com.GB.Users.model.*;
import com.GB.Users.util.*;

public class UsersService {
Connection con = null;
	
	public UsersService() {
		
		con = DBconnection.connecter();
	}
	
	 //A common method to connect to the DB
	
	
	public String insertUsers(Users Users)
	 {
		String query = " insert into Users(`UserId`,`UFirstName`,`ULastName`,`Uphone`,`UMail`,`UserRole`,`UPassword`)"
				  + " values (?,?, ?, ?, ?, ?)";
		  
	 String output;
		try {	
				PreparedStatement preparedStatement = con.prepareStatement(query); 
				preparedStatement.setString(1, Users.getUserId());
				preparedStatement.setString(2, Users.getUFirstName());
				preparedStatement.setString(3, Users.getULastName());
				preparedStatement.setString(4,  Users.getUphone());
				preparedStatement.setString(5, Users.getUMail());
				preparedStatement.setString(6, Users.getUserRole()); 
				preparedStatement.setString(7, Users.getUPassword()); 
				preparedStatement.execute();
				 con.close();
			  output = "Inserted successfully";
			
		} catch (SQLException e) {
		    output = "Error while inserting the User.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	
	public String readUsers()
	 {
	 String output = "";
	 try
	 {
	
	 if (con == null)
	 {return "Error while connecting to the database for reading."; }
	 // Prepare the html table to be displayed
	 //output = "<table border=\"1\"><tr><th>Fund ID</th><th>Funding Agency</th><th>Address</th><th>Phone</th><th>Prject ID</th><th>Fund Amount</th></tr>";
	 
	 output = "<table border=\"1\"><tr><th>User ID</th><th>First Name</th><th>Last Name</th><th>Phone</th><th>Mail</th><th>User Role</th><th>Pass Word</th></tr>";
	 String query = "select * from Users";
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
		 String UserId = rs.getString("UserId");
		 String UFirstName = rs.getString("UFirstName");
		 String ULastName = rs.getString("ULastName");
		 String Uphone = rs.getString("Uphone");
		 String UMail = rs.getString("UMail");
		 String UserRole = rs.getString("UserRole");
		 String UPassword = rs.getString("UPassword");
	 // Add into the html table
		 output += "<tr><td>" + UserId + "</td>";
		 output += "<td>" + UFirstName + "</td>";
		 output += "<td>" + ULastName + "</td>";
		 output += "<td>" + Uphone + "</td>";
		 output += "<td>" + UMail + "</td>";
		 output += "<td>" + UserRole + "</td>";
		 output += "<td>" + UPassword + "</td>";
	 
	 }
	 con.close();
	 // Complete the html table
	 output += "</table>";
	 }
	 catch (Exception e)
	 {
	 output = "Error while reading the Users.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	
	
	public String updateUsers(Users Users){
	
	 String query = "UPDATE Users SET UFirstName=?,ULastName=?,Uphone=?,UMail=?,UserRole=?,UPassword=? WHERE UserId=?";
	 String output = "";
	 try
	 {
	 
	 if (con == null)
	 {return "Error while connecting to the database for updating."; }
	 // create a prepared statement
	 PreparedStatement preparedStatement = con.prepareStatement(query);
	 
	 	preparedStatement.setString(1, Users.getUserId());
		preparedStatement.setString(2, Users.getUFirstName());
		preparedStatement.setString(3, Users.getULastName());
		preparedStatement.setString(4,  Users.getUphone());
		preparedStatement.setString(5, Users.getUMail());
		preparedStatement.setString(6, Users.getUserRole()); 
		preparedStatement.setString(7, Users.getUPassword()); 
		
		
		
		preparedStatement.execute();
		con.close();
		output = "Updated successfully";
	}
	 catch (Exception e)
	 {
	 output = "Error while updating the Users.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	
	
	public String deleteUsers(Users Users){
		String query = "delete from Users where UserId=?";
		String output;
		
		
		try {
			
	 if (con == null){
		 return "Error while connecting to the database for deleting."; }
	 // create a prepared statement
	 
	 PreparedStatement preparedStatement = con.prepareStatement(query);
	 // binding values
	 preparedStatement.setString(1,Users.getUserId() );
	 // execute the statement
	 if(preparedStatement.execute()) {
		 output = "Deleted successfully";
	 }else {
		 output = "id not found";
	 }
		
	 con.close();
	 
	 }catch (Exception e){
	 output = "Error while deleting the Users.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }

}
