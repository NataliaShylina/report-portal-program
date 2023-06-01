package org.example.base.bdd.stepdefinitions;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.domain.Credentials;
import org.example.domain.LaunchStatistics;
import org.example.page.*;

public class ReportPortalLaunchesSteps {
    @Given("I open Login page and fill-in credentials")
    public void open_login_page_and_input_credentials() {
        new LoginPage().login(new Credentials("default", "1q2w3e"));
    }

    @And("I Open DashBoard Page")
    public void i_open_dashboard_page() {
        new SideBar().openDashBoardPage();
    }
    @When("I Choose Demo DashBoard")
    public void i_choose_demo_dashboard() {
        new DashboardPage().chooseDemoDashBoard();
    }
    @Then("I Verify Launch Statistics Area Text Presence")
    public void verify_launch_statistics_area_text_presence(){
        new DemoDashBoardPage().verifyLaunchStatisticsAreaTextPresence();
    }
    @When("I Open Launches Page")
    public void open_launches_page(){
        new SideBar().openLaunchesPage();
    }
    @Then("I Verify Launch Statistics")
    @DataTableType(replaceWithEmptyString = "[anonymous]")
    public void verify_launch_statistics(){
        new LaunchesPage().verifyLaunchStatistics(10, LaunchStatistics.builder()
                .id(10)
                .total(30)
                .passed(30)
                .failed(null)
                .skipped(null)
                .build());

    }
}
