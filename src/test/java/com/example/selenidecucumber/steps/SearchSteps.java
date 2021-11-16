package com.example.selenidecucumber.steps;

import com.example.selenidecucumber.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchSteps {
    private MainPage mainPage;

    public SearchSteps(MainPage homepage) {
        this.mainPage = homepage;
    }

    @Given("the jetbrains website is loaded")
    public void theJetbrainsWebsiteIsLoaded() {
        open("https://www.jetbrains.com/");
    }

    @When("the {string} text is searched")
    public void theTextIsSearched(String arg0) {
        mainPage.searchButton.click();
        mainPage.searchedText = arg0;
        $("[data-test='search-input']").sendKeys(arg0);
        $("button[data-test='full-search-button']").click();
    }

    @Then("the result should contain the searched text")
    public void theResultShouldContainTheSearchedText() {
        $$("ul[data-test='search-results'] [data-test='result-preview']").forEach(element -> element.shouldHave(text(mainPage.searchedText)));

    }
}
