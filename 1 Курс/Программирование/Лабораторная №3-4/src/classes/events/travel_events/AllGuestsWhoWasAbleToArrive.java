package classes.events.travel_events;

import classes.generators.GenerateRandomTransport;
import classes.roles.Guest;

import java.util.ArrayList;

public class AllGuestsWhoWasAbleToArrive {
    public static ArrayList<Guest> createFinalListOfGuests(ArrayList<Guest> potentialGuests) {
        ArrayList<Guest> finalListOfGuests = new ArrayList<Guest>();

        for (int i = 0; i < potentialGuests.size(); i++) {
            if (GuestsTravel.isGuestCame(potentialGuests.get(i), GenerateRandomTransport.generateTransport())) {
                finalListOfGuests.add(potentialGuests.get(i));
            }
        }

        return finalListOfGuests;
    }
}
