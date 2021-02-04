package pack2;

import org.springframework.context.support.ClassPathXmlApplicationContext;
//annotation bean scope
public class TennisCoachApp3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("file:applicationContextPack2/applicationContext.xml");

        Coach c1 = context.getBean("tennisCoach2", Coach.class);

        Coach c2 = context.getBean("tennisCoach2", Coach.class);

        boolean res = c1 == c2;

        System.out.println("Pointin to the same object?: " + res);
        System.out.println(c1);
        System.out.println(c2);
        context.close();
    }
}
