package org.example.base;

import org.example.domain.Credentials;
import org.example.domain.UserType;
import org.example.page.DemoDashBoardPage;
import org.example.page.LoginPage;
import org.example.provider.CredentialsProvider;
import org.junit.jupiter.api.Test;

class DemoDashboardTest {
    @Test
    void checkArtifactsOnDemoDashboard() {
        Credentials credentials = new CredentialsProvider().provideByUserType(UserType.DEFAULT_USER);

        DemoDashBoardPage demoDashBoardPage = new LoginPage().login(credentials)
                .chooseDemoDashBoard()
                .checkLaunchStatisticsAreaTextPresence();

        demoDashBoardPage.closeDriver();
    }

}
