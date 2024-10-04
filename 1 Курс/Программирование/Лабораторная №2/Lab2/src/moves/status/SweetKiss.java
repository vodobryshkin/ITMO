package moves.status;

// Импорт библиотек для работы с классом для работы с движениями покемонов
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;

public class SweetKiss extends StatusMove {
    // Конструктор класса SweetKiss
    public SweetKiss() {
        super(Type.FAIRY, 0, 75); // определение типа, силы и точности атаки
    }

    // Переопределение метода applyOppEffects для класса SweetKiss, атакованный покемон переходит в состояние смятения
    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect.confuse(p); // переход атакованного покемона в состояние смятения
    }

    // Переопределение метода describe для класса SweetKiss
    @Override
    protected String describe() {
        return "использует Sweet Kiss";
    }
}
