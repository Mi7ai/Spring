package pack2;

import org.hibernate.cfg.Configuration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateStudent {

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
//			start transaction
			ses.beginTransaction();
			
			int studentId = 1;
			
//			find student by id
			Student student1 = ses.get(Student.class, studentId);
			System.out.println("Updating student with id" + studentId);
			
//			update student email
			student1.setEmail("sky_rocket@gmail.com");
			
//			query the result
			List<Student> q1 = ses.createQuery("from Student where email like 'sky_rocket@gmail.com'",Student.class).getResultList();
			
			System.out.println(q1.get(0));
			
//			commit transaction
			ses.getTransaction().commit();
			System.out.println("Done");
		} finally {
			f.close();
		}
	}

}
