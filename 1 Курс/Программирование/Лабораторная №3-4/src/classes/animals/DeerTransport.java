package classes.animals;

import abstract_classes.AnimalTransport;
import enums.transport_enums.AnimalTypesOfTransport;
import enums.transport_enums.Color;
import interfaces.QuicklyDehydrated;
import interfaces.QuicklyHungry;

public class DeerTransport extends AnimalTransport implements QuicklyDehydrated, QuicklyHungry {
    public DeerTransport(Color color) {
        super(color);
        this.animalTypesOfTransport = AnimalTypesOfTransport.DEER;
        this.addPotentialReasonOfIncident(crackCauseOfDehydration());
        this.addPotentialReasonOfIncident(crackCauseOfHunger());
    }
}
