package com.epiuse.poker.service;

import com.epiuse.poker.model.Card;
import com.epiuse.poker.service.interfaces.Shuffler;
import com.epiuse.poker.utils.LimitedList;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Getter
public class DealerService {

    private final LimitedList<Card> cardDeck;

    @Getter(AccessLevel.NONE)
    private final Shuffler shuffler;

    @Autowired
    public DealerService(CardsService cardsService, Shuffler shuffler){

        this.shuffler = shuffler;

        // Create cards from card service

        cardsService.create();

        this.cardDeck = cardsService.getCards();
    }
    public void shuffle(){
        shuffler.shuffle(cardDeck);
    }

    public LimitedList<Card> deal(Integer numberOfCardsPerPlayer){

        // When dealing the cards, take from the top

        LimitedList<Card> sublist = new LimitedList<>(numberOfCardsPerPlayer);

        sublist.setList(new ArrayList<>(cardDeck.getList().subList(0, numberOfCardsPerPlayer)));

        // Then remove the dealt cards

        cardDeck.getList().removeAll(sublist.getList());

        return sublist;
    }

}
