package models;

public enum Suit {
    HEARTS("Hearts", "♥"),
    TILES("Tiles", "♦"),
    CLOVES("Cloves", "♣"),
    PIKES("Pikes", "♠");

    private final String name;
    private final String symbol;

    Suit(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
}

