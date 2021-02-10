package pack2;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ReadStudent {

	public static void main(String[] args) {
//		create session factory
		
//		Configuration config = new Configuration();
//		
//		config = config.configure("hibernate.cfg.xml");
//		
//		config = config.addAnnotatedClass(Student.class);
//				
//		SessionFactory f = config.buildSessionFactory();
				
		SessionFactory f = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				
		Session ses = f.getCurrentSession();
		
		try {
//			creating student object
			System.out.println("Reading student object");
			Student s1 = new Student("Mihai","Wall","mihai@gmail.com");
			
//			start transaction
			ses.beginTransaction();
			
//			save student object
			System.out.println("Saving student object");
			ses.save(s1);
			
//			commit transaction
			ses.getTransaction().commit();
			
			

			System.out.println("Saved student id:" +s1.getId());
			
			Session ses2 = f.getCurrentSession();
			
			ses2.beginTransaction();
//			find student by id
			Student s2 =  ses2.get(Student.class, s1.getId());
//			check if is null if you want. s2 might be null
			ses2.getTransaction().commit();
			
			System.out.println(s2);
			System.out.println("Done");
		} finally {
			f.close();
		}
	}

}
