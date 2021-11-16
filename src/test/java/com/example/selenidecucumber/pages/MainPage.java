package com.example.selenidecucumber.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public SelenideElement seeAllToolsButton = $("a.wt-button_mode_primary");
    public SelenideElement toolsMenu = $x("//div[contains(@class, 'menu-main__item') and text() = 'Developer Tools']");
    public SelenideElement searchButton = $("[data-test='site-header-search-action']");
    public SelenideElement activeMenu = $(".main-menu-item--active [data-test='main-submenu']");
    public List<SelenideElement> menus = $$("[data-test='main-menu-item-action']");
    public List<SelenideElement> subMenus = $$(".main-menu-item--active a.main-submenu-item__link");
    public String searchedText;
    public String selectedSubMenu;

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
