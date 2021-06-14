package RadioEntities.Contents;

public class SongContent extends Content{
    private String singer;

    public SongContent(){
        super();
    }

    public SongContent(String singer, String name, ContentDuration duration){
        super(name, duration);
        this.singer = singer;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public int getTotalPrice() {
        return 0;
    }

    @Override
    public String toString() {
        return "Type: Song" +
                "\nSinger: " + getSinger() +
                "\nName: " + getName() +
                "\nDuration: " + getDuration();
    }
}
