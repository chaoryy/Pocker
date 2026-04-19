package logic;

import models.Card;
import models.Hand;
import models.Rank;

import java.util.*;

public class HandEvaluator {
    public HandRank evaluate(Hand hand) {
        List<Card> cards = new ArrayList<>(hand.getHand());
        cards.sort((c1, c2) -> Integer.compare(c1.getRank().getValue(), c2.getRank().getValue()));

        boolean isFlush = checkFlush(cards);
        boolean isStraight = checkStraight(cards);
        int maxSame = checkSameRank(cards);
        int pairs = checkAmountOfPairs(cards);

        if (isFlush && isStraight && cards.getFirst().getRank() == Rank.TEN) return HandRank.ROYAL_FLUSH;
        if (isFlush && isStraight) return HandRank.STRAIGHT_FLUSH;
        if (maxSame == 4) return HandRank.FOUR_OF_A_KIND;
        if (maxSame == 3 && pairs == 1) return HandRank.FULL_HOUSE;
        if (isFlush) return HandRank.FLUSH;
        if (isStraight) return HandRank.STRAIGHT;
        if (maxSame == 3) return HandRank.THREE_OF_A_KIND;
        if (pairs == 2) return HandRank.TWO_PAIR;
        if (pairs == 1) return HandRank.ONE_PAIR;
        return HandRank.HIGH_CARD;

    }
        private boolean checkFlush(List<Card> cards) {
            for (Card card : cards) {
                if(card.getSuit() != cards.getFirst().getSuit()) return false;
            }
            return true;
        }

        private boolean checkStraight(List<Card> cards) {
            for (int i = 0; i < cards.size() - 1; i++) {
                int current = cards.get(i).getRank().getValue();
                int next = cards.get(i + 1).getRank().getValue();
                if (next != current + 1) return false;
            }
            return true;
        }

        private int checkSameRank(List<Card> cards) {
            int max = 1;
            for(Card card1 : cards) {
                int count = 0;
                for (Card card2 : cards) {
                    if (card1.getRank() == card2.getRank()) count++;
                }
                if (count > max) max = count;
            }
            return max;
        }

        private int checkAmountOfPairs(List<Card> cards) {
            int pairs = 0;
            for (Rank r : Rank.values()) {
                int count = 0;
                for (Card c : cards) {
                    if(c.getRank() == r) {
                        count++;
                    }
                }
                if (count == 2) {
                    pairs++;
                }
            }
            return pairs;
        }
    }

