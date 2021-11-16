package com.example.selenidecucumber.steps;

import com.codeborne.selenide.Condition;
import com.example.selenidecucumber.pages.IDEDefaultPage;
import com.example.selenidecucumber.pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.appear;

public class MenuSteps {
    private MainPage mainPage;
    private IDEDefaultPage ideDefaultPage;

    public MenuSteps(MainPage homepage, IDEDefaultPage ideDefaultPage) {
        this.mainPage = homepage;
        this.ideDefaultPage = ideDefaultPage;
    }

    @Then("the start page of the IDE should be loaded")
    public void theStartPageOfTheIDEShouldBeLoaded() {
        ideDefaultPage.title.should(appear);
        ideDefaultPage.title.shouldBe(Condition.text(mainPage.selectedSubMenu));
    }

    @When("the {string} is selected from the Developer tools menu")
    public void theIsSelectedFromTheDeveloperToolsMenu(String arg0) {
        mainPage.selectMenu("Developer Tools");
        mainPage.selectSubMenu(arg0);
    }
}
