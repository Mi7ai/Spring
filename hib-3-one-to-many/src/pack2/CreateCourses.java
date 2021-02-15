package pack2;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateCourses {

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
			int idtofind = 1;
			
//			start transaction
			s.beginTransaction();
			
//			get instructor from db
			System.out.println("Creating new Course object.");
			Instructor i1 = s.get(Instructor.class, idtofind);
			
//			creating course object
			Course c1 = new Course("A new beginning");
			Course c2 = new Course("The spicy food");
			
//			associate objects
			i1.addCourse(c1);
			i1.addCourse(c2);
			
//			save course object
			System.out.println("Saving course objects.");
			System.out.println(c1);
			System.out.println(c2);
			s.save(c1);
			s.save(c2);
			
//			commit transaction
			s.getTransaction().commit();
			System.out.println("Done");
		} finally {
			f.close();
		}
	}

}
