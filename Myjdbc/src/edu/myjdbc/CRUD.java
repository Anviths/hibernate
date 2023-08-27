package edu.myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {

	public static void main(String[] args) {

		String url="jdbc:postgresql://localhost:5432/Person";
		String user="postgres";
		String password="root";
		try {
			//step1
			Class.forName("org.postgresql.Driver");
			//step 2
			Connection connection=DriverManager.getConnection(url,user,password);
			
			
			//step 3
		Statement createStatement = connection.createStatement();
		String sql="delete from person where id=11";
		int i=createStatement.executeUpdate(sql);
//		System.out.println(i);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
