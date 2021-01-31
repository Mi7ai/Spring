package pack1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterCoachApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach c1 = context.getBean("Coach2", Coach.class);

        System.out.println(c1.getDailyWorkout());
        System.out.println(c1.getDailyFortune());

        context.close();

    }
}
