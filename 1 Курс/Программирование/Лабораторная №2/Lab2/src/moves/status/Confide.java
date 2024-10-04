package moves.status;

// Импорт библиотек для работы с классом для работы с движениями покемонов
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;

public class Confide extends StatusMove {
    // Конструктор класса Confide
    public Confide() {
        super(Type.NORMAL, 0, 0); // определение типа, силы и точности атаки
    }

    // Переопределение метода applyOppEffects для класса Confide, у атакованного покемона SPECIAL_ATTACK уменьшается на -1
    @Override
    protected void applyOppEffects(Pokemon p) {
        p.setMod(Stat.SPECIAL_ATTACK, -1); // уменьшение SPECIAL_ATTACK на -1
    }

    // Переопределение метода describe для класса Confide
    @Override
    protected String describe() {
        return "использует Confide";
    }
}
