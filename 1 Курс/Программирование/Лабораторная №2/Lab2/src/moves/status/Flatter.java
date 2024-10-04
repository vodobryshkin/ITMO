package moves.status;

// Импорт библиотек для работы с классом для работы с движениями покемонов
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;

public class Flatter extends StatusMove {
    // Конструктор класса Flatter
    public Flatter() {
        super(Type.DARK, 0, 100); // определение типа, силы и точности атаки
    }

    // Переопределение метода applyOppEffects для класса Flatter, атакованный покемон входит в состояние смятения и его
    // SPECIAL_ATTACK увеличивается на +1
    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect.confuse(p); // переход атакованного покемона в состояние смятения
        p.setMod(Stat.SPECIAL_ATTACK, +1); // увеличение SPECIAL_ATTACK на +1
    }

    // Переопределение метода describe для класса Flatter
    @Override
    protected String describe() {
        return "использует Flatter";
    }
}
