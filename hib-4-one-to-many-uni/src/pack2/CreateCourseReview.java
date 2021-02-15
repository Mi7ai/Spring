package pack2;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateCourseReview {

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
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
				
		Session s = f.getCurrentSession();
		
		try {
//			start transaction
			s.beginTransaction();
			
			System.out.println("Creating new Course and Review objects.");
			
//			creating course object
			Course c1 = new Course("A new beginning");
			
//			add some reviews
			c1.addReview(new Review("Nice course"));
			c1.addReview(new Review("Awesome"));
			c1.addReview(new Review("This course sucks"));
			
//			save course object and it will cascade
			System.out.println("Saving course objects.");
			System.out.println(c1);
			System.out.println(c1.getReviews());
			s.save(c1);
			
//			commit transaction
			s.getTransaction().commit();
			System.out.println("Done");
		} finally {
			f.close();
		}
	}

}
