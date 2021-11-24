package com.example.selenidecucumber.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.Optional;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public SelenideElement searchButton = $("[data-test='site-header-search-action']");
    public SelenideElement activeMenu = $(".main-menu-item--active [data-test='main-submenu']");
    public SelenideElement searchInput = $("[data-test='search-input']");
    public SelenideElement searchResults = $("ul[data-test='search-results']");
    public List<SelenideElement> menus = $$("[data-test='main-menu-item-action']");
    public List<SelenideElement> subMenus = $$(".main-menu-item--active a.main-submenu-item__link");
    public ElementsCollection searchResultList = searchResults.$$("a");
    public ElementsCollection searchResultListContent = searchResults.$$("[data-test='result-content']");
    public String searchedText;
    public String selectedSubMenu;
    public String clickedSearchResultUrl;

    public void selectMenu(String option){
        menus.stream().filter(e -> e.getText().equals(option)).findFirst().ifPresent(SelenideElement::click);
        activeMenu.shouldBe(visible);
    }

    public void selectSubMenu(String option){
        Optional<SelenideElement> element = subMenus.stream().filter(e -> e.getText().equals(option)).findFirst();
        element.ifPresent(x -> x.should(appear));
        element.ifPresent(SelenideElement::click);
        this.selectedSubMenu = option;
    }
}
