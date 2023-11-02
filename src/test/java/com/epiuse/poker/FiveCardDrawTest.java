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
}
