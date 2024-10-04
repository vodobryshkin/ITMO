import ru.ifmo.se.pokemon.*;
import pokemons.*;

public class Main {
    // Именя покемонов взяты с https://www.fantasynamegenerators.com/pokemon-names.php
    public static void main(String[] args) {
        Battle b = new Battle(); // создание битвы

        // Создание покемонов для битвы
        Pokemon electriboon = new Pachirisu("Electriboon", 29);
        Pokemon hyetuff = new Silvally("Hyetuff", 50);
        Pokemon lobstia = new Minior("Lobstia", 29);
        Pokemon rappazar = new Bellsprout("Rappazar", 1);
        Pokemon chimpazar = new Weepinbell("Chimpazar", 54);
        Pokemon ultrapazar = new Victreebel("Ultrapazar", 66);

        // Добавление покемонов разных семейств в первую команду
        b.addAlly(electriboon);
        b.addAlly(hyetuff);
        b.addAlly(lobstia);

        // Добавление покемонов с наследными классами во вторую команду
        b.addFoe(rappazar);
        b.addFoe(chimpazar);
        b.addFoe(ultrapazar);

        b.go(); // запуск битвы
    }
}
