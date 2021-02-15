package pack1;

import java.sql.DriverManager;


public class testJdbc {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-05-many-to-many?useSSL=false";
		String user = "hbstudent";
		String pass= "hbstudent";
		try {
			System.out.println("Connecting...");
			DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connected!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
