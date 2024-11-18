package enums.wedding_participant_enums;

public enum Citizenship {  // Enum-класс для перечисления мужских титулов
    GLIMMERING_REALM ("Сияющее королевство"),
    MYSTIC_WOODLAND ("Мистический лес"),
    CRYSTAL_CAVERN ("Кристальная пещера"),
    SHADOWFALL_EMPIRE ("Империя Теней"),
    SUNSET_ISLE ("Остров Заката"),
    FROSTFIRE_KINGDOM ("Королевство Ледяного Огня"),
    WHISPERING_MOUNTAINS ("Шепчущие Горы"),
    ENCHANTED_GROVE ("Зачарованный Лес"),
    STARDUST_VALE ("Долина Звездной Пыли"),
    ELDERTREE_REALM ("Королевство Древних Деревьев"),
    RAINBOW_REACH ("Радужный Уголок"),
    SILVERSTREAM_LAND ("Земля Серебряного Потока");

    private final String citizenship;

    Citizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getCitizenship() {
        return citizenship;
    }
}
