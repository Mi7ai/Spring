package pack2;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateStudent {

	public static void main(String[] args) {
//		create session factory
		
//		Configuration config = new Configuration();
//		
//		config = config.configure("hibernate.cfg.xml");
//		
//		config = config.addAnnotatedClass(Student.class);
//				
//		SessionFactory factory = config.buildSessionFactory();
//				
		SessionFactory f = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				
		Session s = f.getCurrentSession();
		
		try {
//			creating student object
			System.out.println("Creating new student object.");
			Student s1 = new Student("Mihai","Wall","mihai@gmail.com");
			
//			start transaction
			s.beginTransaction();
			
//			save student object
			System.out.println("Saving student object");
			s.save(s1);
			
//			commit transaction
			s.getTransaction().commit();
			System.out.println("Done");
		} finally {
			f.close();
		}
	}

}
