package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.data.AuthData;
import ru.netology.data.CardsData;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;
import ru.netology.page.ReplanishPage;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MoneyTransferTest {
    String sumToTransfer = "1000";

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
        val dashboardPage = shouldLoginAndVerify();
        val firstCardBalance = dashboardPage.getFirstCardBalance();
        val replanishPage = dashboardPage.replanishFirstCard();
        replanishPage.setSumToTransfer(sumToTransfer);
        replanishPage.setSecondCard();
        replanishPage.finishReplanish();
        val updatedCardBalance = firstCardBalance + sumToTransfer;
        assertEquals(firstCardBalance + sumToTransfer, updatedCardBalance);
    }

    @Test
    void replanishSecondCard() {
        val dashboardPage = shouldLoginAndVerify();
        val secondCardBalance = dashboardPage.getSecondCardBalance();
        val replanishPage = dashboardPage.replanishSecondCard();
        replanishPage.setSumToTransfer(sumToTransfer);
        replanishPage.setFirstCard();
        replanishPage.finishReplanish();
        val updatedCardBalance = secondCardBalance + sumToTransfer;
        assertEquals(secondCardBalance + sumToTransfer, updatedCardBalance);
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
