package pack2;

import org.springframework.stereotype.Component;

//this is the id from the xml
@Component("tennisCoach")
public class TennisCoach implements Coach {
    final String className;

    public TennisCoach() {
        className = this.getClass().getName();
    }

    @Override
    public String getDailyWorkout() {
        return className + ": Practice your backhand volley";
    }
}
