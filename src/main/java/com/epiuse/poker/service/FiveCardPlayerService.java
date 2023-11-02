package com.epiuse.poker.service;

import com.epiuse.poker.model.Card;
import com.epiuse.poker.service.interfaces.PlayerService;
import com.epiuse.poker.service.interfaces.PokerVariant;
import com.epiuse.poker.utils.LimitedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("FiveCardPlayerService")
public class FiveCardPlayerService implements PlayerService  {

    private final PokerVariant pokerVariant;

    @Autowired
    public FiveCardPlayerService(PokerVariant pokerVariant){
        this.pokerVariant = pokerVariant;
    }

    public String getHandStrength(){
        return pokerVariant.cardsStrength();
    }

    public String getHand(){
        return  pokerVariant.cardsString();
    }

    public void setHand(LimitedList<Card> limitedList){
        pokerVariant.setCards(limitedList);
    }
}
