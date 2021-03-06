package pack2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//this id for the xml is the name of the class with the first letter lower case.
//this is called implicit bean id
@Component
@Lazy
@Scope("singleton")
public class TennisCoach2 implements Coach {
    final String className;
    //    field injection. no need for setter or constructor injection
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fs;

    public TennisCoach2() {
        className = this.getClass().getName();
        System.out.println(className + ": Implicit bean id constructor");
    }

    @Override
    public String getDailyWorkout() {
        return className + ": Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fs.getFortune();
    }

    //    add an init method
    @PostConstruct
    public void startup(){
        System.out.println(className +": inside startup method");
    }
    //    add an destroy method
    @PreDestroy
    public void shutdown(){
        System.out.println(className +": inside shutdown method");
    }
}


