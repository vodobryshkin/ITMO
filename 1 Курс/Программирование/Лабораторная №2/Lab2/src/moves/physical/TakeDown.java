package moves.physical;

// Импорт библиотек для работы с классом для работы с движениями покемонов
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Pokemon;

public class TakeDown extends PhysicalMove{
    // Конструктор класса TakeDown
    public TakeDown() {
        super(Type.NORMAL, 90, 85); // определение типа, силы и точности атаки
    }

    // Переопределение метода applySelfEffects для класса TakeDown, атакующий покемон получит 25 % от нанесенного урона
    @Override
    protected void applySelfEffects(Pokemon p) {
        applySelfDamage(p, p.getStat(Stat.ATTACK) / 4);
    }

    // Переопределение метода describe для класса TakeDown
    @Override
    public String describe() {
        return "Использует Take Down";
    }
}
