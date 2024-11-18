package enums.invitation_enums;

public enum PrestigeOfInvitation {  // Enum-класс для перечисления уровня престижа приглашения на свадьбу
    PRESTIGIOUS (1, "престижное"),
    ELITE (0.85, "элитное"),
    RESPECTED (0.75, "хорошее"),
    ORDINARY(0.6, "обычное"),
    MEDIOCRE(0.3, "посредственное"),
    SHODDY(0.1, "ужасное");

    private final double probabilityForPersonToReceive;
    private final String descriptionOfTheInvitation;

    PrestigeOfInvitation(double probabilityForPersonToReceive, String descriptionOfTheInvitation) {
        this.probabilityForPersonToReceive = probabilityForPersonToReceive;
        this.descriptionOfTheInvitation = descriptionOfTheInvitation;
    }

    public double getProbabilityForPersonRoReceive() {
        return probabilityForPersonToReceive;
    }

    public String getDescriptionOfTheInvitation() {
        return descriptionOfTheInvitation;
    }
}
