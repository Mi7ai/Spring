package pack1;

public class CricketCoach implements Coach{
    private FortuneService fs;

    public CricketCoach() {
        System.out.println("CricketCoach: inside no-arg constructor");
    }

    public void setFs(FortuneService fs) {
        System.out.println("CricketCoach: inside FortuneService setter");
        this.fs = fs;
    }

    @Override
    public String getDailyWorkout() {
        return "Cricket: Practice for 15 min";
    }

    @Override
    public String getDailyFortune() {
        return fs.getFortune();
    }
}
