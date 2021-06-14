package RadioEntities.Contents;

public class AdvertisingContent extends Content{
    public AdvertisingContent() {
        super();
    }

    public AdvertisingContent(String name, ContentDuration duration){
        super(name, duration);
    }

    @Override
    public int getPrice() {
        return 5;
    }

    @Override
    public int getTotalPrice() {
        return getPrice() * getDuration().getTotalSeconds();
    }

    public String toString() {
        return "Type: Advertising" +
                "\nName: " + getName() +
                "\nDuration: " + getDuration() +
                "\nPrice: " + getPrice() +
                "\nTotal Price: " + getTotalPrice();
    }

}
