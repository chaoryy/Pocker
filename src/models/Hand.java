package models;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>(5);
    }

    public void addCard(Card card) {
        if(card == null) {
            System.out.println("Can not add empty card");
            return;
        }
        if(hand.size() >= 5){
            System.out.println("Hand is full");
            return;
        }
        hand.add(card);
    }

    public void replaceCard(int position, Card newCard) {
        if(newCard == null) {
            System.out.println("New card can not be empty");
            return;
        }
        if(position>=0 && position < hand.size()) {
            hand.set(position, newCard);
        }
    }

    public void showHand() {
        if(hand.isEmpty()) {
            System.out.println("No cards");
            return;
        }
        System.out.println("Your cards: ");
        System.out.println("╔═══════╦═══════╦═══════╦═══════╦═══════╗");
        System.out.print("║");
        for(int i = 0; i < hand.size(); i++) {
            System.out.print(("   " + (i+1) + "   " + "║"));
        }
        System.out.println();
        System.out.print("║");
        for (Card card : hand) {
            System.out.print(("   " + card + "  " + "║"));
        }
        System.out.println();
        System.out.println("╚═══════╩═══════╩═══════╩═══════╩═══════╝");
    }

    public List<Card> getHand() {
        return hand;
    }
}
