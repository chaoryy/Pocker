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
            System.out.println("Нельзя добавить пустую карту");
            return;
        }
        if(hand.size() >= 5){
            System.out.println("Рука полная");
            return;
        }
        hand.add(card);
    }

    public void replaceCard(int position, Card newCard) {
        if(newCard == null) {
            System.out.println("Новая карта не может быть пустой");
            return;
        }
        if(position>=0 && position < hand.size()) {
            hand.set(position, newCard);
        } else {
            System.out.println("Не верная позиция:" + position);
        }
    }

    public void showHand() {
        if(hand.isEmpty()) {
            System.out.println("Нет карт");
            return;
        }
        System.out.println("╔═══════╦═══════╦═══════╦═══════╦═══════╗");
        System.out.print("║");
        for(int i = 0; i < hand.size(); i++) {
            System.out.print(("  " + (i+1) + "  " + "║"));
        }
        System.out.println();
        System.out.print("║");
        for (Card card : hand) {
            System.out.print(("  " + card + "  " + "║"));
        }
        System.out.println();
        System.out.println("╚═══════╩═══════╩═══════╩═══════╩═══════╝");
    }

    public List<Card> getHand() {
        return hand;
    }
}
