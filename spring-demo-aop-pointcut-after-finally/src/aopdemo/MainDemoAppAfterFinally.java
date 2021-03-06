package aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aopdemo.dao.AccountDAO;

public class MainDemoAppAfterFinally {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO ac = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccounts = null;
		try {
			boolean flag = false;
			theAccounts = ac.findAccounts(flag);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("Main Program After Throwing");
		System.out.println(theAccounts);
		
		
		context.close();
	}

}
