package FirstDB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateData_DB {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo",
					"root","akki1312");
			
			
			
			System.out.println("enter the name and update the city name :");
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String name=br.readLine();
			String city=br.readLine();
			
			String s="update student set city=? where name=?";
			
			PreparedStatement  stmt=con.prepareStatement(s);
			stmt.setString(1, city);
			stmt.setString(2, name);
			
			stmt.executeUpdate();
			System.out.println("New data inserted ....");

			con.close();

		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
