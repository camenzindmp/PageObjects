package ru.netology.data;
import lombok.Value;

import java.util.Random;

public class CardsData {
    private CardsData() {
    }

    @Value
    public static class CardsInfo {
        private String cardNumber;
    }

    public static CardsInfo getFirstCardInfo() { return new CardsInfo("5559 0000 0000 0001"); }

    public static CardsInfo getSecondCardInfo() {
        return new CardsInfo("5559 0000 0000 0002");
    }

    @Value
    public static class TransferSumValue {
        private int sumToTransfer;
    }

    public static TransferSumValue generateSumToTransfer(int cardBalance) {
        Random rnd = new Random(System.currentTimeMillis());
        int sumToTransfer = 1 + rnd.nextInt(  cardBalance - 1);
        return new TransferSumValue(sumToTransfer);
    }

    public static TransferSumValue transferOneMill() {
        int sumToTransfer = 1000000;
        return new TransferSumValue(sumToTransfer);
    }
}