package com.epiuse.poker.service.interfaces;

import com.epiuse.poker.model.Card;
import com.epiuse.poker.utils.LimitedList;

public interface Shuffler {
    void shuffle(LimitedList<Card> cards);
}
