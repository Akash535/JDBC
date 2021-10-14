package FirstDB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertData_DB {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo",
					"root","akki1312");
			
			String s="insert into student (name,city,phone)values(?,?,?)";
			
			PreparedStatement pstmt=con.prepareStatement(s);
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("enter the name :");
			String name=br.readLine();
			System.out.println("enter the city :");
			String city=br.readLine();
			System.out.println("enter the phone no :");
			String phone=br.readLine();
			
			pstmt.setString(1, name);
			pstmt.setString(2, city);
			pstmt.setString(3,phone);
			
			pstmt.executeUpdate();
			
			System.out.println("Data inserted ...");
			con.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
