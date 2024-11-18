package classes.roles;

import abstract_classes.WeddingParticipant;
import classes.items.*;
import enums.wedding_participant_enums.Citizenship;
import enums.wedding_participant_enums.Gender;
import enums.wedding_participant_enums.Title;

public class Newlywed extends WeddingParticipant {
    public Newlywed(String name, Gender gender, Title title, Citizenship citizenship) {
        super(name, gender, title, citizenship);
    }

    public void greet() {  // Переопредление метода приветствия для гостя
        System.out.printf("- Здравствуйте. Я - %s. Спасибо всем, что пришли на свадьбу.\n", this.toString());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Метод подготовки молодожёном приглашения на свадьбу
    public Invitation prepareWeddingInvitation() {  // Присылание гостя на свадьбу
        double probability = Math.random();

        // С определённой вероятностью молодожён пришлёт приглашение разной престижности
        if (probability > 0.9) {
            return new PrestigeInvitation();
        } else if (probability > 0.8) {
            return new RespectedInvitation();
        } else if (probability > 0.7) {
            return new OrdinaryInvitation();
        } else if (probability > 0.5) {
            return new EliteInvitation();
        } else if (probability > 0.2) {
            return new MediocreInvitation();
        }
        return new ShoddyInvitation();
    }
}
