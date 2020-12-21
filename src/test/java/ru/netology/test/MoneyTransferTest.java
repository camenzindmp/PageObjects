package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.data.AuthData;
import ru.netology.data.CardsData;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MoneyTransferTest {

    DashboardPage shouldLoginAndVerify() {
        val loginPage = new LoginPage();
        val authInfo = AuthData.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = AuthData.getVerificationCodeFor(authInfo);
        return verificationPage.validVerify(verificationCode);
    }

    @Test
    void replenishFirstCard() {
        val cardNumber = CardsData.getSecondCardInfo();
        val dashboardPage = shouldLoginAndVerify();
        val initialFirstCardBalance = dashboardPage.getCardBalance(0);
        val initialSecondCardBalance = dashboardPage.getCardBalance(1);
        val transferSum = CardsData.generateSumToTransfer(initialSecondCardBalance);
        val replenishPage = dashboardPage.replenishFirstCard();
        val expectedFirstCardBalance = initialFirstCardBalance + transferSum.getSumToTransfer();
        val expectedSecondCardBalance = initialSecondCardBalance - transferSum.getSumToTransfer();
        replenishPage.setSumToTransfer(transferSum);
        replenishPage.setCard(cardNumber);
        replenishPage.finishReplenish();
        val updatedFirstCardBalance = dashboardPage.getCardBalance(0);
        val updatedSecondCardBalance = dashboardPage.getCardBalance(1);
        assertEquals(expectedFirstCardBalance,updatedFirstCardBalance);
        assertEquals(expectedSecondCardBalance, updatedSecondCardBalance);
    }

    @Test
    void replenishSecondCard() {
        val cardNumber = CardsData.getFirstCardInfo();
        val dashboardPage = shouldLoginAndVerify();
        val initialFirstCardBalance = dashboardPage.getCardBalance(0);
        val initialSecondCardBalance = dashboardPage.getCardBalance(1);
        val transferSum = CardsData.generateSumToTransfer(initialFirstCardBalance);
        val replenishPage = dashboardPage.replenishSecondCard();
        val expectedFirstCardBalance = initialFirstCardBalance - transferSum.getSumToTransfer();
        val expectedSecondCardBalance = initialSecondCardBalance + transferSum.getSumToTransfer();
        replenishPage.setSumToTransfer(transferSum);
        replenishPage.setCard(cardNumber);
        replenishPage.finishReplenish();
        val updatedFirstCardBalance = dashboardPage.getCardBalance(0);
        val updatedSecondCardBalance = dashboardPage.getCardBalance(1);
        assertEquals(expectedFirstCardBalance,updatedFirstCardBalance);
        assertEquals(expectedSecondCardBalance, updatedSecondCardBalance);
    }
}
