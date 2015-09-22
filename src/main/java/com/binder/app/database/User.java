package com.binder.app.database;


import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.lang.ClassNotFoundException;
import java.sql.PreparedStatement;

public class User {

	
	public static void viewTable() {
		
		
		Connection connection = null;
		Statement statement = null;
		
		ResultSet resultSet = null;
		ResultSet resultSet1= null;
		PreparedStatement preparedStatement = null;
		
		
			try{
				System.out.println("connectin to DB...");
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "uglkg45"); 
				System.out.println("Successful 123..");
				statement = connection.createStatement();
				

				//result for the result according to the Grade
				resultSet = statement.executeQuery("USE test SELECT * FROM user_info");
				
				
			while(resultSet.next()){
				Long id = resultSet.getLong("user_id");
				String fName = resultSet.getString("first_name");
				String lName = resultSet.getString("last_name");
				String University = resultSet.getString("user_name");
				
				System.out.println("Id: "+id + " " +"Name: "+ fName + "  "+ lName+ "  "+ "University: " + University);
			}
			
			}
						catch(ClassNotFoundException error){
				System.out.println("Error: "+ error.getLocalizedMessage()); 
				
			}
			catch(SQLException error){
				System.out.println("Error: " + error.getMessage());
				
			}
			//To close down the application after the complision 
			finally{
				if (connection != null){try{ connection.close();}catch (SQLException ignore){}
				if (statement != null) {try{ statement.close(); } catch(SQLException ignore){}}
				if (resultSet != null) {try{ resultSet.close(); } catch(SQLException ignore){}}
				if (resultSet1 != null) {try{ resultSet1.close(); } catch(SQLException ignore){}}
				
				if (preparedStatement != null) {try{ preparedStatement.close(); } catch(SQLException ignore){}}	
			}
	
	}
			
			
	}
}