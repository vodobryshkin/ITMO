package moves.physical;

// Импорт библиотек для работы с классом для работы с движениями покемонов
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;

public class Nuzzle extends PhysicalMove{
    // Конструктор класса Nuzzle
    public Nuzzle() {
        super(Type.ELECTRIC, 20, 100); // определение типа, силы и точности атаки
    }

    // Переопределение метода applyOppEffects для класса Nuzzle, атакованный покемон парализуется
    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect.paralyze(p); // переход атакованного покемона в состояние паралича
    }

    // Переопределение метода describe для класса Nuzzle
    @Override
    public String describe() {
        return "Использует Nuzzle";
    }
}
