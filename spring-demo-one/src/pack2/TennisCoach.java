package pack2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//this is the id from the xml
@Component
@Lazy
@Scope("prototype")
public class TennisCoach implements Coach {
    final String className;
//    if more than one FortuneService is present i specify it with @Qualifier
//    can be used for constructor, setter, field injection
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fs;

    public TennisCoach() {
        className = this.getClass().getName();
        System.out.println(className + ": inside default constructor");
    }
//i can change the method name but keep the annotation
//    @Autowired
//    public void setFs(FortuneService fs) {
//        this.fs = fs;
//        System.out.println(className + ": inside set Fortune service");
//    }
    //this is the constructor injection
//    @Autowired
//    public TennisCoach(FortuneService fs) {
//        className = this.getClass().getName();
//        this.fs = fs;
//    }

    @Override
    public String getDailyWorkout() {
        return className + ": Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fs.getFortune();
    }
}
