package SecondDB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertData_DB {

	public static void main(String[] args) {
		try {
			Connection con=ConnectionProvider.getConnection();
			
			String s="insert into employee (name,city)values(?,?)";
			
			PreparedStatement pstmt=con.prepareStatement(s);
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("enter the name :");
			String name=br.readLine();
			System.out.println("enter the city :");
			String city=br.readLine();
			
			
			pstmt.setString(1, name);
			pstmt.setString(2, city);
			
			
			pstmt.executeUpdate();
			
			System.out.println("Data inserted ...");
			con.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
