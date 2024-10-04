package moves.physical;

// Импорт библиотек для работы с классом для работы с движениями покемонов
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public class VineWhip extends PhysicalMove{
    // Конструктор класса VineWhip
    public VineWhip() {
        super(Type.GRASS, 45, 100); // определение типа, силы и точности атаки
    }

    // Переопределение метода describe для класса VineWhip
    @Override
    public String describe() {
        return "Использует Vine Whip";
    }
}
