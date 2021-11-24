package FirstDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ResultSetType_InsertData_DB {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/jdbc_demo",
					"root","akki1312");
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			String str="select *from student";
			ResultSet rs=stmt.executeQuery(str);
			Scanner s=new Scanner(System.in);
			System.out.println("enter the name:");
			String name=s.nextLine();
			System.out.println("enter the city:");
			String city=s.next();
			System.out.println("enter the phone :");
			String phone=s.next();
			if(rs.getConcurrency()==ResultSet.CONCUR_UPDATABLE) {
				rs.moveToInsertRow();
				rs.updateString(1, null);
				rs.updateString(2, name);
				rs.updateString(3,city);
				rs.updateString(4, phone);
				rs.insertRow();
				
				rs.moveToCurrentRow();
				while(rs.next()) {
					System.out.println(rs.getInt("id")+"\t\t"+rs.getString("name")+"\t\t"+
				rs.getString("city")+"\t\t"+rs.getString("phone"));
				}
			}
			s.close();
			con.close();
					
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
