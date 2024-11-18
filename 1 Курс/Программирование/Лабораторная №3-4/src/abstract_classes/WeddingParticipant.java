package abstract_classes;

import enums.wedding_participant_enums.Citizenship;
import enums.wedding_participant_enums.Gender;
import enums.wedding_participant_enums.Title;
import exceptions.IncorrectGenderError;

import java.util.Objects;

public abstract class WeddingParticipant {  // абстрактный класс для реализации человека
    protected String name; // имя человека
    protected Gender gender;  // пол человека
    protected Title title;  // титул человека
    protected Citizenship citizenship;  // гражданство человека

    public WeddingParticipant(String name, Gender gender, Title title, Citizenship citizenship) {  // конструктор класса
        this.name = name;
        this.gender = gender;
        this.title = title;

        if (this.gender == Gender.FEMALE && (this.title == Title.EMPEROR || this.title == Title.KING || this.title == Title.PRINCE ||
                this.title == Title.DUKE || this.title == Title.EARL || this.title == Title.BARON) ||
        this.gender == Gender.MALE && (this.title == Title.EMPRESS || this.title == Title.QUEEN || this.title == Title.PRINCESS ||
                this.title == Title.DUCHESS || this.title == Title.COUNTESS || this.title == Title.BARONESS)) {
            throw new IncorrectGenderError("persons of this gender cannot hold this title");
        }
        this.citizenship = citizenship;
    }

    public abstract void greet();  // каждый человек умеет здороваться

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public Citizenship getCitizenship() {
        return citizenship;
    }

    public Title getTitle() {
        return title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setCitizenship(Citizenship citizenship) {
        this.citizenship = citizenship;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    @Override
    public String toString() {  // переопределение метода toString() от класса Object
        return this.title.getTitle() + " " + this.name + " из " + this.citizenship.getCitizenship();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Сравнение ссылок
        if (obj == null || getClass() != obj.getClass()) return false; // Проверка на null и совпадение классов
        WeddingParticipant that = (WeddingParticipant) obj; // Приведение типа

        // Сравнение полей
        return Objects.equals(name, that.name) &&
                gender == that.gender &&
                title == that.title &&
                citizenship == that.citizenship;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, title, citizenship); // Генерация хэш-кода на основе полей
    }
}
