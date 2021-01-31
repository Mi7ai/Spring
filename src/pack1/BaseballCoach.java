package pack1;

public class BaseballCoach implements Coach {
    private FortuneService fs;

    public BaseballCoach(FortuneService _fs) {
        this.fs = _fs;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 min";
    }

    @Override
    public String getDailyFortune() {
        return fs.getFortune();
    }


}
