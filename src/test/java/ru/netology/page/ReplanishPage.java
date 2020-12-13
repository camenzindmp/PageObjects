package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.CardsData;

import static com.codeborne.selenide.Selenide.$;

public class ReplanishPage {

    public ReplanishPage() {
        sumToTransferField.shouldBe(Condition.visible);
    }

    private SelenideElement sumToTransferField = $("[data-test-id=amount] [type=text]");
    private SelenideElement cardForTransferField = $("[data-test-id=from] [class='input__control']");
    private SelenideElement finishReplanishButton = $("[data-test-id='action-transfer']");

    public ReplanishPage setSumToTransfer() {
        CardsData.TransferSumValue transferSum = CardsData.getSumToTransfer();
        sumToTransferField.click();
        sumToTransferField.setValue(transferSum.getSumToTransfer());
        return new ReplanishPage();
    }

    public ReplanishPage setFirstCard() {
        CardsData.CardsInfo cardsInfo = CardsData.getFirstCardInfo();
        cardForTransferField.setValue(cardsInfo.getCardNumber());
        return new ReplanishPage();
    }

    public ReplanishPage setSecondCard() {
        CardsData.CardsInfo cardsInfo = CardsData.getSecondCardInfo();
        cardForTransferField.setValue(cardsInfo.getCardNumber());
        return new ReplanishPage();
    }

    public void finishReplanish() {
        finishReplanishButton.click();
        new DashboardPage();
    }
}
