package aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aopdemo.dao.AccountDAO;
import aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO ac = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO mb = context.getBean("membershipDAO", MembershipDAO.class);

		Account account1 = new Account();
		ac.addAccount(account1);
		ac.sayHi();
		
		ac.setLevel("one");
		ac.getLevel();
		
		ac.setName("bravo");
		ac.getName();
		
		
		mb.addAccount();
		
		context.close();
	}

}
