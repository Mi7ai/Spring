package pack2;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class QueryInstructorDetail {

	public static void main(String[] args) {
//		create session factory
		
//		Configuration config = new Configuration();
//		
//		config = config.configure("hibernate.cfg.xml");
//		
//		config = config.addAnnotatedClass(Student.class);
//				
//		SessionFactory f = config.buildSessionFactory();
				
		SessionFactory f = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
				
		Session s = f.getCurrentSession();
		
		try {
//			start transaction
			s.beginTransaction();
			
			int idtofind = 2;
			System.out.println("Trying to find Instructor Detail object with id: " +idtofind);

			try {
//				finding instructor object
				InstructorDetail id1 = s.get(InstructorDetail.class, idtofind);
				System.out.println(id1);
				System.out.println(id1.getInstructor());
			} catch (Exception e) {
				System.out.println("InstructorDetail not found");
			}
			
//			commit transaction
			s.getTransaction().commit();
			System.out.println("Done");
		} finally {
			f.close();
		}
	}

}
