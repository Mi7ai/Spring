package pack2;

import org.hibernate.cfg.Configuration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class QueryStudent {

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
				
		Session s = f.getCurrentSession();
		
		try {
			
//			start transaction
			s.beginTransaction();
			
//			query student object
			List<Student> theStudents =  s.createQuery("from Student", Student.class).getResultList();
			
//			display students
			displayStudents(theStudents);
			
//			query student with name sky
			List<Student> q1 = s.createQuery("from Student where lastName='Sky'",Student.class).getResultList();
			System.out.println("Students with last name of Sky");
			displayStudents(q1);
			
//			query fullname: Mihai Wall
			List<Student> q2 = s.createQuery("from Student where firstName='Mihai' and lastName='Wall'",Student.class).getResultList();
			System.out.println("Students with first name Mihai and last name Wall");
			displayStudents(q2);
			
//			query email end with @gmail.com
			
			List<Student> q3 = s.createQuery("from Student where email like '%@gmail.com'",Student.class).getResultList();
			System.out.println("Students with email ending with @gmail.com");
			displayStudents(q3);
			
			
			
			
			
//			commit transaction
			s.getTransaction().commit();
			System.out.println("Done");
		} finally {
			f.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

}
