package pack1;

public class TrackCoach implements Coach {
    private FortuneService fs;

    public TrackCoach() {
    }

    public TrackCoach(FortuneService fs) {
        this.fs = fs;
    }

    @Override
    public String getDailyWorkout() {
        return "Track: Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it " + fs.getFortune();
    }

}
