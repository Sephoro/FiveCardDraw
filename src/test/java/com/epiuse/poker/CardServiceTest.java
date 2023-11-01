package com.epiuse.poker;


import com.epiuse.poker.service.CardsService;
import com.epiuse.poker.utils.LimitedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CardServiceTest {

    private CardsService cardsService;

    @BeforeEach
    public void setUp() {
        // Initialize the CardsService and the LimitedList before each test
        cardsService = new CardsService();
        cardsService.setCards(new LimitedList<>(52));
    }

    @Test
    public void testCreate() {

        // Ensure that the LimitedList is initially empty

        assertTrue(cardsService.getCards().getList().isEmpty());

        // Call the create method

        cardsService.create();

        // Ensure that the LimitedList is no longer empty after calling create

        assertFalse(cardsService.getCards().getList().isEmpty());

        // Assert that the LimitedList contains 52 cards

        assertEquals(52, cardsService.getCards().getList().size());
    }


}
