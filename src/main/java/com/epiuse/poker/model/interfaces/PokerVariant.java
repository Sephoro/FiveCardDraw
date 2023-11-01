package com.epiuse.poker.model.interfaces;

import com.epiuse.poker.model.Card;
import com.epiuse.poker.utils.LimitedList;
import lombok.Getter;

@Getter
public abstract class PokerVariant {

    private LimitedList<Card> cards;
    private final Integer numberOfCards;
    public PokerVariant(Integer numberOfCards){
        cards = new LimitedList<>(numberOfCards);
        this.numberOfCards = numberOfCards;
    }

    public abstract String cardsStrength();

    public String cardsString(){
        StringBuilder cards = new StringBuilder();

        for(Card card: getCards().getList()){
            cards.append(card.stringValue()).append(" ");
        }

        return cards.toString();
    }

    public void setCards(LimitedList<Card> cards) {

        // Dictate the number of cards to be set based on the game type

        if(cards.getList().size() == this.numberOfCards){
           this.cards = cards;
        }
        else{
            throw new UnsupportedOperationException("Cards only limited to " + numberOfCards  + " in count");
        }

    }

}
