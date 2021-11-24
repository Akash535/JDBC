package FirstDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable_DB {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo",
					"root","akki1312");
			
			//Create Query
			String s="create table studeant(id int(10) primary key auto_increment,name char(50),"
					+ "city char(50),phone char(10))";
			
			// Create a Statement
			Statement stmt=con.createStatement();
			stmt.executeUpdate(s);
			
			System.out.println("table created in database...");
			con.close();

		}
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
