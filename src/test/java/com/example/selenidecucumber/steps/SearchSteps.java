package com.example.selenidecucumber.steps;

import com.codeborne.selenide.*;
import com.example.selenidecucumber.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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
        mainPage.searchInput.sendKeys(arg0);
    }

    @Then("the result should contain the searched text")
    public void theResultShouldContainTheSearchedText() {
        mainPage.searchResultListContent.should(CollectionCondition.allMatch("with text: "+ mainPage.searchedText, e -> e.getText().contains(mainPage.searchedText)));
    }

    @And("the first result is selected")
    public void theFirstResultIsSelected() {
        SelenideElement firstElement = mainPage.searchResultList.first();
        mainPage.clickedSearchResultUrl = firstElement.getAttribute("href");
        firstElement.click();
    }

    @Then("a navigation happens")
    public void aNavigationHappens() {
        Assert.assertEquals(mainPage.clickedSearchResultUrl, WebDriverRunner.getWebDriver().getCurrentUrl());
    }
}
