package ru.netology.data;

import lombok.Value;

public class CardsData {
    private CardsData() {
    }

    @Value
    public static class CardsInfo {
        private String cardNumber;
    }

    public static CardsInfo getFirstCardInfo() {
        return new CardsInfo("5559 0000 0000 0001");
    }

    public static CardsInfo getSecondCardInfo() {
        return new CardsInfo("5559 0000 0000 0002");
    }

    @Value
    public static class TransferSumValue {
        private String sumToTransfer;
    }

        public static TransferSumValue getSumToTransfer() {return new TransferSumValue("1000");}
    }


