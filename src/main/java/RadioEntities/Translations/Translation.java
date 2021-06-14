package RadioEntities.Translations;

import RadioEntities.Contents.Content;
import RadioEntities.Contents.ContentDuration;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Translation {
    private final List<Content> contents = new ArrayList<>();;
    private final ContentDuration duration;
    private final ContentDuration busyTime;

    public Translation(){
        duration = new ContentDuration(60,0);
        busyTime = new ContentDuration();
    }

    public Translation(ContentDuration duration){
        this.duration = new ContentDuration(duration);
        busyTime = new ContentDuration();
    }

    public ContentDuration getDuration() {
        return duration;
    }

    public ContentDuration getBusyTime() {
        return busyTime;
    }

    public void setDuration(ContentDuration o){
        duration.setMinutes(o.getMinutes());
        duration.setSeconds(o.getSeconds());
    }

    public int getEarnedMoney() {
        return contents.stream().mapToInt(Content::getTotalPrice).sum();
    }

    public ContentDuration getPaidContentDuration(){
        try {
            return contents.stream().filter(x -> x.getPrice() > 0).map(Content::getDuration).
                    reduce((x, y) -> ContentDuration.add(x, y)).get();
        }
        catch(NoSuchElementException e){
            return new ContentDuration();
        }
    }

    public void addContent(Content content){
        ContentDuration newTime = ContentDuration.add(content.getDuration(), busyTime);

        if(content.getPrice() > 0) {
            ContentDuration newPaidTime = ContentDuration.add(content.getDuration(), getPaidContentDuration());

            if(duration.getTotalSeconds() / 2 < newPaidTime.getSeconds())
                throw new TranslationOverflowException("Paid content time more than 50%");
        }

        if(newTime.compareTo(duration) > 0){
            throw new TranslationOverflowException("Overflow of translation`s duration");
        }

        contents.add(content);
        busyTime.add(content.getDuration());
    }

    public Content get(int index){
        return contents.get(index);
    }

    public void remove(int index){
        if(index >= 0 && index < contents.size())
            contents.remove(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Translation:\n\n");

        sb.append("Duration: ").append(duration).append("\n");
        sb.append("Busy time: ").append(busyTime).append("\n");
        sb.append("Earned money: ").append(getEarnedMoney()).append("\n\n");

        sb.append("Content:\n\n");
        for (int i = 0; i < contents.size(); i++) {
            sb.append(i+1).append(". ").append(contents.get(i)).append("\n\n");
        }

        return sb.toString();
    }
}
