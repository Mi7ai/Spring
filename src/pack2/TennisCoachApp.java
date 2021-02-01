package pack2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TennisCoachApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("file:applicationContextPack2/applicationContext.xml");

        Coach c1 = context.getBean("tennisCoach", Coach.class);

        System.out.println(c1.getDailyWorkout());
//        this print is handled by Spring with annotations and not by the xml file
        System.out.println(c1.getDailyFortune());
        context.close();
    }
}
