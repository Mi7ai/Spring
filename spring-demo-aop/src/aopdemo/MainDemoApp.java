package aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.AccountDAO;
import dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO ac = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO mb = context.getBean("membershipDAO", MembershipDAO.class);

		Account account1 = new Account();
		ac.addAccount(account1);
		
		ac.sayHi();
		
		mb.addAccount();
		
		context.close();
	}

}
