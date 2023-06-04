package org.example.base.bdd.stepdefinitions;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.domain.LaunchStatistics;
import org.example.domain.UserType;
import org.example.page.*;
import org.example.provider.CredentialsProvider;
import org.example.utility.Converter;

import java.util.List;
import java.util.Map;

public class ReportPortalLaunchesSteps {

    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final SideBar sideBar = new SideBar();
    private final DemoDashBoardPage demoDashBoardPage = new DemoDashBoardPage();
    private final LaunchesPage launchesPage = new LaunchesPage();

    private final CredentialsProvider credentialsProvider = new CredentialsProvider();

    @Given("I open Login page and fill-in credentials")
    public void open_login_page_and_input_credentials() {
        loginPage.login(credentialsProvider.provideByUserType(UserType.DEFAULT_USER));
    }

    @And("I Open DashBoard Page")
    public void i_open_dashboard_page() {
        sideBar.openDashBoardPage();
    }

    @When("I Choose Demo DashBoard")
    public void i_choose_demo_dashboard() {
        dashboardPage.chooseDemoDashBoard();
    }

    @Then("I Verify Launch Statistics Area Text Presence")
    public void verify_launch_statistics_area_text_presence() {
        demoDashBoardPage.verifyLaunchStatisticsAreaTextPresence();
    }

    @When("I Open Launches Page")
    public void open_launches_page() {
        sideBar.openLaunchesPage();
    }

    @Then("I Verify Launch Statistics")
    public void verify_launch_statistics(List<LaunchStatistics> items) {
        items.forEach(launchesPage::verifyLaunchStatistics);
    }

    @DataTableType
    public LaunchStatistics convertIntoLaunchStatistics(Map<String, String> raw){
        return LaunchStatistics.builder()
                .id(Converter.stringToInteger(raw.get("id")))
                .total(Converter.stringToInteger(raw.get("total")))
                .passed(Converter.stringToInteger(raw.get("passed")))
                .failed(Converter.stringToInteger(raw.get("failed")))
                .skipped(Converter.stringToInteger(raw.get("skipped")))
                .build();
    }
}
