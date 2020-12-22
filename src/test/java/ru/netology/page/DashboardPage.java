package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {

    public DashboardPage() {
        dashboardHeader.shouldBe(Condition.visible);
    }

    private ElementsCollection cards = $$("[class='list__item']");
    private SelenideElement dashboardHeader = $("[data-test-id=dashboard]");
    private SelenideElement replenishFirstCardButton = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] [data-test-id=action-deposit]");
    private SelenideElement replenishSecondCardButton = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] [data-test-id=action-deposit]");
    private SelenideElement refreshButton = $("[data-test-id=action-reload]");

    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public int getCardBalance(int index) {
        val card = cards.get(index);
        val text = card.text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public ReplenishPage replenishFirstCard() {
        replenishFirstCardButton.click();
        return new ReplenishPage();
    }

    public ReplenishPage replenishSecondCard() {
        replenishSecondCardButton.click();
        return new ReplenishPage();
    }

    public DashboardPage refreshDashboard() {
        refreshButton.click();
        return new DashboardPage();
    }
}
