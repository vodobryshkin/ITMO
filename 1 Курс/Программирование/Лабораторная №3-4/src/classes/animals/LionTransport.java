package classes.animals;

import abstract_classes.AnimalTransport;
import enums.transport_enums.AnimalTypesOfTransport;
import enums.transport_enums.Color;

public class LionTransport extends AnimalTransport {
    public LionTransport(Color color) {
        super(color);
        this.animalTypesOfTransport = AnimalTypesOfTransport.LION;
    }
}
