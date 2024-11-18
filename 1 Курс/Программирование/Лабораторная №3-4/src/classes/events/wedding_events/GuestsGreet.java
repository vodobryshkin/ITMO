package classes.events.wedding_events;

import classes.roles.Guest;

import java.util.ArrayList;

public class GuestsGreet {

    public static void guestGreet(ArrayList<Guest> guests) {
        for (Guest guest : guests) {
            guest.greet();  // сначала здоровается каждый из гостей
        }
    }
}
