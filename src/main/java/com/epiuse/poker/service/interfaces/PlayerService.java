package com.epiuse.poker.service.interfaces;

import com.epiuse.poker.model.Card;
import com.epiuse.poker.utils.LimitedList;

public interface PlayerService {
     String getHandStrength();
     String getHand();
     void setHand(LimitedList<Card> limitedList);
}
