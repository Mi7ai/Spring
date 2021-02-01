package pack1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterCoachApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        by accesing CricketCoach.class i have access to the class methods and interface method
//        meanwhile if i put Coach.class i have access only yo the interface methods
        CricketCoach c1 = context.getBean("Coach2", CricketCoach.class);

        System.out.println(c1.getDailyWorkout());
        System.out.println(c1.getDailyFortune());

//        hardcoded injected values from xml file
//        System.out.println(c1.getEmail());
//        System.out.println(c1.getTeam());

        context.close();

    }
}
