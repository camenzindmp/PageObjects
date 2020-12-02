package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.AuthData;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;


public class MoneyTransferTest {

    //    @BeforeAll
    @Test
    void shouldLoginAndVerify() {
        val loginPage = new LoginPage();
        val authInfo = AuthData.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = AuthData.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
    }

    @Test
    void replanishFirstCard() {
        val dashboardPage = new DashboardPage();
        val replanishPage = dashboardPage.replanishFirstCard();
        // ...
    }

    @Test
    void replanishSecondCard() {
        // ..
    }
}
