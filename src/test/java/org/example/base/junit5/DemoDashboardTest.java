package org.example.base.junit5;

import lombok.extern.log4j.Log4j2;
import org.example.domain.Credentials;
import org.example.domain.LaunchStatistics;
import org.example.domain.UserType;
import org.example.page.BasePage;
import org.example.page.LoginPage;
import org.example.provider.CredentialsProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

@Log4j2
class DemoDashboardTest {

    @BeforeEach
    void init() {
        BasePage.setDriver();
    }

    @AfterEach
    void clean() {
        BasePage.closeDriver();
    }

    @Test
    void checkArtifactsOnDemoDashboard() {
        Credentials credentials = new CredentialsProvider().provideByUserType(UserType.DEFAULT_USER);

        new LoginPage().login(credentials)
                .openDashBoardPage()
                .chooseDemoDashBoard()
                .verifyLaunchStatisticsAreaTextPresence();
    }

    @ParameterizedTest(name = "{index} Launch statistics: statistics = {0} ")
    @CsvSource({
            "10/30/30/null/null",
            "9/25/20/5/null",
            "8/20/10/8/2",
            "7/15/5/9/1",
    })
    void verifyThatLaunchesContainsExpectedData(@ConvertWith(LaunchStatisticsConverter.class) LaunchStatistics launchStatistics) {
        Credentials credentials = new CredentialsProvider().provideByUserType(UserType.DEFAULT_USER);

        log.debug(" ************** Thread: " + Thread.currentThread().getName() + ", id =" + launchStatistics.getId());
        new LoginPage().login(credentials)
                .openLaunchesPage()
                .verifyLaunchStatistics(launchStatistics);
    }
}
