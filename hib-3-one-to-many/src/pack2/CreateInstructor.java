package pack2;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateInstructor {

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
//			creating instructor object
			System.out.println("Creating new Instructor object.");
			Instructor i1 = new Instructor("Mihai","Instructor","mihai@gmail.com");
			InstructorDetail id1 = new InstructorDetail("http://youtube_channel", "Programming");

//			associate objects
			i1.setInstructorDetail(id1);
			
//			start transaction
			s.beginTransaction();
			
//			save student object: cascadetype.all
			System.out.println("Saving instructor object. Will also save instructor_detail object");
			System.out.println(i1);
			System.out.println(id1);
			s.save(i1);
			
//			commit transaction
			s.getTransaction().commit();
			System.out.println("Done");
		} finally {
			f.close();
		}
	}

}
