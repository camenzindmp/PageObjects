package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.CardsData;

import static com.codeborne.selenide.Selenide.$;

public class ReplenishPage {

    public ReplenishPage() {
        sumToTransferField.shouldBe(Condition.visible);
    }

    private SelenideElement sumToTransferField = $("[data-test-id=amount] [type=text]");
    private SelenideElement cardForTransferField = $("[data-test-id=from] [class='input__control']");
    private SelenideElement finishReplanishButton = $("[data-test-id='action-transfer']");

    public ReplenishPage setSumToTransfer(CardsData.TransferSumValue sumToTransfer) {
        sumToTransferField.click();
        sumToTransferField.setValue(String.valueOf(sumToTransfer));
        return new ReplenishPage();
    }

    public ReplenishPage setCard(CardsData.CardsInfo cardNumber) {
        cardForTransferField.setValue(String.valueOf(cardNumber));
        return new ReplenishPage();
    }

    public void finishReplenish() {
        finishReplanishButton.click();
        new DashboardPage();
    }
}
