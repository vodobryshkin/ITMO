package classes.generators;

import abstract_classes.AnimalTransport;
import classes.animals.*;
import enums.transport_enums.Color;

public class GenerateRandomTransport {

    public static AnimalTransport generateTransport() {
        Color[] colors = {
                Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.LIGHT_BLUE,
                Color.BLUE, Color.PURPLE, Color.BLACK, Color.WHITE, Color.GOLDEN
        };

        Color color = colors[(int) (Math.random() * 10)];

        AnimalTransport[] animalTransports = {
                new LionTransport(color), new DogsTransport(color), new DonkeyTransport(color), new HorseTransport(color),
                new ElephantTransport(color), new DeerTransport(color), new CamelTransport(color)
        };

        return animalTransports[(int) (Math.random() * 7)];
    }

}
