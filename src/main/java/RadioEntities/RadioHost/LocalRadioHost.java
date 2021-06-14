package RadioEntities.RadioHost;

import java.util.ArrayList;
import java.util.List;

public class LocalRadioHost extends RadioHost{
    private int experience;
    private final List<String> programsList = new ArrayList<>();

    public LocalRadioHost(){
        super();
    }

    public LocalRadioHost(String name, int experience){
        super(name);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void addProgram(String program){
        programsList.add(program);
    }

    @Override
    public String toString() {
        return "Local radio host:" +
                "\nName: " + getName() +
                "\nExperience: " + getExperience() +
                "\nPrograms: " + programsList;
    }
}
