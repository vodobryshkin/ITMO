package interfaces;

import records.AnimalIsDehydrated;

public interface QuicklyDehydrated {
    default AnimalIsDehydrated crackCauseOfDehydration() {
        return new AnimalIsDehydrated();
    }
}
