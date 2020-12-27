
package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.data.AuthData;
import ru.netology.data.CardsData;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.CardsData.getFirstCardInfo;
import static ru.netology.data.CardsData.getSecondCardInfo;


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
        val cardNumber = getSecondCardInfo();
        val dashboardPage = shouldLoginAndVerify();
        val initialFirstCardBalance = dashboardPage.getCardBalance(getFirstCardInfo().getCardNumber());
        val initialSecondCardBalance = dashboardPage.getCardBalance(getSecondCardInfo().getCardNumber());
        val transferSum = CardsData.generateSumToTransfer(initialSecondCardBalance);
        val replenishPage = dashboardPage.replenishFirstCard();
        val expectedFirstCardBalance = initialFirstCardBalance + transferSum.getSumToTransfer();
        val expectedSecondCardBalance = initialSecondCardBalance - transferSum.getSumToTransfer();
        replenishPage.setSumToTransfer(transferSum);
        replenishPage.setCard(cardNumber);
        replenishPage.finishReplenish();
        val updatedFirstCardBalance = dashboardPage.getCardBalance(getFirstCardInfo().getCardNumber());
        val updatedSecondCardBalance = dashboardPage.getCardBalance(getSecondCardInfo().getCardNumber());
        assertEquals(expectedFirstCardBalance,updatedFirstCardBalance);
        assertEquals(expectedSecondCardBalance, updatedSecondCardBalance);
    }

    @Test
    void replenishSecondCard() {
        val cardNumber = getFirstCardInfo();
        val dashboardPage = shouldLoginAndVerify();
        val initialFirstCardBalance = dashboardPage.getCardBalance(getFirstCardInfo().getCardNumber());
        val initialSecondCardBalance = dashboardPage.getCardBalance(getSecondCardInfo().getCardNumber());
        val transferSum = CardsData.generateSumToTransfer(initialFirstCardBalance);
        val replenishPage = dashboardPage.replenishSecondCard();
        val expectedFirstCardBalance = initialFirstCardBalance - transferSum.getSumToTransfer();
        val expectedSecondCardBalance = initialSecondCardBalance + transferSum.getSumToTransfer();
        replenishPage.setSumToTransfer(transferSum);
        replenishPage.setCard(cardNumber);
        replenishPage.finishReplenish();
        val updatedFirstCardBalance = dashboardPage.getCardBalance(getFirstCardInfo().getCardNumber());
        val updatedSecondCardBalance = dashboardPage.getCardBalance(getSecondCardInfo().getCardNumber());
        assertEquals(expectedFirstCardBalance,updatedFirstCardBalance);
        assertEquals(expectedSecondCardBalance, updatedSecondCardBalance);
    }
}