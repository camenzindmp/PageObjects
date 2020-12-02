package ru.netology.data;

import lombok.Value;

public class CardsData {
    private CardsData() {
    }

    @Value
    public static class CardsInfo {
        private String cardNumber;
    }

    public static CardsInfo getFirstCardInfo(CardsInfo cardsInfo) {
        return new CardsInfo("5559 0000 0000 0001");
    }

    public static CardsInfo getSecondCardInfo(CardsInfo cardsInfo) {
        return new CardsInfo("5559 0000 0000 0002");
    }

}
