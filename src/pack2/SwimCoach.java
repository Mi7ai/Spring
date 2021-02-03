package pack2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//property file injection
@Component
public class SwimCoach implements Coach {
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fs;
    final String className;

    @Value("${sport.email}")
    private String email;


    @Value("${sport.team}")
    private String team;


    public SwimCoach() {
        this.className = this.getClass().getName();
        System.out.println(className + ": inside default constructor");
    }

    @Override
    public String getDailyWorkout() {
        return className + ": You have swum 30 min";
    }

    @Override
    public String getDailyFortune() {
        return fs.getFortune();
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }
}
