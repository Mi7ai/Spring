package pack2;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteCourse {

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
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
				
		Session s = f.getCurrentSession();
		
		try {
//			start transaction
			s.beginTransaction();
			
			int idtofind = 1;
//			delete instructor object: cascadetype.all
			System.out.println("Deleting Course object with id: "+idtofind);
			try {
//				finding instructor object
				Course c1 = s.get(Course.class, idtofind);
//				it will only detele the course without cascading
				s.delete(c1);
				System.out.println(c1);
			} catch (Exception e) {
				System.out.println("Instructor not found");
			}
			
//			commit transaction
			s.getTransaction().commit();
			System.out.println("Done");
		} finally {
			f.close();
		}
	}

}
