package RadioEntities.Radio;

import RadioEntities.RadioHost.RadioHost;
import RadioEntities.Translations.Translation;

import java.util.ArrayList;
import java.util.List;

public class Radio {
    private final List<RadioHost> radioHostList = new ArrayList<>();
    private final List<Translation> translationList = new ArrayList<>();

    public Radio(){

    }

    public void addRadioHost(RadioHost radioHost){
        radioHostList.add(radioHost);
    }

    public RadioHost getRadioHost(int index){
        return radioHostList.get(index);
    }

    public void removeRadioHost(int index){
        radioHostList.remove(index);
    }

    public int getRadioHostSize(){
        return radioHostList.size();
    }

    public void addTranslation(Translation translation){
        translationList.add(translation);
    }

    public Translation getTranslation(int index){
        return translationList.get(index);
    }

    public void removeTranslation(int index){
        translationList.remove(index);
    }

    public int getTranslationsSize(){
        return translationList.size();
    }

    public int getTotalEarnedMoney(){
        return translationList.stream().mapToInt(Translation::getEarnedMoney).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Radio\n\n");

        sb.append("Radio hosts:\n\n");
        for (int i = 0; i < radioHostList.size(); i++) {
            sb.append(i+1).append(". ").append(radioHostList.get(i)).append("\n\n");
        }

        sb.append("Translations:\n\n");
        for (int i = 0; i < translationList.size(); i++) {
            sb.append(i+1).append(". ").append(translationList.get(i)).append("\n\n");
        }

        sb.append("Total earned money: ").append(getTotalEarnedMoney()).append("\n\n");

        return sb.toString();
    }
}
