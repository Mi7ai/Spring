package aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import aopdemo.service.TrafficFortuneService;

public class MainDemoAppAround {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService tfs = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("Main Program Around");
		boolean flag = true;
		String data = tfs.getFortune(flag);
		
		System.out.println("Fortune service says: "+data);
		
		context.close();
	}

}
