package pokemons;

// Импорт библиотек для работы с классом для покемонов
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

// Импорт созданных классов, реализующих движения покемонов
import moves.special.ChargeBeam;
import moves.status.Flatter;
import moves.status.SweetKiss;
import moves.physical.Nuzzle;

// Класс, наследный от класса Pokemon (у покемона нет цепочки эволюции), для реализации покемона Pachirisu
public class Pachirisu extends Pokemon {
    // Конструктор класса Pachirisu
    public Pachirisu(String name, int level) {
        super(name, level); // определение имени и уровня покемона

        addType(Type.ELECTRIC); // определение типа покемона
        setStats(60, 45, 70, 45, 90, 95); // определение основных характеристик покемона

        // Добавление покемону движений
        addMove(new ChargeBeam());
        addMove(new Flatter());
        addMove(new SweetKiss());
        addMove(new Nuzzle());
    }
}
