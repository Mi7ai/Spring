package pack1;

public class BaseballCoach implements Coach {
    private FortuneService fs;

    public BaseballCoach(FortuneService fs) {
        this.fs = fs;
    }

    @Override
    public String getDailyWorkout() {
        return "Baseball: Spend 30 min";
    }

    @Override
    public String getDailyFortune() {
        return fs.getFortune();
    }


}
