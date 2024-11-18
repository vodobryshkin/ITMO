package classes.animals;

import abstract_classes.AnimalTransport;
import enums.transport_enums.AnimalTypesOfTransport;
import enums.transport_enums.Color;
import interfaces.QuicklyDehydrated;

public class HorseTransport extends AnimalTransport implements QuicklyDehydrated {
    public HorseTransport(Color color) {
        super(color);
        this.animalTypesOfTransport = AnimalTypesOfTransport.HORSE;
        this.addPotentialReasonOfIncident(crackCauseOfDehydration());
    }
}