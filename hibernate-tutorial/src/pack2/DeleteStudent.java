package pack2;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteStudent {

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
			
//			int studentId = 1;
			
//			find student by id
//			Student student1 = ses.get(Student.class, studentId);
//			System.out.println("Deleting student with id " + studentId);
//			
//			delete student
//			ses.delete(student1);

			ses.createQuery("DELETE FROM Student WHERE id=1").executeUpdate();
			
		 
//			commit transaction
			ses.getTransaction().commit();
			System.out.println("Done");
		} finally {
			f.close();
		}
	}

}
