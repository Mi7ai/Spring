package pack3;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pack2.Student;

public class QueryEmployee {

	public static void main(String[] args) {
//		hibernate config file
		SessionFactory f = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		Session s = f.getCurrentSession();
		
		try {
//			start transaction
			s.beginTransaction();
			
			
			String nametofind ="Django";
			
//			get employee by nametofind
			System.out.println("Beginnind query");
			Employee emp1 = s.createQuery("from Employee where firstName= :n", Employee.class).setParameter("n", nametofind).getSingleResult();
			System.out.println(emp1);
			
//			commit transaction
			s.getTransaction().commit();
			System.out.println("Done");
		} finally {
			f.close();
			
		}
	}
	
	private static void displayEmployees(List<Employee> theEmployees) {
		for (Employee emp : theEmployees) {
			System.out.println(emp);
		}
	}
}
