package edu.myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/Person";
		String user="postgres";
		String password="root";
		try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			System.out.println(con);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
