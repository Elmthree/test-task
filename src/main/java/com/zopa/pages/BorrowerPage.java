package com.zopa.pages;

import com.zopa.models.Loan;
import com.zopa.models.OwnAHome;
import org.apache.commons.validator.routines.EmailValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BorrowerPage extends BasePage {
    public BorrowerPage(WebDriver driver) {
        super(driver);
    }

    private WebElement emailAddress() {
        return this.wait.until(ExpectedConditions.elementToBeClickable(By.id("member_email")));
    }

    private WebElement getRadio(String option) {
        String selector = String.format("input[value='%s']", option);
        return driver.findElement(By.cssSelector(selector)).findElement(By.xpath("..")).findElement(By.cssSelector("label"));
    }

    private WebElement firstName() {
        return this.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[data-automation='ZA.first_name']")));
    }

    private WebElement lastName() {
        return this.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[data-automation='ZA.last_name']")));
    }

    private WebElement phoneNumber() {
        return this.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[data-automation='ZA.home_phone']")));
    }

    private WebElement dobDay() {
        return this.wait.until(ExpectedConditions.elementToBeClickable(By.id("date_of_birth_day")));
    }

    private WebElement dobMonth() {
        return this.wait.until(ExpectedConditions.elementToBeClickable(By.id("date_of_birth_month")));
    }

    private WebElement dobYear() {
        return this.wait.until(ExpectedConditions.elementToBeClickable(By.id("date_of_birth_year")));
    }

    private WebElement postCode() {
        return this.wait.until(ExpectedConditions.elementToBeClickable(By.id("address_postcode")));
    }

    private WebElement addressLookup() {
        return driver.findElement(By.cssSelector("input[value='Look up address']"));
    }

    private WebElement annualIncomeBeforeTax() {
        return driver.findElement(By.cssSelector("input[data-automation='ZA.salary']"));
    }

    private WebElement monthlyContribution() {
        return this.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[data-automation='ZA.rent']")));
    }

    private WebElement password() {
        return driver.findElement(By.cssSelector("input[data-automation='ZA.password']"));
    }

    public void fillOutForm(Loan loan) {
        // enter email
        emailAddress().sendKeys(loan.email);
        // select title
        getRadio(loan.title.toString()).click();
        // enter Name
        firstName().sendKeys(loan.firstName);
        lastName().sendKeys(loan.lastName);
        // enter phone number
        phoneNumber().sendKeys(loan.telephoneNumber);
        // enter dob
        dobDay().sendKeys(loan.dob.toString("dd"));
        dobMonth().sendKeys(loan.dob.toString("MM"));
        dobYear().sendKeys(loan.dob.toString("YYYY"));
        // loan reason
        getRadio(loan.loanReason.toString()).click();
        // address
        enterAddressFromLookUp(loan);
        // Employment status
        getRadio(loan.employmentStatus.toString()).click();
        // Income before tax
        annualIncomeBeforeTax().sendKeys(loan.incomeBeforeTax);
        // Own your home
        getRadio(loan.ownershipStatus.toString()).click();
        if (!loan.ownershipStatus.equals(OwnAHome.OWNER_NO_MORTGAGE)) {
            monthlyContribution().sendKeys(loan.monthlyContributionRentOrMortgage);
        }
        // Password
        password().sendKeys(loan.password);
    }

    private void enterAddressFromLookUp(Loan loan) {
        postCode().sendKeys(loan.address.postcode);
        addressLookup().click();

        WebElement selectElement = driver.findElement(By.cssSelector("select[data-automation='ZA.possible_address']"));
        Select select = new Select(selectElement);
        select.selectByVisibleText(loan.address.fullAddress);

        WebElement howLongMonth = driver.findElement(By.id("address_from_2i"));
        Select selectHowLongMonth = new Select(howLongMonth);
        String monthMovedIn = loan.address.dateMovedIn.toString("MMMM");
        selectHowLongMonth.selectByVisibleText(monthMovedIn);

        WebElement howLongYear = driver.findElement(By.id("address_from_1i"));
        Select selectHowLongYear = new Select(howLongYear);
        String yearMovedIn = loan.address.dateMovedIn.toString("YYYY");
        selectHowLongYear.selectByVisibleText(yearMovedIn);

        WebElement useThisAddress = driver.findElement(By.cssSelector("input[data-automation='ZA.select_address']"));
        useThisAddress.click();
        this.wait.until(ExpectedConditions.invisibilityOf(selectElement));
    }
}
