package enums.wedding_participant_enums;

public enum Title {  // Enum-класс для перечисления мужских титулов
    EMPEROR ("Император"),
    KING ("Король"),
    PRINCE ("Принц"),
    DUKE ("Князь"),
    EARL ("Граф"),
    BARON ("Барон"),
    EMPRESS ("Императрица"),
    QUEEN ("Королева"),
    PRINCESS ("Принцесса"),
    DUCHESS ("Княгиня"),
    COUNTESS ("Графиня"),
    BARONESS ("Баронесса");

    private final String title;

    Title(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
