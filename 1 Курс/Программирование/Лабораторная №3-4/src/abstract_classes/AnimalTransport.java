package abstract_classes;

import enums.transport_enums.AnimalTypesOfTransport;
import enums.transport_enums.Color;

import java.util.ArrayList;
import java.util.Objects;

public abstract class AnimalTransport {
    protected Color color;
    protected AnimalTypesOfTransport animalTypesOfTransport;
    ArrayList<Record> potentialReasonsOfIncident;

    public AnimalTransport(Color color) {
        this.color = color;
        this.potentialReasonsOfIncident = new ArrayList<Record>();
    }

    protected void addPotentialReasonOfIncident(Record potentialReason) {
        this.potentialReasonsOfIncident.add(potentialReason);
    }

    public ArrayList<Record> getPotentialReasonsOfIncident() {
        return potentialReasonsOfIncident;
    }

    public AnimalTypesOfTransport getAnimalTypesOfTransport() {
        return animalTypesOfTransport;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setAnimalTypesOfTransport(AnimalTypesOfTransport animalTypesOfTransport) {
        this.animalTypesOfTransport = animalTypesOfTransport;
    }

    public void setPotentialReasonsOfIncident(ArrayList<Record> potentialReasonsOfIncident) {
        this.potentialReasonsOfIncident = potentialReasonsOfIncident;
    }

    @Override
    public String toString() {
        return this.animalTypesOfTransport.getType() + " " + this.color.getColor();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Сравнение ссылок
        if (obj == null || getClass() != obj.getClass()) return false; // Проверка на null и класс

        AnimalTransport that = (AnimalTransport) obj; // Приведение типа
        // Сравниваем только color и animalTypesOfTransport
        return color == that.color && animalTypesOfTransport == that.animalTypesOfTransport;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, animalTypesOfTransport, potentialReasonsOfIncident);
    }
}
