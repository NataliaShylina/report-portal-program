package org.example.base.junit5;

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

    @ParameterizedTest
    @CsvSource({
            "10, 10/30/30/null/null",
            "9, 9/25/20/5/null",
            "8, 8/20/10/8/2",
            "7, 7/15/5/9/1",
    })
    void verifyThatLaunchesContainsExpectedData(int id, @ConvertWith(LaunchStatisticsConverter.class) LaunchStatistics launchStatistics) {
        Credentials credentials = new CredentialsProvider().provideByUserType(UserType.DEFAULT_USER);

        new LoginPage().login(credentials)
                .openLaunchesPage()
                .verifyLaunchStatistics(id, launchStatistics);
    }
}
