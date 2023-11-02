package com.epiuse.poker.service;

import com.epiuse.poker.model.Card;
import com.epiuse.poker.service.interfaces.PokerVariant;
import com.epiuse.poker.utils.LimitedList;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.epiuse.poker.utils.CardValueToIntUtil.getCardValue;


@Service("FiveCardDraw")
public class FiveCardDraw extends PokerVariant {

    public FiveCardDraw(){
        super(5);
    }
    @Override
    public String cardsStrength() {
        return evaluatePokerHand(getCards());
    }

    public String evaluatePokerHand(LimitedList<Card> fiveCards) {

        List<Card> fiveCardsList = fiveCards.getList();

        Collections.sort(fiveCardsList);

        if (isStraightFlush(fiveCardsList)) {
            return "Straight Flush";
        } else if (isFourOfAKind(fiveCardsList)) {
            return "Four of a Kind";
        } else if (isFullHouse(fiveCardsList)) {
            return "Full House";
        } else if (isFlush(fiveCardsList)) {
            return "Flush";
        } else if (isStraight(fiveCardsList)) {
            return "Straight";
        } else if (isThreeOfAKind(fiveCardsList)) {
            return "Three of a Kind";
        } else if (isTwoPair(fiveCardsList)) {
            return "Two Pair";
        } else if (isOnePair(fiveCardsList)) {
            return "One Pair";
        } else {
            return "High Cards";
        }
    }

    private boolean isStraightFlush(List<Card> fiveCards) {
        return isFlush(fiveCards) && isStraight(fiveCards);
    }

    private boolean isFourOfAKind(List<Card> fiveCards) {
        Map<String, Long> rankCounts = fiveCards.stream()
                .collect(Collectors.groupingBy(Card::getValue, Collectors.counting()));

        return rankCounts.containsValue(4L);
    }

    private boolean isFullHouse(List<Card> fiveCards) {
        Map<String, Long> rankCounts = fiveCards.stream()
                .collect(Collectors.groupingBy(Card::getValue, Collectors.counting()));

        return rankCounts.containsValue(3L) && rankCounts.containsValue(2L);
    }

    private boolean isFlush(List<Card> fiveCards) {
        String firstSuit = fiveCards.get(0).getSuit().getIcon();
        return fiveCards.stream().allMatch(card -> card.getSuit().getIcon().equals(firstSuit));
    }

    private boolean isStraight(List<Card> fiveCards) {
        int startIndex = getCardValue(fiveCards.get(0).getValue());

        for (int i = 1; i < 5; i++) {
            int currentValue = getCardValue(fiveCards.get(i).getValue());
            if (currentValue != startIndex + i) {
                return false;
            }
        }

        return true;
    }

    private boolean isThreeOfAKind(List<Card> fiveCards) {
        Map<String, Long> rankCounts = fiveCards.stream()
                .collect(Collectors.groupingBy(Card::getValue, Collectors.counting()));

        return rankCounts.containsValue(3L);
    }

    private boolean isTwoPair(List<Card> fiveCards) {
        Map<String, Long> rankCounts = fiveCards.stream()
                .collect(Collectors.groupingBy(Card::getValue, Collectors.counting()));

        long pairCount = rankCounts.values().stream()
                .filter(count -> count == 2L)
                .count();

        return pairCount == 2;
    }

    private boolean isOnePair(List<Card> fiveCards) {
        Map<String, Long> rankCounts = fiveCards.stream()
                .collect(Collectors.groupingBy(Card::getValue, Collectors.counting()));

        return rankCounts.containsValue(2L);
    }

    /*private String evaluatePokerHand(LimitedList<Card> fiveCards) {

        List<Card> cards = fiveCards.getList();

        boolean isFlush = isFlush(cards);
        boolean isStraight = isStraight(cards);

        if (isFlush && isStraight) {
            return "Straight Flush";
        } else if (hasNOfAKind(cards, 4)) {
            return "Four of a Kind";
        } else if (hasNOfAKind(cards, 3) && hasNOfAKind(cards, 2)) {
            return "Full House";
        } else if (isFlush) {
            return "Flush";
        } else if (isStraight) {
            return "Straight";
        } else if (hasNOfAKind(cards, 3)) {
            return "Three of a Kind";
        } else if (hasTwoPairs(cards)) {
            return "Two Pair";
        } else if (hasNOfAKind(cards, 2)) {
            return "One Pair";
        } else {
            return "High Cards";
        }
    }

    private boolean isFlush(List<Card> cards) {
        String suit = cards.get(0).getSuit().getIcon();
        for (Card card : cards) {
            if (!card.getSuit().getIcon().equals(suit)) {
                return false;
            }
        }
        return true;
    }

    private boolean isStraight(List<Card> cards) {

        int[] ranks = new int[5];
        for (int i = 0; i < 5; i++) {
            ranks[i] = getCardValue(cards.get(i).getValue());
        }
        Arrays.sort(ranks);
        return (ranks[4] - ranks[0] == 4) && (ranks[0] != ranks[1]);
    }

    private boolean hasNOfAKind(List<Card> cards, int n) {
        for (int i = 0; i <= 5 - n; i++) {
            if (getCardValue(cards.get(i).getValue()) == getCardValue(cards.get(i + n - 1).getValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean hasTwoPairs(List<Card> cards) {
        int pairs = 0;
        for (int i = 0; i < 4; i++) {
            if (getCardValue(cards.get(i).getValue()) == getCardValue(cards.get(i + 1).getValue())) {
                pairs++;
                i++;
            }
        }
        return pairs == 2;
    }*/

}
