package pokemons;

// Импорт созданных классов, реализующих движения покемонов
import moves.physical.VineWhip;

// Класс, наследный от класса Weepinbell (предыдущий покемон в цепочке эволюции), для реализации покемона Victreebel
public class Victreebel extends Weepinbell {
    // Конструктор класса Victreebel
    public Victreebel(String name, int level) {
        super(name, level); // определение имени и уровня покемона

        setStats(80, 105, 65, 100, 70, 70); // определение основных характеристик покемона

        addMove(new VineWhip()); // добавление движения для покемона. Остальные движения достанутся от родительского класса
    }
}
