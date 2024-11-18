package classes.animals;

import abstract_classes.AnimalTransport;
import enums.transport_enums.AnimalTypesOfTransport;
import enums.transport_enums.Color;
import interfaces.QuicklyDehydrated;

public class DonkeyTransport extends AnimalTransport implements QuicklyDehydrated {
    public DonkeyTransport(Color color) {
        super(color);
        this.animalTypesOfTransport = AnimalTypesOfTransport.DONKEY;
        this.addPotentialReasonOfIncident(crackCauseOfDehydration());
    }
}
