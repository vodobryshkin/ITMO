package classes.events.wedding_events;

import classes.events.invite_events.NewlywedesCreationFinalListOfGuests;
import classes.events.travel_events.AllGuestsWhoWasAbleToArrive;
import classes.roles.Guest;
import classes.roles.Newlywed;
import exceptions.NoGuestsError;

import java.util.ArrayList;

public class Wedding {
    Newlywed firstNewlywed;
    Newlywed secondNewlywed;
    int numberOfGuests;

    public Wedding(Newlywed firstNewlywed, Newlywed secondNewlywed, int numberOfGuests) {
        this.firstNewlywed = firstNewlywed;
        this.secondNewlywed = secondNewlywed;
        this.numberOfGuests = numberOfGuests;
    }
    public void HoldAWedding() {
        System.out.printf("И решили %s и %s сыграть свадьбу. Решили они созвать %d гостей со всего мира.%n", firstNewlywed.toString(), secondNewlywed.toString(), numberOfGuests);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Чтобы разделить обязанности, было решено, что первую половину гостей зовёт жених, а вторую - невеста.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ArrayList<Guest> listOfGuestsWhoAgreeToVisitTheWedding = NewlywedesCreationFinalListOfGuests.createFinalListOfInvitees(firstNewlywed, secondNewlywed, numberOfGuests);

        try
        {
            if (listOfGuestsWhoAgreeToVisitTheWedding.isEmpty()) {
                throw new NoGuestsError("Никто не согласился приехать на свадьбу.");
            }
            System.out.printf("Из %d ожидаемых гостей %d приняли приглашение и готовятся к выезду.%n", numberOfGuests, listOfGuestsWhoAgreeToVisitTheWedding.size());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.printf("И стали молодожёны ждать прибытия гостей.%n%n");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            ArrayList<Guest> listOfGuests = AllGuestsWhoWasAbleToArrive.createFinalListOfGuests(listOfGuestsWhoAgreeToVisitTheWedding);


            if (listOfGuests.isEmpty()) {
                throw new NoGuestsError("Никто не смог доехать на свадьбу.");
            }
            System.out.printf("Прибытие последнего гостя ознаменовало начало долгожданной свадьбы.%n");

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                    throw new RuntimeException(e);
            }

            StartOfTheWedding.everyoneGreets(firstNewlywed, secondNewlywed, listOfGuests);
        } catch (NoGuestsError e) {
            System.out.print(e.getMessage());
        }
    }
}
