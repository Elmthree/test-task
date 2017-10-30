package com.zopa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoansPage extends BasePage {
    public LoansPage(WebDriver driver) {
        super(driver);
    }

    public void getMyPersonalisedRates() {
        WebElement getMyPersonalisedRatesButton = this.wait.until(ExpectedConditions.elementToBeClickable(By.id("submit-loan-button")));
        getMyPersonalisedRatesButton.sendKeys(Keys.RETURN);
    }

}
