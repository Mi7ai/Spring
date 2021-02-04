package pack1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeCoachApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("file:applicationContextPack1/applicationContextScope.xml");
//        two different instances of coach
        Coach c3 = context.getBean("Coach1", Coach.class);

        Coach c4 = context.getBean("Coach1", Coach.class);

        boolean res = c3 == c4;
        System.out.println(res);
        System.out.println("Memory location c3"+ c3);
        System.out.println("Memory location c4"+ c4);
        
        context.close();
    }
}
