package classes.animals;

import abstract_classes.AnimalTransport;
import enums.transport_enums.AnimalTypesOfTransport;
import enums.transport_enums.Color;
import interfaces.QuicklyTiring;

public class ElephantTransport extends AnimalTransport implements QuicklyTiring {
    public ElephantTransport(Color color) {
        super(color);
        this.animalTypesOfTransport = AnimalTypesOfTransport.ELEPHANT;
        this.addPotentialReasonOfIncident(crackCauseOfTired());
    }
}
