package pokemons;

// Импорт созданных классов, реализующих движения покемонов
import moves.physical.Slam;

// Класс, наследный от класса Bellsprout (предыдущий покемон в цепочке эволюции), для реализации покемона Weepinbell
public class Weepinbell extends Bellsprout {
    // Конструктор класса Weepinbell
    public Weepinbell(String name, int level) {
        super(name, level); // определение имени и уровня покемона

        setStats(65, 90, 50, 85, 45, 55); // определение основных характеристик покемона

        addMove(new Slam()); // добавление движения для покемона. Остальные движения достанутся от родительского класса
    }
}
