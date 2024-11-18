package classes.events.travel_events;

import abstract_classes.AnimalTransport;
import classes.roles.Guest;

public class TravelOfExactGuest {

    public static boolean isThereAnyTroubles(Guest guest, AnimalTransport transport) {
        if (transport.getPotentialReasonsOfIncident().isEmpty()) {
            return false;
        }
        return (Math.random() > 0.8);
    }
}
