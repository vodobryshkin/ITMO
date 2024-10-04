package moves.status;

// Импорт библиотек для работы с классом для работы с движениями покемонов
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Pokemon;

public class DoubleTeam extends StatusMove {
    // Конструктор класса DoubleTeam
    public DoubleTeam() {
        super(Type.NORMAL, 0, 0); // определение типа, силы и точности атаки
    }

    // Переопределение метода applySelfEffects для класса DoubleTeam, У атакующего покемона повышается EVASION на +1
    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.EVASION, +1); // переход атакованного покемона в состояние смятения
    }

    // Переопределение метода describe для класса DoubleTeam
    @Override
    protected String describe() {
        return "использует Double Team";
    }
}
