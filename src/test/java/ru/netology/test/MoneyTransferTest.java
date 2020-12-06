package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.AuthData;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;


public class MoneyTransferTest {

    @Test
//    @BeforeAll
    void shouldLoginAndVerify() {
        val loginPage = new LoginPage();
        val authInfo = AuthData.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = AuthData.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
    }

    @Test
    void replanishFirstCard() {
//        val loginPage = new LoginPage();
//        val authInfo = AuthData.getAuthInfo();
//        val verificationPage = loginPage.validLogin(authInfo);
//        val verificationCode = AuthData.getVerificationCodeFor(authInfo);
//        verificationPage.validVerify(verificationCode);
        val dashboardPage = new DashboardPage();
        val replanishPage = dashboardPage.replanishFirstCard();
//        replanishPage.setSecondCard();
        replanishPage.setSumToTransfer();
        replanishPage.finishReplanish();
    }

    @Test
    void replanishSecondCard() {
        val dashboardPage = new DashboardPage();
        val replanishPage = dashboardPage.replanishSecondCard();
//        replanishPage.setFirstCard();
        replanishPage.setSumToTransfer();
        replanishPage.finishReplanish();
    }

    @Test
    void getBalanceTest() {
        val loginPage = new LoginPage();
        val authInfo = AuthData.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = AuthData.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val dashboardPage = new DashboardPage();
        dashboardPage.getFirstCardBalance();

    }
}
