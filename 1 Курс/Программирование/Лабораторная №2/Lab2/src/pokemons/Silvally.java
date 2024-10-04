package pokemons;

// Импорт библиотек для работы с классом для покемонов
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

// Импорт созданных классов, реализующих движения покемонов
import moves.status.Confide;
import moves.physical.TakeDown;
import moves.physical.CrushClaw;

// Класс, наследный от класса TypeNull (ввиду эволюции покемонов), для реализации покемона Silvally
public class Silvally extends Pokemon {
    // Конструктор класса Silvally
    public Silvally(String name, int level) {
        super(name, level); // определение имени и уровня покемона

        setType(Type.NORMAL); // определение типа покемона
        setStats(95, 95, 95, 95, 95, 95); // определение основных характеристик покемона

        // Добавление покемону движений
        addMove(new Confide());
        addMove(new TakeDown());
        addMove(new CrushClaw());
    }
}
