package pack1;

public class CricketCoach implements Coach {
    private FortuneService fs;
    private String email;
    private String team;
    private final String className;

    public CricketCoach() {
        className = this.getClass().getName();
        System.out.println(className + ": inside no-arg constructor");
    }

    public void setFs(FortuneService fs) {
        System.out.println(className + ": inside FortuneService setter");
        this.fs = fs;
    }

    public void setEmail(String email) {
        System.out.println(className + ": inside email setter");
        this.email = email;
    }

    public void setTeam(String team) {
        System.out.println(className + ": inside team setter");
        this.team = team;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
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
