package com.zopa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private WebElement getAZopaLoanButton() {
        return this.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/loans']")));
    }

    public void getAZopaLoan() {
        getAZopaLoanButton().click();
    }
}
