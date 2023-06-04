package org.example.base.testng;

import org.example.domain.Credentials;
import org.example.domain.LaunchStatistics;
import org.example.domain.UserType;
import org.example.page.BasePage;
import org.example.page.LoginPage;
import org.example.provider.CredentialsProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoDashboardTest {
    @BeforeMethod
    void init() {
        BasePage.setDriver();
    }

    @AfterMethod
    void close() {
        BasePage.closeDriver();
    }

    @Test
    public void checkArtifactsOnDemoDashboard() {
        Credentials credentials = new CredentialsProvider().provideByUserType(UserType.DEFAULT_USER);

        new LoginPage().login(credentials)
                .openDashBoardPage()
                .chooseDemoDashBoard()
                .verifyLaunchStatisticsAreaTextPresence();
    }

    @Test(dataProvider = "launchStatisticsProvider")
    public void verifyThatLaunchesContainsExpectedData(LaunchStatistics launchStatistics) {
        Credentials credentials = new CredentialsProvider().provideByUserType(UserType.DEFAULT_USER);

        new LoginPage().login(credentials)
                .openLaunchesPage()
                .verifyLaunchStatistics(launchStatistics);
    }

    @DataProvider(name = "launchStatisticsProvider")
    public Object[][] provideLaunchStatisticsDataSet() {
        return new Object[][]{
                {LaunchStatistics.builder().id(10).total(30).passed(30).failed(null).skipped(null).build()},
                {LaunchStatistics.builder().id(9).total(25).passed(20).failed(5).skipped(null).build()},
                {LaunchStatistics.builder().id(8).total(20).passed(10).failed(8).skipped(2).build()},
                {LaunchStatistics.builder().id(7).total(15).passed(5).failed(9).skipped(1).build()},
        };
    }
}
