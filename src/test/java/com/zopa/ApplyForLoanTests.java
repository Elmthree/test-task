package com.zopa;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.zopa.helpers.Helpers;
import com.zopa.helpers.UkPostCodeValidator;
import com.zopa.models.Loan;
import com.zopa.pages.BorrowerPage;
import com.zopa.pages.HomePage;
import com.zopa.pages.LoansPage;
import org.apache.commons.validator.routines.EmailValidator;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import static com.zopa.helpers.Helpers.writeToFile;
import static org.junit.Assert.assertTrue;

public class ApplyForLoanTests {

    private WebDriver driver;

    @BeforeClass
    public static void setChromeDriverSystemProperty() {
        Helpers.setChromeDriverSystemProperty();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("http://zopa.com");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void fillLoanFormWithRandomValues() throws NumberParseException, IOException {
        // Loan create method creates an object that we use to fill out form on borrowers page
        Loan loan = Loan.create();
        writeToFile(System.getProperty("user.dir") + "/data/testData.txt", loan.toString());

        // Using Apache Commons Email Validator to validate the random email generated
        EmailValidator emailValidator = EmailValidator.getInstance();
        assertTrue(emailValidator.isValid(loan.email));

        // Validate postcode
        assertTrue(UkPostCodeValidator.isValid(loan.address.postcode));

        // Validate phone number using Google internationalization libphonenumber diary
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        PhoneNumber parsedPhoneNumber = phoneUtil.parse(loan.telephoneNumber, "GB");
        assertTrue(phoneUtil.isValidNumber(parsedPhoneNumber));

        // Open home page and progress to Borrower page
        HomePage homePage = new HomePage(driver);
        homePage.getAZopaLoan();
        LoansPage loansPage = new LoansPage(driver);
        loansPage.getMyPersonalisedRates();

        BorrowerPage borrowerPage = new BorrowerPage(driver);
        borrowerPage.fillOutForm(loan);
    }
}
