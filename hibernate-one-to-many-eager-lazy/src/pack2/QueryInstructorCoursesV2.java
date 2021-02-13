package pack2;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class QueryInstructorCoursesV2 {

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
				Query<Instructor> q1 = s.createQuery("select i from Instructor i join FETCH i.courses where i.id=:n", Instructor.class);
				
				q1.setParameter("n", idtofind);
				Instructor i1 = q1.getSingleResult();
				
				System.out.println(i1);
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
