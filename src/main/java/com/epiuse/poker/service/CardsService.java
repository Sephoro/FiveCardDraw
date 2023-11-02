package com.epiuse.poker.service;

import com.epiuse.poker.model.Card;
import com.epiuse.poker.model.CardSuit;
import com.epiuse.poker.utils.LimitedList;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Data
@Service
public class CardsService {

    LimitedList<Card> cards;

    public void create(){

        if(cards == null || cards.getList().isEmpty()) {

            cards = new LimitedList<>(52);

            String[] suits = {"♣", "♦", "♥", "♠"};
            String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

            for (String suit : suits) {
                for (String value : values) {
                    CardSuit cardSuit = new CardSuit(suit, getSuitName(suit));
                    cards.add(new Card(cardSuit, value));
                }
            }
        }
    }

    private String getSuitName(String suitSymbol) {

        return switch (suitSymbol) {
            case "♣" -> "club";
            case "♦" -> "diamond";
            case "♥" -> "heart";
            case "♠" -> "spade";
            default -> "";
        };
    }
}
