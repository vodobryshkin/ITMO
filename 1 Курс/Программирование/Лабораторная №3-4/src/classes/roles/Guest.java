package classes.roles;

import abstract_classes.WeddingParticipant;
import enums.wedding_participant_enums.Citizenship;
import enums.wedding_participant_enums.Gender;
import enums.wedding_participant_enums.Title;

public class Guest extends WeddingParticipant {
    public Guest(String name, Gender gender, Title title, Citizenship citizenship) {
        super(name, gender, title, citizenship);
    }

    public void greet() {  // Переопредление метода приветствия для гостя
        System.out.printf("- Здравствуйте. Я - %s. Для меня большая честь пристутствовать на свадьбе.\n", this.toString());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
