package aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aopdemo.dao.AccountDAO;

public class MainDemoAppAfter {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO ac = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccounts = ac.findAccounts();
		System.out.println("Main  Program");
		System.out.println(theAccounts);
		
		
		context.close();
	}

}
