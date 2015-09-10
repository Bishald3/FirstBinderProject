package com.binder.app.rest.helper;

	import java.sql.SQLException;
	import java.sql.ResultSet;
	import java.sql.Connection;
	import java.sql.Statement;
	import java.sql.DriverManager;
	import java.lang.ClassNotFoundException;
	import java.sql.PreparedStatement;


	public class JDBCResult {
		
		public JDBCResult(){
			super();
		}
		public static void main(String[] args) {
			
			
			Connection connection = null;
			Statement statement = null;
			
			ResultSet resultSet = null;
			PreparedStatement preparedStatement = null;
			
			
				try{
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "uglkg45"); 
					statement = connection.createStatement();
					
					//to add the more information of the Student by using preparedStatement
					
					statement.execute("USE test");
					resultSet = statement.executeQuery("SELECT * FROM user_info");
					
					
				while(resultSet.next()){
					String fName = resultSet.getString("first_name");
					String lName = resultSet.getString("last_name");
					
					System.out.println("Name: "+ fName + "  "+ lName+ "  ");
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
					
					if (preparedStatement != null) {try{ preparedStatement.close(); } catch(SQLException ignore){}}	
				}
		
		}
				
				
		}

//		public static void addInformation (Connection connection, PreparedStatement preparedStatement, String fName, String lName, String University, String Grade) throws SQLException{
//			preparedStatement = connection.prepareStatement("INSERT INTO information (fName, lName, University, Grade) VALUES (?, ?, ?, ?)");
//			preparedStatement.setString(1, fName);
//			preparedStatement.setString(2, lName);
//			preparedStatement.executeUpdate();
//			
//		}
	}

	


