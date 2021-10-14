package FirstDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetType_SelectData_DB {

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
				//it will jump resultSet pointer to given row no.
				rs.absolute(6);
				System.out.println("Next student Data:");
				System.out.println(rs.getInt("id")+"\t\t"+rs.getString("name")+
						"\t\t"+rs.getString("city")+"\t\t"+rs.getString("phone"));
				
				if(rs.previous()) {
					System.out.println("previous student Data:");
					System.out.println(rs.getInt("id")+"\t\t"+rs.getString("name")+
							"\t\t"+rs.getString("city")+"\t\t"+rs.getString("phone"));
					break;
				}
				
			}
			}catch(Exception e) {
			System.out.println(e);
		}
	}

}

/*
OutPut :
	
Next student Data:
7		Raj Kumar		Hadapsar		7721842203
previous student Data:
6		Sumeet Gade		Bhosri		7350089474



 */
