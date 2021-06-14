package RadioEntities.Contents;

public class ContentDuration implements Comparable<ContentDuration>{
    private int minutes;
    private int seconds;

    public ContentDuration(){}

    public ContentDuration(int minutes, int seconds) {

    }

    public ContentDuration(ContentDuration contentDuration) {
        this.minutes = contentDuration.minutes;
        this.seconds = contentDuration.seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if(minutes >= 0)
            this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        if(seconds >= 0 && seconds < 60)
            this.seconds = seconds;
    }

    public int getTotalSeconds(){
        return minutes * 60 + seconds;
    }

    public void add(ContentDuration o){
        minutes += o.minutes;
        seconds += o.seconds;

        if(seconds >= 60){
            minutes++;
            seconds -= 60;
        }
    }

    public void diff(ContentDuration o){
        minutes -= o.minutes;
        seconds -= o.seconds;

        if(seconds < 0){
            minutes--;
            seconds += 60;
        }
    }

    public static ContentDuration add(ContentDuration o1, ContentDuration o2){
        ContentDuration result = new ContentDuration(o1);

        result.minutes += o2.minutes;
        result.seconds += o2.seconds;

        if(result.seconds >= 60){
            result.minutes++;
            result.seconds -= 60;
        }

        return result;
    }

    public static ContentDuration diff(ContentDuration o1, ContentDuration o2){
        ContentDuration result = new ContentDuration(o1);

        result.minutes -= o2.minutes;
        result.seconds -= o2.seconds;

        if(result.seconds < 0){
            result.minutes--;
            result.seconds += 60;
        }

        return result;
    }

    @Override
    public String toString() {
        return String.format("%d:%02d", minutes, seconds);
    }

    @Override
    public int compareTo(ContentDuration o) {
        if(minutes != o.minutes)
            return Integer.compare(minutes, o.minutes);
        return Integer.compare(seconds, o.seconds);

    }
}
