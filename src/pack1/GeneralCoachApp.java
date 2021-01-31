package pack1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GeneralCoachApp {
    public static void main(String[] args) {
//      load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//      retrieve bean
        Coach c1 = context.getBean("Coach1", Coach.class);
//      call method
        System.out.println(c1.getDailyWorkout());

        System.out.println(c1.getDailyFortune());

//      close context
        context.close();
    }
}
