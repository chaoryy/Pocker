package models;

public class Card {
    private final Rank rank;
    private final Suit suit;

    @Override
    public String toString() {
        return rank.getName() + suit.getSymbol();
    }

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if (!(o instanceof Card other)) return false;
        return rank == other.rank && suit == other.suit;

    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}
