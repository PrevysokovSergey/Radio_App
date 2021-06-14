package RadioEntities.RadioHost;

public class InvitedRadioHost extends RadioHost{
    private String resume;

    public InvitedRadioHost(){
        super();
    }

    public InvitedRadioHost(String name, String resume){
        super(name);
        this.resume = resume;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "Invited radio host:" +
                "\nName: " + getName() +
                "\nResume: " + getResume();
    }
}
