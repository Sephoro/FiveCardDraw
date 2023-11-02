package com.epiuse.poker;

import com.epiuse.poker.model.Card;
import com.epiuse.poker.model.CardSuit;
import com.epiuse.poker.service.interfaces.PokerVariant;
import com.epiuse.poker.utils.LimitedList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FiveCardDrawTest {

    @Autowired
    @Qualifier("FiveCardDraw")
    private PokerVariant fiveCard;
    @Test
    public void testSettingCards(){

        LimitedList<Card> fourCards = new LimitedList<>(4);

        fourCards.add(new Card(new CardSuit("♣", "club"), "A"));
        fourCards.add(new Card(new CardSuit("♦", "diamond"), "2"));
        fourCards.add(new Card(new CardSuit("♥", "heart"), "3"));
        fourCards.add(new Card(new CardSuit("♠", "spade"), "5"));

        assertThrows(UnsupportedOperationException.class, () -> fiveCard.setCards(fourCards), "It should not allow you to have a set cards not equalling 5");

        LimitedList<Card> fiveCards = new LimitedList<>(5);

        fiveCards.add(new Card(new CardSuit("♣", "club"), "A"));
        fiveCards.add(new Card(new CardSuit("♦", "diamond"), "2"));
        fiveCards.add(new Card(new CardSuit("♥", "heart"), "3"));
        fiveCards.add(new Card(new CardSuit("♠", "spade"), "5"));
        fiveCards.add(new Card(new CardSuit("♣", "club"), "K"));

        assertDoesNotThrow(() -> fiveCard.setCards(fiveCards), "It should allow you to have a set cards not equalling 5");

    }

    @Test
    public void testToString(){

        LimitedList<Card> fiveCards = new LimitedList<>(5);

        fiveCards.add(new Card(new CardSuit("♣", "club"), "A"));
        fiveCards.add(new Card(new CardSuit("♦", "diamond"), "2"));
        fiveCards.add(new Card(new CardSuit("♥", "heart"), "3"));
        fiveCards.add(new Card(new CardSuit("♠", "spade"), "5"));
        fiveCards.add(new Card(new CardSuit("♣", "club"), "K"));

        fiveCard.setCards(fiveCards);

        assertEquals("A♣ 2♦ 3♥ 5♠ K♣ ", fiveCard.cardsString(), "The card string method should return the cards in the manner in the expected");
    }

    @Test
    public void testStraightFlush(){

        LimitedList<Card> fiveCards = new LimitedList<>(5);
        fiveCards.add(new Card(new CardSuit("♣", "club"), "9"));
        fiveCards.add(new Card(new CardSuit("♣", "club"), "10"));
        fiveCards.add(new Card(new CardSuit("♣", "club"), "J"));
        fiveCards.add(new Card(new CardSuit("♣", "club"), "Q"));
        fiveCards.add(new Card(new CardSuit("♣", "club"), "K"));
        fiveCard.setCards(fiveCards);

        assertEquals("Straight Flush", fiveCard.cardsStrength());
    }

    @Test
    public void testFourOfAKind() {
        LimitedList<Card> fiveCards = new LimitedList<>(5);
        fiveCards.add(new Card(new CardSuit("♣", "club"), "A"));
        fiveCards.add(new Card(new CardSuit("♦", "diamond"), "A"));
        fiveCards.add(new Card(new CardSuit("♥", "heart"), "A"));
        fiveCards.add(new Card(new CardSuit("♠", "spade"), "A"));
        fiveCards.add(new Card(new CardSuit("♣", "club"), "K"));

        fiveCard.setCards(fiveCards);

        assertEquals("Four of a Kind", fiveCard.cardsStrength());
    }

    @Test
    public void testFullHouse() {
        LimitedList<Card> fiveCards = new LimitedList<>(5);
        fiveCards.add(new Card(new CardSuit("♣", "club"), "A"));
        fiveCards.add(new Card(new CardSuit("♦", "diamond"), "A"));
        fiveCards.add(new Card(new CardSuit("♥", "heart"), "2"));
        fiveCards.add(new Card(new CardSuit("♠", "spade"), "2"));
        fiveCards.add(new Card(new CardSuit("♣", "club"), "2"));

        fiveCard.setCards(fiveCards);

        assertEquals("Full House", fiveCard.cardsStrength());
    }

    @Test
    public void testFlush() {

        LimitedList<Card> fiveCards = new LimitedList<>(5);

        fiveCards.add(new Card(new CardSuit("♣", "club"), "A"));
        fiveCards.add(new Card(new CardSuit("♣", "club"), "2"));
        fiveCards.add(new Card(new CardSuit("♣", "club"), "5"));
        fiveCards.add(new Card(new CardSuit("♣", "club"), "10"));
        fiveCards.add(new Card(new CardSuit("♣", "club"), "K"));

        fiveCard.setCards(fiveCards);

        assertEquals("Flush", fiveCard.cardsStrength());
    }

    @Test
    public void testStraight() {

        LimitedList<Card> fiveCards = new LimitedList<>(5);
        fiveCards.add(new Card(new CardSuit("♣", "club"), "8"));
        fiveCards.add(new Card(new CardSuit("♦", "diamond"), "9"));
        fiveCards.add(new Card(new CardSuit("♥", "heart"), "10"));
        fiveCards.add(new Card(new CardSuit("♠", "spade"), "J"));
        fiveCards.add(new Card(new CardSuit("♣", "club"), "Q"));

        fiveCard.setCards(fiveCards);

        assertEquals("Straight", fiveCard.cardsStrength());
    }

    @Test
    public void testThreeOfAKind() {
        LimitedList<Card> fiveCards = new LimitedList<>(5);
        fiveCards.add(new Card(new CardSuit("♣", "club"), "A"));
        fiveCards.add(new Card(new CardSuit("♦", "diamond"), "A"));
        fiveCards.add(new Card(new CardSuit("♥", "heart"), "A"));
        fiveCards.add(new Card(new CardSuit("♠", "spade"), "4"));
        fiveCards.add(new Card(new CardSuit("♣", "club"), "5"));

        fiveCard.setCards(fiveCards);

        assertEquals("Three of a Kind", fiveCard.cardsStrength());
    }

    @Test
    public void testTwoPair() {
        LimitedList<Card> fiveCards = new LimitedList<>(5);
        fiveCards.add(new Card(new CardSuit("♣", "club"), "A"));
        fiveCards.add(new Card(new CardSuit("♦", "diamond"), "A"));
        fiveCards.add(new Card(new CardSuit("♥", "heart"), "2"));
        fiveCards.add(new Card(new CardSuit("♠", "spade"), "2"));
        fiveCards.add(new Card(new CardSuit("♣", "club"), "4"));

        fiveCard.setCards(fiveCards);

        assertEquals("Two Pair", fiveCard.cardsStrength());
    }

    @Test
    public void testOnePair() {
        LimitedList<Card> fiveCards = new LimitedList<>(5);
        fiveCards.add(new Card(new CardSuit("♣", "club"), "A"));
        fiveCards.add(new Card(new CardSuit("♦", "diamond"), "A"));
        fiveCards.add(new Card(new CardSuit("♥", "heart"), "K"));
        fiveCards.add(new Card(new CardSuit("♠", "spade"), "Q"));
        fiveCards.add(new Card(new CardSuit("♣", "club"), "5"));

        fiveCard.setCards(fiveCards);

        assertEquals("One Pair", fiveCard.cardsStrength());
    }

    @Test
    public void testHighCards() {
        LimitedList<Card> fiveCards = new LimitedList<>(5);
        fiveCards.add(new Card(new CardSuit("♣", "club"), "A"));
        fiveCards.add(new Card(new CardSuit("♦", "diamond"), "2"));
        fiveCards.add(new Card(new CardSuit("♥", "heart"), "3"));
        fiveCards.add(new Card(new CardSuit("♠", "spade"), "4"));
        fiveCards.add(new Card(new CardSuit("♣", "club"), "5"));

        fiveCard.setCards(fiveCards);

        assertEquals("High Cards", fiveCard.cardsStrength());
    }
}
