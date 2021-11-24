package FirstDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectData_DB {

	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo",
				"root","akki1312");
		
		String s="Select *from student";
		
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(s);
		while(rs.next()) {
			System.out.println(rs.getInt("id")+"\t\t"+rs.getString("name")+"\t\t"+rs.getString("city"));
		}
		
		
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
