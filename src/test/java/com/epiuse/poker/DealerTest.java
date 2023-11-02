package com.epiuse.poker;
import com.epiuse.poker.model.Card;
import com.epiuse.poker.model.CardSuit;
import com.epiuse.poker.service.DealerService;
import com.epiuse.poker.utils.LimitedList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class DealerTest {

    @Autowired
    private DealerService dealerService;

    @Test
    public void testFirstThreeCardsWithNoShuffle(){

        // The assumption here is that the 1st three cards ordered in the deck are clubs in their order

        LimitedList<Card> threeCards = new LimitedList<>(3);

        threeCards.add(new Card(new CardSuit("♣", "club"), "A"));
        threeCards.add(new Card(new CardSuit("♣", "club"), "2"));
        threeCards.add(new Card(new CardSuit("♣", "club"), "3"));

        LimitedList<Card> dealtCards = dealerService.deal(3);

        assertEquals(threeCards.getList(), dealtCards.getList());
    }

    @Test
    public void testFirstThreeCardsWithShuffle(){

        // The assumption here is that the 1st three cards ordered in the deck are clubs in their order

        LimitedList<Card> threeCards = new LimitedList<>(3);

        threeCards.add(new Card(new CardSuit("♣", "club"), "A"));
        threeCards.add(new Card(new CardSuit("♣", "club"), "2"));
        threeCards.add(new Card(new CardSuit("♣", "club"), "3"));

        // shuffle the dealer cards

        dealerService.shuffle();

        LimitedList<Card> dealtCards = dealerService.deal(3);



        assertNotEquals(threeCards.getList(), dealtCards.getList());
    }

    @Test
    public void testCardsReducesAfterDeal(){

        // The assumption here is that the 1st three cards ordered in the deck are clubs in their order

        LimitedList<Card> threeCards = new LimitedList<>(3);

        threeCards.add(new Card(new CardSuit("♣", "club"), "A"));
        threeCards.add(new Card(new CardSuit("♣", "club"), "2"));
        threeCards.add(new Card(new CardSuit("♣", "club"), "3"));

        // shuffle the dealer cards

        dealerService.shuffle();

        LimitedList<Card> dealtCards = dealerService.deal(3);

        // number of cards left should be 49

        assertEquals(49, dealerService.getCardDeck().getList().size());
    }

}
