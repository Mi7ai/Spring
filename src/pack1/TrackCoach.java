package pack1;

public class TrackCoach implements Coach {
    private FortuneService fs;

    public TrackCoach() {
    }

    public TrackCoach(FortuneService _fs) {
        this.fs = _fs;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it " + fs.getFortune();
    }

}
