package com.epiuse.poker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import static com.epiuse.poker.utils.CardValueToIntUtil.getCardValue;

@Data
@AllArgsConstructor
public class Card implements Comparable<Card> {

    private CardSuit suit;
    private String value;

    public String stringValue() {
        return value + suit.getIcon();
    }

    @Override
    public int compareTo(Card o) {
        return getCardValue(this.value) - getCardValue(o.value);
    }
}
