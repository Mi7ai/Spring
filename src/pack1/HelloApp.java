package pack1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
    public static void main(String[] args) {
//      load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//      retrieve bean
        Coach c1 = context.getBean("MyCoach", Coach.class);
//      call method
        System.out.println(c1.getDailyWorkout());
//      close context
        context.close();
    }
}
