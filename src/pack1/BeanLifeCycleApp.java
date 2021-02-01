package pack1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextBeanLifeCycle.xml");

        Coach c5 = context.getBean("Coach1", Coach.class);

        System.out.println(c5.getDailyWorkout());

        context.close();
    }
}
