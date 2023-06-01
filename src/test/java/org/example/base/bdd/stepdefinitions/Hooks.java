package org.example.base.bdd.stepdefinitions;

import io.cucumber.java.Before;
import org.example.page.BasePage;

public class Hooks {
    @Before
    public void init(){
        BasePage.setDriver();
    }
}
