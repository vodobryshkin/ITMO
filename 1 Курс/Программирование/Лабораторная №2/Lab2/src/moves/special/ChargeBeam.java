package moves.special;

// Импорт библиотек для работы с классом для работы с движениями покемонов
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class ChargeBeam extends SpecialMove{
    // Конструктор класса ChargeBeam
    public ChargeBeam() {
        super(Type.ELECTRIC, 50, 90); // определение типа, силы и точности атаки
    }

    // Переопределение метода applySelfEffects для класса ChargeBeam, с вероятностью 70% увеличивается SPECIAL_ATTACK
    @Override
    protected void applySelfEffects(Pokemon p) {
        if (Math.random() < 0.7) {
            p.setMod(Stat.SPECIAL_ATTACK, +1); // увеличение SPECIAL_ATTACK на +1
        }
    }

    // Переопределение метода describe для класса ChargeBeam
    @Override
    protected String describe() {
        return "использует Charge Beam";
    }
}
