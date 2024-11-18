package classes.animals;

import abstract_classes.AnimalTransport;
import enums.transport_enums.AnimalTypesOfTransport;
import enums.transport_enums.Color;

public class CamelTransport extends AnimalTransport {
    public CamelTransport(Color color) {
        super(color);
        this.animalTypesOfTransport = AnimalTypesOfTransport.CAMEL;
    }
}
