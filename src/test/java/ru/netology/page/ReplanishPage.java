package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.CardsData;

import static com.codeborne.selenide.Selenide.$;

public class ReplanishPage {

    public ReplanishPage() { sumToTransferField.shouldBe(Condition.visible);
    }

    private SelenideElement sumToTransferField = $("[data-test-id=amount] [type=text]");
    private SelenideElement cardForTransferField = $("[data-test-id=from] [class='input__inner']");
    private SelenideElement finishReplanishButton = $("[data-test-id='action-transfer']");

    public ReplanishPage setSumToTransfer() {
        sumToTransferField.click();
        sumToTransferField.setValue("100");
        return new ReplanishPage();
    }

    public ReplanishPage setFirstCard(CardsData.CardsInfo getFirstCardInfo) {
        cardForTransferField.clear();
        cardForTransferField.setValue(getFirstCardInfo.getCardNumber());
        return new ReplanishPage();
    }

    public ReplanishPage setSecondCard(CardsData.CardsInfo getSecondCardInfo) {
        cardForTransferField.clear();
        cardForTransferField.setValue(getSecondCardInfo.getCardNumber());
        return new ReplanishPage();
    }

    public void finishReplanish() {
        finishReplanishButton.click();
        new DashboardPage();
    }
}
