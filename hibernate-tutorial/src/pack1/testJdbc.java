package pack1;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;
 

public class testJdbc {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass= "hbstudent";
		try {
			System.out.println("Connecting...");
			Connection conn = DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connected!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
