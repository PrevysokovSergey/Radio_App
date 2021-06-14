package RadioEntities.Contents;

public class InterviewContent extends Content{
    public InterviewContent() {
        super();
    }

    public InterviewContent(String name, ContentDuration duration){
        super(name, duration);
    }

    @Override
    public int getPrice() {
        return 30;
    }

    @Override
    public int getTotalPrice() {
        return getPrice() * getDuration().getMinutes();
    }

    public String toString() {
        return "Type: Interview" +
                "\nName: " + getName() +
                "\nDuration: " + getDuration() +
                "\nPrice: " + getPrice() +
                "\nTotal Price: " + getTotalPrice();
    }
}
