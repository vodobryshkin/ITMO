package moves.physical;

// Импорт библиотек для работы с классом для работы с движениями покемонов
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public class Slam extends PhysicalMove{
    // Конструктор класса Slam
    public Slam() {
        super(Type.NORMAL, 80, 75); // определение типа, силы и точности атаки
    }

    // Переопределение метода describe для класса Slam
    @Override
    public String describe() {
        return "Использует Slam";
    }
}
