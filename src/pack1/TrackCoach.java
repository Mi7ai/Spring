package pack1;

public class TrackCoach implements Coach {
    private FortuneService fs;
    private final String className;

    public TrackCoach() {
        className = this.getClass().getName();
    }

    public TrackCoach(FortuneService fs) {
        className = this.getClass().getName();
        this.fs = fs;
    }

    @Override
    public String getDailyWorkout() {
        return className +": Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return className +": Just do it " + fs.getFortune();
    }

//    add an init method
    public void startup(){
        System.out.println(className +": inside startup method");
    }
//    add an destroy method
    public void shutdown(){
        System.out.println(className +": inside shutdown method");
    }
}
