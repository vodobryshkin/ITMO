package moves.physical;

// Импорт библиотек для работы с классом для работы с движениями покемонов
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Pokemon;

public class CrushClaw extends PhysicalMove{
    // Конструктор класса TakeDown
    public CrushClaw() {
        super(Type.NORMAL, 75, 95); // определение типа, силы и точности атаки
    }

    // Переопределение метода applySelfEffects для класса CrushClaw, обороняющийся покемон получает -1 к DEFENCE
    // с шансом 50 %
    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() < 0.5) {
            p.setMod(Stat.DEFENSE, -1); // уменьшение DEFENCE на -1
        }
    }

    // Переопределение метода describe для класса CrushClaw
    @Override
    public String describe() {
        return "Использует Crush Claw";
    }
}
