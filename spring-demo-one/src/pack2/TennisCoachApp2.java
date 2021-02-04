package pack2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TennisCoachApp2 {
    public static void main(String[] args) {
//        i can use the same xml application for the component
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("file:applicationContextPack2/applicationContext.xml");

        Coach c1 = context.getBean("tennisCoach2", Coach.class);

        System.out.println(c1.getDailyWorkout());

        context.close();
    }
}
