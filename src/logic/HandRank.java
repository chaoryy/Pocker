package logic;

public enum HandRank {
    ROYAL_FLUSH("Рояль-флэш", 10),
    STRAIGHT_FLUSH("Стрит-флэш", 9),
    FOUR_OF_A_KIND("Каре", 8),
    FULL_HOUSE("Фулл-хаус", 7),
    FLUSH("Флэш", 6),
    STRAIGHT("Стрит", 5),
    THREE_OF_A_KIND("Сет", 4),
    TWO_PAIR("Две пары", 3),
    ONE_PAIR("Пара", 2),
    HIGH_CARD("Старшая карта", 1);

    private final String name;
    private final int value;

    HandRank(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
