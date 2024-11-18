package classes.items;

import enums.invitation_enums.PrestigeOfInvitation;

public class Invitation {
    PrestigeOfInvitation prestigeOfInvitation = PrestigeOfInvitation.ORDINARY;

    public Invitation() {
    }

    @Override
    public String toString() {
        return this.prestigeOfInvitation.getDescriptionOfTheInvitation() + " приглашение ";
    }

    public double getProbabilityToReceiveInvitation() {
        return this.prestigeOfInvitation.getProbabilityForPersonRoReceive();
    }
}
