package pack3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateEmployee {
	public static void main(String[] args) {
//		hibernate config file
		SessionFactory f = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		Session s = f.getCurrentSession();
		
		try {
//			create employee array objects
			Employee[] employees = {
					new Employee("Django", "Unchained", "The big cricks"),
					new Employee("Marco", "Polo", "The low streets"),
					new Employee("Petros", "Petrovich", "The petros"),
					new Employee("Mikhail", "Mihailovik", "The kalashnikov"),
					new Employee("Dimitri", "Dimitrov", "The dimitruski den"),
					new Employee("Ana", "Ivanovna", "The mafia thieves")
			};
			
			
//			start transaction
			s.beginTransaction();
			
//			save employees to db
			for (Employee emp : employees) {
				System.out.println("Creating employee: "+emp);
				s.save(emp);
			}
			
//			commit transaction
			s.getTransaction().commit();
			System.out.println("Done");
			
		} finally {
			f.close();
		}
	}
}
