package com.epiuse.poker;

import com.epiuse.poker.model.Card;
import com.epiuse.poker.model.CardSuit;
import com.epiuse.poker.service.interfaces.PlayerService;
import com.epiuse.poker.utils.LimitedList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FiveCardPlayerServiceTest {

    @Autowired
    @Qualifier("FiveCardPlayerService")
    private PlayerService fiveCardPlayerService;

    @Test
    public void testSettingOfCards(){

        LimitedList<Card> fiveCards = new LimitedList<>(5);

        fiveCards.add(new Card(new CardSuit("♣", "club"), "A"));
        fiveCards.add(new Card(new CardSuit("♦", "diamond"), "2"));
        fiveCards.add(new Card(new CardSuit("♥", "heart"), "3"));
        fiveCards.add(new Card(new CardSuit("♠", "spade"), "5"));
        fiveCards.add(new Card(new CardSuit("♣", "club"), "K"));

        fiveCardPlayerService.setHand(fiveCards);

        assertEquals("A♣ 2♦ 3♥ 5♠ K♣ ", fiveCardPlayerService.getHand(), "The get hand method should return the cards in the manner in the expected");

    }
}
