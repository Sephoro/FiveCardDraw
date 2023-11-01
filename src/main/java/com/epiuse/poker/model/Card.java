package com.epiuse.poker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Card {

    private CardSuit suit;
    private String value;

    public String stringValue() {
        return value + suit.getIcon();
    }
}
