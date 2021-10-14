package FirstDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetType_DeleteData_DB {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/jdbc_demo",
					"root","akki1312");
			
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			
			String s="select *from student";
			
			ResultSet rs=stmt.executeQuery(s);
			while(rs.next()) {
				if(rs.getInt(1)==4)
					rs.deleteRow();
				else
					System.out.println(rs.getInt("id")+"\t\t"+rs.getString("name")+"\t\t"+
							rs.getString("city"));
					
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
