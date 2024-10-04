package pokemons;

// Импорт библиотек для работы с классом для покемонов
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

// Импорт созданных классов, реализующих движения покемонов
import moves.status.Confide;
import moves.physical.TakeDown;
import moves.physical.CrushClaw;
import moves.physical.FireFang;

// Класс, наследный от класса Pokemon (у покемона нет цепочки эволюции), для реализации покемона Minior
public class Minior extends Pokemon {
    // Конструктор класса Minior
    public Minior(String name, int level) {
        super(name, level); // определение имени и уровня покемона

        // Определение типов покемона
        setType(Type.ROCK, Type.FLYING); // определение типов покемона
        setStats(60, 60, 100, 60, 100, 60); // определение основных характеристик покемона

        // Добавление покемону движений
        addMove(new Confide());
        addMove(new TakeDown());
        addMove(new CrushClaw());
        addMove(new FireFang());
    }
}
