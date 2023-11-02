package com.epiuse.poker.model;

import com.epiuse.poker.model.interfaces.Shuffler;
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
