package interfaces;

import records.AnimalIsTired;

public interface QuicklyTiring {
    default Record crackCauseOfTired() {
        return new AnimalIsTired();
    }
}
