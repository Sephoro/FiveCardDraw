package com.epiuse.poker.service;

import com.epiuse.poker.model.Card;
import com.epiuse.poker.service.interfaces.Shuffler;
import com.epiuse.poker.utils.LimitedList;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CollectionsShuffler implements Shuffler {
    @Override
    public void shuffle(LimitedList<Card> list) {
        Collections.shuffle(list.getList());
    }
}
