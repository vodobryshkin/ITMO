package moves.status;

// Импорт библиотек для работы с классом для работы с движениями покемонов
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;

public class Swagger extends StatusMove {
    // Конструктор класса Swagger
    public Swagger() {
        super(Type.NORMAL, 0, 85); // определение типа, силы и точности атаки
    }

    // Переопределение метода applyOppEffects для класса Swagger, атакованный покемон входит в состояние смятения и его
    // ATTACK увеличивается на +2
    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect.confuse(p); // переход атакованного покемона в состояние смятения
        p.setMod(Stat.ATTACK, +2); // увеличение ATTACK на +2
    }

    // Переопределение метода describe для класса Swagger
    @Override
    protected String describe() {
        return "использует Swagger";
    }
}
