package pack2;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class QueryInstructorCourses {

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
			System.out.println("Trying to find Instructor object with id: " +idtofind);

			try {
//				finding instructor object
				Instructor i1 = s.get(Instructor.class, idtofind);
				System.out.println(i1);
				System.out.println("Courses: "+i1.getCourses());
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
