package classes.events.invite_events;

import classes.roles.Guest;
import classes.roles.Newlywed;

import java.util.ArrayList;

public class NewlywedesCreationFinalListOfGuests {
    public static ArrayList<Guest> createFinalListOfInvitees(Newlywed firstNewlywed, Newlywed secondNewlywed, int numberOfGuests) {
        int potentialNumberByGroom = numberOfGuests / 2;
        int potentialNumberByBride = numberOfGuests - potentialNumberByGroom;

        ArrayList<Guest> potentialGuests = new ArrayList<Guest>();
        ArrayList<Guest> potentialGuestsAfterFirstInvitation = NewlywedCreateListOfGuests.getListOfInvitees(firstNewlywed, potentialNumberByGroom, potentialGuests);

        return NewlywedCreateListOfGuests.getListOfInvitees(secondNewlywed, potentialNumberByBride, potentialGuestsAfterFirstInvitation);
    }
}
