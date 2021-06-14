package RadioEntities.RadioHost;

public class RadioHost {
    private String name;

    public RadioHost(){

    }

    public RadioHost(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Radio host: " +
                "\nName: " + name;
    }
}
