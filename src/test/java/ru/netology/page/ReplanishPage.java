package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class ReplanishPage {

    public ReplanishPage() {
        sumToTransferField.shouldBe(Condition.visible);
    }

    private SelenideElement sumToTransferField = $("[data-test-id=amount] [type=text]");
    private SelenideElement cardForTransferField = $("[data-test-id=from] [class='input__control']");
    private SelenideElement finishReplanishButton = $("[data-test-id='action-transfer']");

    public ReplanishPage setSumToTransfer(String sumToTransfer) {
        sumToTransferField.click();
        sumToTransferField.setValue(sumToTransfer);
        return new ReplanishPage();
    }

    //    public ReplanishPage setFirstCard(CardsData.CardsInfo getFirstCardInfo) {
//        cardForTransferField.clear();
//        cardForTransferField.setValue(getFirstCardInfo.getCardNumber());
//        return new ReplanishPage();
//    }
    public ReplanishPage setFirstCard() {
        cardForTransferField.setValue("5559000000000001");
        return new ReplanishPage();
    }

    //    public ReplanishPage setSecondCard(CardsData.CardsInfo getSecondCardInfo) {
//        cardForTransferField.setValue(getSecondCardInfo.getCardNumber());
//        return new ReplanishPage();
//     }
    public ReplanishPage setSecondCard() {
        cardForTransferField.setValue("5559000000000002");
        return new ReplanishPage();
    }

    public void finishReplanish() {
        finishReplanishButton.click();
        new DashboardPage();
    }
}
