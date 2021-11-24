package FirstDB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteData_DB {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo",
					"root","akki1312");
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("enter the name to deleted data :");
			String name=br.readLine();
		
			
			String s="delete from student where name=?";
			
			PreparedStatement  stmt=con.prepareStatement(s);
			
			stmt.setString(1, name);
			
			stmt.executeUpdate();
			System.out.println("Delete Successfully...");

			con.close();

		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
