package enums.transport_enums;

public enum Color {
    RED ("красного цвета"),
    ORANGE ("оранжевого цвета"),
    YELLOW ("жёлтого цвета"),
    GREEN ("зелёного цвета"),
    LIGHT_BLUE ("голубого цвета"),
    BLUE ("синего цвета"),
    PURPLE ("фиолетового цвета"),
    BLACK ("чёрного цвета"),
    WHITE ("белого цвета"),
    GOLDEN ("золотого цвета");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
