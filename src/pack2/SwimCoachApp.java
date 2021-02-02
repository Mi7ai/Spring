package pack2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimCoachApp {
    public static void main(String[] args) {
//        i can use the same xml application for the component
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("file:applicationContextPack2/applicationContext.xml");

        SwimCoach c1 = context.getBean("swimCoach", SwimCoach.class);

        System.out.println(c1.getDailyWorkout());
        System.out.println(c1.getDailyFortune());

        System.out.println(c1.getEmail());
        System.out.println(c1.getTeam());
        context.close();
    }
}
