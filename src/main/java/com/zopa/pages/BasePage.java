package com.zopa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 10);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


}
