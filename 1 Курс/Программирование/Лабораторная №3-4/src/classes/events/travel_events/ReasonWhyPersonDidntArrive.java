package classes.events.travel_events;

import abstract_classes.AnimalTransport;

public class ReasonWhyPersonDidntArrive {
    public static Record findOutTheReason(AnimalTransport transport) {
        return transport.getPotentialReasonsOfIncident().get((int) Math.random() * transport.getPotentialReasonsOfIncident().size());
    }
}
