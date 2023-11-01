package com.epiuse.poker;

import com.epiuse.poker.model.Card;
import com.epiuse.poker.model.CardSuit;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CardSuitTest {

    @Test
    public void testStringValueOfCard(){

        Card card = new Card(new CardSuit("♣", "club"), "A");

        assertEquals("A♣", card.stringValue(), "To string method should return the card value and the icon");
    }
}
