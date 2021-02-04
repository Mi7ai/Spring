package pack2;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {
    private String[] data = {
            "Fuck me I am famous",
            "Don't be afraid",
            "Keep it neat"
    };
    private Random r = new Random();
    final String className;

    public RandomFortuneService() {
        className = this.getClass().getName();
        System.out.println(className + ": Implicit constructor");
    }

    @Override
    public String getFortune() {
        int i = r.nextInt(data.length);
        return data[i];
    }
}
