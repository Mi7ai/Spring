package pack2;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreatePrimaryKey {

	public static void main(String[] args) {
//		create session factory
		
		Configuration config = new Configuration();
		
		config = config.configure("hibernate.cfg.xml");
		
		config = config.addAnnotatedClass(Student.class);
				
		SessionFactory f = config.buildSessionFactory();
				
//		SessionFactory f = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				
		Session s = f.getCurrentSession();
		
		try {
//			creating student object
			System.out.println("Creating new student objects.");
			Student s1 = new Student("Mihai","Sky","sky@gmail.com");
			Student s2 = new Student("Mery","Public","public@gmail.com");
			Student s3 = new Student("Fons","Money","money@gmail.com");
			
			
//			start transaction
			s.beginTransaction();
			
//			save student object
			System.out.println("Saving student object");
			s.save(s1);
			s.save(s2);
			s.save(s3);
			
//			commit transaction
			s.getTransaction().commit();
			System.out.println("Done");
		} finally {
			f.close();
		}
	}

}
