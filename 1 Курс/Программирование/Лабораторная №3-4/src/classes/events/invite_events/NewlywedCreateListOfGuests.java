package classes.events.invite_events;

import classes.generators.GenerateRandomGuest;
import classes.roles.Guest;
import classes.roles.Newlywed;
import enums.wedding_participant_enums.Gender;

import java.util.ArrayList;

public class NewlywedCreateListOfGuests {
    public static ArrayList<Guest> getListOfInvitees(Newlywed newlywed, int numberOfPotentialGuests, ArrayList<Guest> existingListOfWeddingParticipants) {
        if (newlywed.getGender() == Gender.MALE) {
            System.out.print("\nНастала очередь жениха отправлять приглашения.\n");
        } else {
            System.out.print("\nНастала очередь невесты отправлять приглашения.\n");
        }
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < numberOfPotentialGuests; i++) {
            Guest potentialGuest = GenerateRandomGuest.generateGuest();

            if (NewlywedSendsInvitation.getRequestToInvitation(newlywed, potentialGuest)) {
                existingListOfWeddingParticipants.add(potentialGuest);
            }
        }

        return existingListOfWeddingParticipants;
    }
}
