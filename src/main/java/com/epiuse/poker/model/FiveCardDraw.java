package com.epiuse.poker.model;

import com.epiuse.poker.model.interfaces.PokerVariant;

public class FiveCardDraw extends PokerVariant {

    public FiveCardDraw(){
        super(5);
    }
    @Override
    public String cardsStrength() {
        return null;
    }


}
