package Driver;

import RadioEntities.Contents.*;
import RadioEntities.Radio.Radio;
import RadioEntities.RadioHost.InvitedRadioHost;
import RadioEntities.RadioHost.LocalRadioHost;
import RadioEntities.RadioHost.RadioHost;
import RadioEntities.Translations.Translation;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Radio radio = new Radio();
        int menu;

        do{
            System.out.println("Menu:\n");
            System.out.println("1. Print all information");
            System.out.println("2. Add translation");
            System.out.println("3. Add radio host");
            System.out.println("4. Add content");
            System.out.print("0. Exit\n\n > ");
            menu = scanner.nextInt();

            System.out.println("\n");

            switch (menu){
                case 1:
                    System.out.println(radio);
                    break;
                case 2:
                    Translation translation = createTranslation();
                    radio.addTranslation(translation);
                    break;
                case 3:
                    RadioHost radioHost = createRadioHost();
                    radio.addRadioHost(radioHost);
                    break;
                case 4:
                    try{
                        System.out.print("Choose translation index > ");
                        int index = scanner.nextInt();

                        Translation t = radio.getTranslation(index-1);
                        Content content = createContent();

                        t.addContent(content);
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }

            System.out.println("\n");

        }while (menu != 0);
    }

    public static Translation createTranslation(){
        Translation translation = new Translation();
        ContentDuration duration = new ContentDuration();

        try{
            System.out.print("Duration minutes > ");
            duration.setMinutes(scanner.nextInt());

            System.out.print("Duration seconds > ");
            duration.setSeconds(scanner.nextInt());

            translation.setDuration(duration);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return translation;
    }

    public static RadioHost createRadioHost(){
        System.out.println("Choose radio host type:\n");

        System.out.println("1) Local radio host");
        System.out.println("2) Invited radio host");

        System.out.print(" > ");
        int choose = scanner.nextInt();

        if(choose == 1){
            LocalRadioHost radioHost = new LocalRadioHost();

            System.out.print("Name > ");
            scanner.nextLine();
            radioHost.setName(scanner.nextLine());

            System.out.print("Experience > ");
            radioHost.setExperience(scanner.nextInt());

            System.out.print("Number of programs > ");
            int programs = scanner.nextInt();

            scanner.nextLine();
            System.out.println("\nInput programs names:");
            for(int i=0;i<programs;i++) {
                System.out.print((i+1) + " > ");
                radioHost.addProgram(scanner.nextLine());
            }

            return radioHost;
        }
        else{
            InvitedRadioHost radioHost = new InvitedRadioHost();

            System.out.print("Name > ");
            scanner.nextLine();
            radioHost.setName(scanner.nextLine());

            System.out.print("Resume > ");
            radioHost.setResume(scanner.nextLine());

            return radioHost;
        }
    }

    public static Content createContent(){
        ContentDuration duration = new ContentDuration();

        System.out.println("Choose content type:\n");

        System.out.println("1) Song content");
        System.out.println("2) Advertising content");
        System.out.println("3) Interview content");

        System.out.print(" > ");
        int choose = scanner.nextInt();

        if(choose == 1){
            SongContent content = new SongContent();

            System.out.print("Name > ");
            scanner.nextLine();
            content.setName(scanner.nextLine());

            System.out.print("Singer > ");
            content.setSinger(scanner.nextLine());

            System.out.print("Duration minutes > ");
            duration.setMinutes(scanner.nextInt());

            System.out.print("Duration seconds > ");
            duration.setSeconds(scanner.nextInt());

            content.setDuration(duration);

            return content;
        }
        else if(choose == 2){
            AdvertisingContent content = new AdvertisingContent();

            System.out.print("Name > ");
            scanner.nextLine();
            content.setName(scanner.nextLine());


            System.out.print("Duration minutes > ");
            duration.setMinutes(scanner.nextInt());

            System.out.print("Duration seconds > ");
            duration.setSeconds(scanner.nextInt());

            content.setDuration(duration);

            return content;
        }
        else {
            InterviewContent content = new InterviewContent();

            System.out.print("Name > ");
            scanner.nextLine();
            content.setName(scanner.nextLine());

            System.out.print("Duration minutes > ");
            duration.setMinutes(scanner.nextInt());

            System.out.print("Duration seconds > ");
            duration.setSeconds(scanner.nextInt());

            content.setDuration(duration);

            return content;
        }
    }
}
