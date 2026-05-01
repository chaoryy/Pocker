import logic.HandEvaluator;
import logic.HandRank;
import models.Deck;
import models.Hand;

import java.util.Scanner;

public class Game {
    private final Deck deck;
    private Hand hand;
    private HandEvaluator evaluator;
    private static final Scanner sc = new Scanner(System.in);

    public Game() {
        this.deck = new Deck();
        this.hand = new Hand();
        this.evaluator = new HandEvaluator();
    }

    public void play() {
        showMenu();
        takeMenuAnswer();
    }

    public void showMenu() {
        System.out.println("╔═══════════════════════════════╗");
        System.out.println("║      Welcome to Pocker!       ║");
        System.out.println("╚═══════════════════════════════╝");
        System.out.println("Want to play? \n 1) Yes \n 2) No");
        System.out.print("Your answer: ");
    }

    private void takeMenuAnswer() {
        if(!sc.hasNextInt()) {
            System.out.println("Invalid input. Only 1 or 2 are allowed");
            return;
        }

        int input = sc.nextInt();
        switch (input) {
            case 1:
                startGame();
                break;
            case 2:
                System.out.println("Byeeee!");
                break;
            default:
                System.out.println("Invalid input. Try again");
                play();
        }
    }

    public void startGame() {
        System.out.println("Game start!!");
        this.hand = new Hand();

        deck.shuffle();
        dealCards();
        hand.showHand();
        if (isHandChanged()) {
            hand.showHand();
        }
        HandRank combination = evaluator.evaluate(hand);
        System.out.println("You have " + combination);
    }

    public void dealCards() {
        for (int i = 0; i < 5; i++) {
            hand.addCard(deck.drawCard());
        }
    }

    public boolean isHandChanged() {
        System.out.println("Enter card numbers to change (e.g., '1 3 5') If do not want to, type 'No'");
        sc.nextLine();
        int [] cardsToChange = getCardsToChange();
        if (cardsToChange.length == 0) {
            return false;
        }
        changeCards(cardsToChange);
        return true;
    }

    public void changeCards(int [] cardsToChange) {
        for (int i : cardsToChange) {
            hand.replaceCard(i - 1, deck.drawCard());
        }
    }

    public int[] getCardsToChange() {
        while (true) {
            String input = sc.nextLine();
            if (input.trim().equalsIgnoreCase("no")) {
                return new int[0];
            }

            if (!input.matches("[1-5\\s]+")){
                System.out.println("Invalid input. Enter ONLY 1-5");
                continue;
            }
            String[] parts = input.split("\\s+");

            int[] cardsToChange = new int[parts.length];
            for(int i = 0; i < parts.length; i++) {
                cardsToChange[i] = Integer.parseInt(parts[i]);
            }
            if (!isValidInput(cardsToChange)) {
                continue;
            }
            return cardsToChange;
        }
    }

    public boolean isValidInput(int[] cardsToChange) {
        if (cardsToChange.length > 5 ) {
            System.out.println("Invalid input. Can not insert more than 5 numbers");
            return false;
        }

        return true;
    }
}
