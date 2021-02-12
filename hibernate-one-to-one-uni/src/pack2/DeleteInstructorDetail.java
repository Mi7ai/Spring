package pack2;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteInstructorDetail {

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
				.buildSessionFactory();
				
		Session s = f.getCurrentSession();
		
		try {
//			start transaction
			s.beginTransaction();
			
			int idtofind = 3;
//			delete instructor detail object: cascadetype.all to instructor
			System.out.println("Deleting Instructor Detail object with id: "+idtofind);
			

			
			try {
				
//				finding instructor object
				InstructorDetail id1 = s.get(InstructorDetail.class, idtofind);
				
//				break bi directiional link to delete only this object from db and 
//				not to cascade to the instructor object
				id1.getInstructor().setInstructorDetail(null);
				
				s.delete(id1);
				System.out.println(id1);
			} catch (Exception e) {
				System.out.println("Instructor Detail not found");
			}
			
//			commit transaction
			s.getTransaction().commit();
			System.out.println("Done");
		} finally {
			f.close();
		}
	}

}
