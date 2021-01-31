package pack1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorCoachApp {
    public static void main(String[] args) {
//        load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        retrieve bean
        Coach c1 = context.getBean("Coach1", Coach.class);
//        call method 1
        System.out.println(c1.getDailyWorkout());
//        call method 2
        System.out.println(c1.getDailyFortune());

//        close context
        context.close();

    }
}
