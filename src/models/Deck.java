package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>(52);
        createCards();
    }

    private void createCards() {
        for(Rank rank : Rank.values()) {
            for(Suit suit : Suit.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        Card card = cards.getFirst();
        cards.removeFirst();
        return card;
    }

    public void returnCard(Card card) {
        if (cards.contains(card)){
            System.out.println("Карта уже есть в колоде");
            return;
        }
        cards.add(card);
    }
}
