package classes.events.invite_events;

import abstract_classes.WeddingParticipant;
import classes.items.Invitation;
import classes.roles.Newlywed;
import enums.wedding_participant_enums.Gender;

public class NewlywedSendsInvitation {

    public static boolean getRequestToInvitation(Newlywed newlywed, WeddingParticipant weddingParticipant) {
        Invitation invitation = newlywed.prepareWeddingInvitation();

        if (newlywed.getGender() == Gender.MALE) {
            System.out.print(newlywed.toString() + " выслал " + invitation.toString() + "для " + weddingParticipant.toString() + ".\n");
        } else {
            System.out.print(newlywed.toString() + " выслала " + invitation.toString() + "для " + weddingParticipant.toString() + ".\n");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return GuestGetsInvitation.agreeOrDisagreeToInvitation(invitation, weddingParticipant);
    }
}
