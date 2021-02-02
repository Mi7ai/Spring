package pack2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TennisCoachApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("file:applicationContextPack2/applicationContext.xml");
//        i use lazy in the classes so that Spring only initializes my desired component class  with specific id
        Coach c1 = context.getBean("tennisCoach2", Coach.class);

        System.out.println(c1.getDailyWorkout());
//        this print is handled by Spring with annotations and not by the xml file
        System.out.println(c1.getDailyFortune());

        context.close();
    }
}
