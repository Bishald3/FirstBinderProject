package com.binder.app.entity;


import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.lang.ClassNotFoundException;
import java.sql.PreparedStatement;


public class SettingUp {
	

	@SuppressWarnings("null")
	public static void main(String[] args) {
		
		
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
				
				//to add the more information of the Student by using preparedStatement
				
//				addInformation(connection, preparedStatement,"Same", "Guys", "Uni of Mexico", "B");
//				System.out.println("Sucessful after adding");
				statement.execute("USE test");
				statement.execute("INSERT INTO user_info (first_name, last_name, user_name, user_id) VALUES ('ambar1', 'rana1', 'aran1', 415)");
				statement.execute("CREATE TABLE information(Id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT, fName VARCHAR(100), lName VARCHAR(100), University VARCHAR(100), Grade VARCHAR(3))");
				statement.execute("INSERT INTO information (fName, lName, University, Grade) VALUES('Ravi', 'Hero', 'Grand Valley State Uni', 'A')");
				statement.execute("INSERT INTO information (Id, fName, lName, University, Grade) VALUES(' 76','Amit', 'G', 'Melborn uni', 'B')");
				
				//for list according to the Id
				//resultSet = statement.executeQuery("SELECT * FROM information");
				
				//result for the result according to the Grade
				//resultSet = statement.executeQuery("SELECT * FROM information ORDER BY Grade");
				
			
			//(while(resultSet.next()){
				//Long id = resultSet.getLong("Id");
				//String fName = resultSet.getString("fName");
				//String lName = resultSet.getString("lName");
				//String University = resultSet.getString("University");
				//String Grade = resultSet.getString("Grade");
				
				//System.out.println("Id: "+id + " " +"Name: "+ fName + "  "+ lName+ "  "+ "University: " + University + "  "+ "Grade: " + Grade);
			//}
			while(resultSet.next()){
				Long id = resultSet.getLong("Id");
				String fName = resultSet.getString("fName");
				String lName = resultSet.getString("lName");
				String University = resultSet.getString("University");
				String Grade = resultSet.getString("Grade");
				
				System.out.println("Id: "+id + " " +"Name: "+ fName + "  "+ lName+ "  "+ "University: " + University + "  "+ "Grade: " + Grade);
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

	public static void addInformation (Connection connection, PreparedStatement preparedStatement, String fName, String lName, String University, String Grade) throws SQLException{
		preparedStatement = connection.prepareStatement("INSERT INTO information (fName, lName, University, Grade) VALUES (?, ?, ?, ?)");
		preparedStatement.setString(1, fName);
		preparedStatement.setString(2, lName);
		preparedStatement.setString(3, University);
		preparedStatement.setString(4, Grade);
		preparedStatement.executeUpdate();
		
	}
}
