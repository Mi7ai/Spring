package pack2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//this is the id from the xml
@Component("tennisCoach")
public class TennisCoach implements Coach {
    final String className;
    private FortuneService fs;

    @Autowired
    public TennisCoach(FortuneService fs) {
        className = this.getClass().getName();
        this.fs = fs;
    }

    @Override
    public String getDailyWorkout() {
        return className + ": Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fs.getFortune();
    }
}
