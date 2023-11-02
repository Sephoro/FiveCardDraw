package com.epiuse.poker.service.interfaces;

import com.epiuse.poker.model.Card;
import com.epiuse.poker.utils.LimitedList;

public interface DealerService {
    abstract void shuffle();
    LimitedList<Card> deal(Integer numberOfCardsPerPlayer);
    LimitedList<Card> getDeck();
}
