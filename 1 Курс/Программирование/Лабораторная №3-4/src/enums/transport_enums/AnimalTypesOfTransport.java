package enums.transport_enums;

public enum AnimalTypesOfTransport {
    DOGS ("упряжке с собаками"),
    DONKEY ("осле"),
    HORSE ("лошади"),
    LION ("льве"),
    ELEPHANT ("слоне"),
    CAMEL ("верблюде"),
    DEER ("упряжке с оленями");

    private final String type;

    AnimalTypesOfTransport(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
