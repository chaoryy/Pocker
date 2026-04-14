package models;

public class Card {
    private Rank rank;
    private Suit suit;

    @Override
    public String toString() {
        return rank.getName() + suit.getName();
    }

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
}
