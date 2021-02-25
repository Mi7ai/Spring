package aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO ac = context.getBean("accountDAO", AccountDAO.class);

		ac.addAccount();
		
		context.close();
	}

}
