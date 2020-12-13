package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.data.AuthData;
import ru.netology.data.CardsData;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MoneyTransferTest {

    @Test
    DashboardPage shouldLoginAndVerify() {
        val loginPage = new LoginPage();
        val authInfo = AuthData.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = AuthData.getVerificationCodeFor(authInfo);
        return verificationPage.validVerify(verificationCode);
    }

    @Test
    void replanishFirstCard() {
        CardsData.TransferSumValue transferSum = CardsData.getSumToTransfer();
        val dashboardPage = shouldLoginAndVerify();
        val firstCardBalance = dashboardPage.getFirstCardBalance();
        val replanishPage = dashboardPage.replanishFirstCard();
        replanishPage.setSumToTransfer();
        replanishPage.setSecondCard();
        replanishPage.finishReplanish();
        val updatedCardBalance = firstCardBalance + transferSum.getSumToTransfer();
        assertEquals(firstCardBalance + transferSum.getSumToTransfer(), updatedCardBalance);
    }

    @Test
    void replanishSecondCard() {
        CardsData.TransferSumValue transferSum = CardsData.getSumToTransfer();
        val dashboardPage = shouldLoginAndVerify();
        val secondCardBalance = dashboardPage.getSecondCardBalance();
        val replanishPage = dashboardPage.replanishSecondCard();
        replanishPage.setSumToTransfer();
        replanishPage.setFirstCard();
        replanishPage.finishReplanish();
        val updatedCardBalance = secondCardBalance + transferSum.getSumToTransfer();
        assertEquals(secondCardBalance + transferSum.getSumToTransfer(), updatedCardBalance);
    }

//    @Test
//    void getBalanceTest() {
//        val loginPage = new LoginPage();
//        val authInfo = AuthData.getAuthInfo();
//        val verificationPage = loginPage.validLogin(authInfo);
//        val verificationCode = AuthData.getVerificationCodeFor(authInfo);
//        val dashboardPage = verificationPage.validVerify(verificationCode);
//        dashboardPage.getSecondCardBalance();
//    }
}
