package com.epiuse.poker.model.interfaces;

import com.epiuse.poker.model.Card;
import com.epiuse.poker.utils.LimitedList;
import org.springframework.stereotype.Service;

@Service
public interface Shuffler {
    void shuffle(LimitedList<Card> cards);
}
