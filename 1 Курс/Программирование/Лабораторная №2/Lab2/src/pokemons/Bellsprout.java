package pokemons;

// Импорт библиотек для работы с классом для покемонов
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

// Импорт созданных классов, реализующих движения покемонов
import moves.status.DoubleTeam;
import moves.status.Swagger;

// Класс, наследный от класса Pokemon (цепочка эволюции начинается с этого вида), для реализации покемона Bellsprout
public class Bellsprout extends Pokemon {
    // Конструктор класса Bellsprout
    public Bellsprout(String name, int level) {
        super(name, level); // определение имени и уровня покемона

        setType(Type.GRASS, Type.POISON); // определение типов покемона
        setStats(50, 75, 35, 70, 30, 40); // определение основных характеристик покемона

        // Добавление покемону движений
        addMove(new Swagger());
        addMove(new DoubleTeam());
    }
}
