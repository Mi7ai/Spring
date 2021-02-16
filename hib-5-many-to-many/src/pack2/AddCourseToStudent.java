package pack2;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AddCourseToStudent {

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
			
			int idtofind = 1;
			System.out.println("Trying to find Student object with id: " +idtofind);
			
			try {
//				finding student object
				Student s1 = s.get(Student.class, idtofind);
				System.out.println(s1);
				System.out.println(s1.getCourses());
			
//				creating course object
				System.out.println("Creating new courses");
				Course c1 = new Course("Rubick cube");
				Course c2 = new Course("C++ for beginners");
				
//				adding student to courses 
				c1.addStudent(s1);
				c2.addStudent(s1);
				
//				saving the courses
				System.out.println("Saving new courses");
				System.out.println(c1);
				System.out.println(c2);
				s.save(c1);
				s.save(c2);
				
			} catch (Exception e) {
				System.out.println("Student not found");
			}
			
//			commit transaction
			s.getTransaction().commit();
			System.out.println("Done");
		} finally {
			f.close();
		}
	}

}
