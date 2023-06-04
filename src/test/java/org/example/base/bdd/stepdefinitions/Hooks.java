package org.example.base.bdd.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.page.BasePage;

public class Hooks {
    @Before
    public void init() {
        BasePage.setDriver();
    }

    @After
    public void clean(Scenario scenario) {

        BasePage.getWebDriver().close();
    }
}
