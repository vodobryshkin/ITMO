import classes.events.Wedding;
import classes.roles.Newlywed;
import enums.wedding_participant_enums.Citizenship;
import enums.wedding_participant_enums.Gender;
import enums.wedding_participant_enums.Title;


public class Main {
    public static void main(String[] args) {
        Newlywed g1 = new Newlywed("Стивен", Gender.MALE, Title.PRINCE, Citizenship.ENCHANTED_GROVE);
        Newlywed g2 = new Newlywed("Ослиная Шкура", Gender.FEMALE, Title.PRINCESS, Citizenship.MYSTIC_WOODLAND);
        int numberOfGuests = 10;

        Wedding wedding = new Wedding(g1, g2, numberOfGuests);
        wedding.HoldAWedding();
    }
}