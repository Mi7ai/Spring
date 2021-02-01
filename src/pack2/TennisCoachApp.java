package pack2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TennisCoachApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("file:applicationContextPack2/applicationContext.xml");

        Coach c1 = context.getBean("tennisCoach", Coach.class);

        System.out.println(c1.getDailyWorkout());

        context.close();
    }
}
