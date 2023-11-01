package com.epiuse.poker.model;

import com.epiuse.poker.model.interfaces.PokerVariant;
import com.epiuse.poker.utils.LimitedList;
import lombok.Data;

@Data
public class FiveCardDraw implements PokerVariant {

    private LimitedList<Card> cards;

    public FiveCardDraw(){
        cards = new LimitedList<>(5);
    }
    @Override
    public String handStrength() {
        return null;
    }

    @Override
    public String hand() {
        return null;
    }
}
