package moves.physical;

// Импорт библиотек для работы с классом для работы с движениями покемонов
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;

public class FireFang extends PhysicalMove{
    // Конструктор класса FireFang
    public FireFang() {
        super(Type.FIRE, 65, 95); // определение типа, силы и точности атаки
    }

    // Переопределение метода applyOppEffects для класса FireFang, атакованный покемон c 10% шансом поджигается и имеет
    // 10% шанс вздрогнуть, если атакованный покемон еще не двигался
    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() < 0.1) {
            Effect.burn(p); // применение эффекта поджигания на атакованного покемона
        }
        if (Math.random() < 0.1) {
            Effect.flinch(p); // применение эффекта вздрагивания на атакованного покемона
        }
    }

    // Переопределение метода describe для класса FireFang
    @Override
    public String describe() {
        return "Использует Fire Fang";
    }
}
