package classes.events.wedding_events;

import classes.roles.Guest;
import classes.roles.Newlywed;

import java.util.ArrayList;

// Класс, реализующий начало свадьбы
public class StartOfTheWedding {

    public static void everyoneGreets(Newlywed groom, Newlywed bride, ArrayList<Guest> guests) {
        System.out.print("\nПосле того, как все гости прибыли на свадьбу, в знак своего уважения, каждый из них поздоровался с молодожёнами:\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        GuestsGreet.guestGreet(guests);

        System.out.print("\nВосторженные молодожёны так же поздоровались с гостями:\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        NewlywedGreets.newlywedGreets(groom, bride);

        System.out.print("\nЭти слова ознаменовали начало свадьбы.\n");
    }
}
