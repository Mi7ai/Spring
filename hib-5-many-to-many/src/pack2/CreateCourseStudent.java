package pack2;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateCourseStudent {

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
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
				
		Session s = f.getCurrentSession();
		
		try {
//			start transaction
			s.beginTransaction();
			
			System.out.println("Creating new Course and Student objects.");
			
//			creating course object
			Course c1 = new Course("A new beginning");
			
//			save course object and it will cascade
			System.out.println("Saving course objects.");
			s.save(c1);
			System.out.println(c1);
			
			
//			creating student object
			Student s1 = new Student("John","Wich","wick@gmail.com");
			Student s2 = new Student("George","Wich","george@gmail.com");
			
			c1.addStudent(s1);
			c1.addStudent(s2);
			
//			save student object
			System.out.println("Saving students objects.");
			s.save(s1);
			s.save(s2);
			System.out.println(s1);
			System.out.println(s2);
			
//			commit transaction
			s.getTransaction().commit();
			System.out.println("Done");
		} finally {
			f.close();
		}
	}

}
