package com.epiuse.poker.service;

import com.epiuse.poker.service.interfaces.DealerService;
import com.epiuse.poker.service.interfaces.PlayerService;
import com.epiuse.poker.service.interfaces.PokerPlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("FiveCardPokerPlayService")
public class FiveCardPokerPlayService implements PokerPlayService {

    private final DealerService fiveCardDealerService;
    private final PlayerService fiveCardPlayerService;
    @Autowired
    public FiveCardPokerPlayService(@Qualifier("FiveCardDealerService") DealerService fiveCardDealerService, @Qualifier("FiveCardPlayerService") PlayerService fiveCardPlayerService){
        this.fiveCardDealerService = fiveCardDealerService;
        this.fiveCardPlayerService = fiveCardPlayerService;

    }
    @Override
    public void play() {

        // Shuffle the cards

        fiveCardDealerService.shuffle();

        System.out.println("Shuffling ... Shuffling ... Shuffling ...");

        // deal the cards to the player

        fiveCardPlayerService.setHand(fiveCardDealerService.deal(5));

        System.out.println("Your hand: " + fiveCardPlayerService.getHand());

        System.out.println("Your have: " + fiveCardPlayerService.getHand());
    }

}
