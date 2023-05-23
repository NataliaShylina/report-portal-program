package org.example.base.junit5;

import org.example.domain.Credentials;
import org.example.domain.UserType;
import org.example.page.DemoDashBoardPage;
import org.example.page.LaunchesPage;
import org.example.page.LoginPage;
import org.example.provider.CredentialsProvider;
import org.junit.jupiter.api.Test;

class DemoDashboardTest {
    @Test
    void checkArtifactsOnDemoDashboard() {
        Credentials credentials = new CredentialsProvider().provideByUserType(UserType.DEFAULT_USER);

        DemoDashBoardPage demoDashBoardPage = new LoginPage().login(credentials)
                .openDashBoardPage()
                .chooseDemoDashBoard()
                .checkLaunchStatisticsAreaTextPresence();

        demoDashBoardPage.closeDriver();
    }

    //    @Test
//    void addNewDashboard(){
//        Credentials credentials = new CredentialsProvider().provideByUserType(UserType.DEFAULT_USER);
//
//        DemoDashBoardPage demoDashBoardPage = new LoginPage().login(credentials)
//                .openDashBoardTabFromTheLauncher()
//                .chooseAddNewDashBoard();
//              .fillNameFieldForNewDashBoard()
//               .addNewDashBoard();
//        demoDashBoardPage.closeDriver();
//    }
    @Test
    void verifyThatLaunchesContainsExpectedData() {
        Credentials credentials = new CredentialsProvider().provideByUserType(UserType.DEFAULT_USER);

        LaunchesPage launchesPage = new LoginPage().login(credentials)
                .openLaunchesPage()
                .verifyThatDemoAPITests10IsPresent()
                .verifyThatDemoAPITests10ContainsDemoData();
        launchesPage.closeDriver();
    }
}
