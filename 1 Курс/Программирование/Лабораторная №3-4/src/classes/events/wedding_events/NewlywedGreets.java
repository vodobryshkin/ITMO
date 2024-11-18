package classes.events.wedding_events;

import classes.roles.Newlywed;

public class NewlywedGreets {
    public static void newlywedGreets(Newlywed groom, Newlywed bride) {
        groom.greet();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        bride.greet();
    }
}
