package RadioEntities.Contents;

public abstract class Content {
    private String name;
    private ContentDuration duration;

    public Content(){ }

    public Content(String name, ContentDuration duration) {
        this.name = name;
        this.duration = new ContentDuration(duration);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int getPrice();

    public abstract int getTotalPrice();

    public ContentDuration getDuration() {
        return duration;
    }

    public void setDuration(ContentDuration duration) {
        this.duration = new ContentDuration(duration);
    }

    @Override
    public String toString() {
        return "Type: None" +
                "\nName: " + name +
                "\nDuration: " + duration +
                "\nPrice: " + getPrice() +
                "\nTotal Price: " + getTotalPrice();
    }
}
