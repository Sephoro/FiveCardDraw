package com.epiuse.poker.utils;

public class CardValueToIntUtil {
    public static int getCardValue(String rank) {
        return switch (rank) {
            case "A" -> 14;
            case "K" -> 13;
            case "Q" -> 12;
            case "J" -> 11;
            default ->
                // For numeric cards (2-10), parse the integer value from the rank
                    Integer.parseInt(rank);
        };
    }
}
