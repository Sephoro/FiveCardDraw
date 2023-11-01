package com.epiuse.poker;

import com.epiuse.poker.model.Card;
import com.epiuse.poker.model.CardSuit;
import com.epiuse.poker.model.CollectionsShuffler;
import com.epiuse.poker.model.interfaces.Shuffler;
import com.epiuse.poker.utils.LimitedList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class CollectionsShufflerTest {

    @Test
    public void testShuffling(){

        LimitedList<Card> fourCards = new LimitedList<>(4);

        Shuffler cardShuffler = new CollectionsShuffler();

        fourCards.add(new Card(new CardSuit("♣", "club"), "A"));
        fourCards.add(new Card(new CardSuit("♦", "diamond"), "2"));
        fourCards.add(new Card(new CardSuit("♥", "heart"), "3"));
        fourCards.add(new Card(new CardSuit("♠", "spade"), "5"));

        LimitedList<Card> fourCards2 = new LimitedList<>(4);

        fourCards2.add(new Card(new CardSuit("♣", "club"), "A"));
        fourCards2.add(new Card(new CardSuit("♦", "diamond"), "2"));
        fourCards2.add(new Card(new CardSuit("♥", "heart"), "3"));
        fourCards2.add(new Card(new CardSuit("♠", "spade"), "5"));


        assertEquals(fourCards2, fourCards, "The two arrays should be identical before shuffling");

        cardShuffler.shuffle(fourCards);

        assertNotEquals(fourCards2, fourCards, "The two arrays should not be identical before shuffling");

    }
}
