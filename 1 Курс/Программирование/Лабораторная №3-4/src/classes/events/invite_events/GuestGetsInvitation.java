package classes.events.invite_events;

import abstract_classes.WeddingParticipant;
import classes.items.Invitation;
import enums.wedding_participant_enums.Gender;

public class GuestGetsInvitation {

    public static boolean agreeOrDisagreeToInvitation(Invitation invitation, WeddingParticipant weddingParticipant) {
        final boolean finalWord;
        if (Math.random() < invitation.getProbabilityToReceiveInvitation()) {
            if (weddingParticipant.getGender() == Gender.MALE) {
                System.out.printf("%s принял приглашение и готовится выезжать на свадьбу.%n%n", weddingParticipant.toString());
            } else {
                System.out.printf("%s приняла приглашение и готовится выезжать на свадьбу.%n%n", weddingParticipant.toString());
            }
            finalWord = true;
        } else {
            if (weddingParticipant.getGender() == Gender.MALE) {
                System.out.printf("%s отклонил приглашение на свадьбу.%n%n", weddingParticipant.toString());
            } else {
                System.out.printf("%s отклонила приглашение на свадьбу.%n%n", weddingParticipant.toString());
            }
            finalWord = false;
        }

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return finalWord;
    }
}
