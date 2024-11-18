package classes.events.travel_events;

import abstract_classes.AnimalTransport;
import classes.roles.Guest;

public class GuestsTravel {
    public static boolean isGuestCame(Guest guest, AnimalTransport transport) {
        System.out.printf("Гость %s выехал на свадьбу на %s.%n", guest.toString(), transport.toString());
        try {
            Thread.sleep(1250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (!TravelOfExactGuest.isThereAnyTroubles(guest, transport)) {
            System.out.printf("Гость %s прибыл на свадьбу без происшествий.%n%n", guest.toString());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return true;
        } else {
            System.out.printf("Гость %s не смог приехать на свадьбу из-за того, что его животное %s.%n%n", guest.toString(), ReasonWhyPersonDidntArrive.findOutTheReason(transport).toString());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return false;
        }
    }
}
