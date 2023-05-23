package org.example.base.testng;

import org.example.domain.Credentials;
import org.example.domain.UserType;
import org.example.page.DemoDashBoardPage;
import org.example.page.LoginPage;
import org.example.provider.CredentialsProvider;
import org.testng.annotations.Test;

public class DemoDashboardTest {
    @Test
    public void checkArtifactsOnDemoDashboard() {
        Credentials credentials = new CredentialsProvider().provideByUserType(UserType.DEFAULT_USER);

        DemoDashBoardPage demoDashBoardPage = new LoginPage().login(credentials)
                .openDashBoardPage()
                .chooseDemoDashBoard()
                .checkLaunchStatisticsAreaTextPresence();

        demoDashBoardPage.closeDriver();
    }

}
