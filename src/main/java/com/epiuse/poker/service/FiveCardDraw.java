package com.epiuse.poker.service;

import com.epiuse.poker.service.interfaces.PokerVariant;
import org.springframework.stereotype.Service;

@Service("FiveCardDraw")
public class FiveCardDraw extends PokerVariant {

    public FiveCardDraw(){
        super(5);
    }
    @Override
    public String cardsStrength() {
        return null;
    }

}
