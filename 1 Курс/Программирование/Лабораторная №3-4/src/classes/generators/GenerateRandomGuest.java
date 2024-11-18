package classes.generators;

import classes.roles.Guest;
import enums.wedding_participant_enums.Citizenship;
import enums.wedding_participant_enums.Gender;
import enums.wedding_participant_enums.Title;

public class GenerateRandomGuest {

    public static Guest generateGuest() {
        // Массив с мужскими именами
        String[] maleNames = {
                "Артур", "Ланселот", "Гарри", "Эдвард", "Робин",
                "Тристан", "Фродо", "Гендальф", "Джон", "Оливер",
                "Леонард", "Саймон", "Каспар", "Мерлин", "Драко",
                "Валентин", "Томас", "Феликс", "Бенедикт", "Габриэль",
                "Лукас", "Ричард", "Эдмунд", "Себастьян", "Джеймс",
                "Тимур", "Николай", "Александр", "Филипп", "Михаил"
        };

        // Массив с женскими именами
        String[] femaleNames = {
                "Грета", "Эльза", "Сара", "Ариэль", "Луна",
                "Рапунцель", "Белль", "Золушка", "Жасмин", "Тиана",
                "Клара", "Лилиан", "Софи", "Кристина", "Эмили",
                "Анна", "Майя", "Изабелла", "Селеста", "Аделина",
                "Виктория", "Магдалена", "Габриэла", "Натали", "Эстелла",
                "Фиона", "Лорен", "Джулия", "Кэтрин", "Эвелин"
        };
        Title[] maleTitles = {Title.EMPEROR, Title.KING, Title.PRINCE, Title.DUKE, Title.EARL, Title.BARON};
        Title[] femaleTitles = {Title.EMPRESS, Title.QUEEN, Title.PRINCESS, Title.DUCHESS, Title.COUNTESS, Title.BARONESS};
        Citizenship[] citizenships = {
                Citizenship.GLIMMERING_REALM,
                Citizenship.MYSTIC_WOODLAND,
                Citizenship.CRYSTAL_CAVERN,
                Citizenship.SHADOWFALL_EMPIRE,
                Citizenship.SUNSET_ISLE,
                Citizenship.FROSTFIRE_KINGDOM,
                Citizenship.WHISPERING_MOUNTAINS,
                Citizenship.ENCHANTED_GROVE,
                Citizenship.STARDUST_VALE,
                Citizenship.ELDERTREE_REALM,
                Citizenship.RAINBOW_REACH,
                Citizenship.SILVERSTREAM_LAND
        };

        String name;
        Gender gender;
        Title title;
        Citizenship citizenship;

        if (Math.random() > 0.5) {
            gender = Gender.MALE;
        } else {
            gender = Gender.FEMALE;
        }

        if (gender == Gender.MALE)
        {
            name = maleNames[(int) (Math.random() * 30)];
            title = maleTitles[(int) (Math.random() * 6)];

        } else {
            name = femaleNames[(int) (Math.random() * 30)];
            title = femaleTitles[(int) (Math.random() * 6)];
        }

        citizenship = citizenships[(int) (Math.random() * 12)];

        return new Guest(name, gender, title, citizenship);
    }
}
