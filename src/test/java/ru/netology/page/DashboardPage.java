package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DashboardPage {

    public DashboardPage() {
        open("http://localhost:9999/dashboard");
        dashboardHeader.shouldBe(Condition.visible);
    }

    private SelenideElement dashboardHeader = $("[data-test-id=dashboard]");
    private SelenideElement replanishFirstCardButton = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] [data-test-id=action-deposit]");
    private SelenideElement replanishSecondCardButton = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] [data-test-id=action-deposit]");
    private SelenideElement refreshButton = $("[data-test-id=action-reload]");

    private SelenideElement firstCardBalance = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement secondCardBalance = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");


    public String getFirstCardBalance() {
        String balance = firstCardBalance.getText();
        return balance;
    }

    public DashboardPage getSecondCardBalance() {
        secondCardBalance.getText();
        return new DashboardPage();
    }

    public ReplanishPage replanishFirstCard() {
        replanishFirstCardButton.click();
        return new ReplanishPage();
    }

    public ReplanishPage replanishSecondCard() {
        replanishSecondCardButton.click();
        return new ReplanishPage();
    }

    public DashboardPage refreshDashboard() {
        refreshButton.click();
        return new DashboardPage();
    }
}
