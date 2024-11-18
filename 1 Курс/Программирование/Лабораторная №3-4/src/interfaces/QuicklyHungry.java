package interfaces;

import records.AnimalIsHungry;

public interface QuicklyHungry {
    default AnimalIsHungry crackCauseOfHunger() {
        return new AnimalIsHungry();
    }
}
