package FirstDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ResultSetType_UpdateData_DB {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/jdbc_demo",
					"root","akki1312");
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE
					,ResultSet.CONCUR_UPDATABLE);
			
			String str="select *from student";
			
			ResultSet rs=stmt.executeQuery(str);
			
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the name and Updated City of the Student");
			String name=s.nextLine();
			String city=s.next();
			while(rs.next()) {
				//Update
				if(rs.getString("name").equalsIgnoreCase(name)) {
					rs.updateString("city", city);
					rs.updateRow();
				}
				System.out.println(rs.getInt("id")+"\t\t"+rs.getString("name")+"\t\t"+
						rs.getString("city"));
			}
			
			s.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
