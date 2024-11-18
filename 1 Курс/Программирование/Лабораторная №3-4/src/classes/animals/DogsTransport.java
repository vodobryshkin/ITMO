package classes.animals;

import abstract_classes.AnimalTransport;
import enums.transport_enums.AnimalTypesOfTransport;
import enums.transport_enums.Color;
import interfaces.QuicklyTiring;

public class DogsTransport extends AnimalTransport implements QuicklyTiring {
    public DogsTransport(Color color) {
        super(color);
        this.animalTypesOfTransport = AnimalTypesOfTransport.DOGS;
        this.addPotentialReasonOfIncident(crackCauseOfTired());
    }
}
