package com.zopa.models;

import com.zopa.helpers.Helpers;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;

public class Loan {

    private Loan() {}

    public String firstName;
    public String middleName;
    public String lastName;
    public String email;
    public String password;
    public String telephoneNumber;
    public Title title;
    public LocalDate dob;
    public Reason loanReason;
    public String incomeBeforeTax;
    public String monthlyContributionRentOrMortgage;
    public OwnAHome ownershipStatus;
    public EmploymentStatus employmentStatus;
    public Address address;

    public static Loan create() {
        Loan loan = new Loan();
        loan.firstName = Helpers.nameGenerator();
        loan.middleName = Helpers.nameGenerator();
        loan.lastName = Helpers.nameGenerator();
        loan.email = String.format("%s.%s@fakeemail.com", loan.firstName.toLowerCase(), loan.lastName.toLowerCase());
        loan.password = "Passw0rd";
        loan.title = Title.getRandom();
        int daysToSubtract = RandomUtils.nextInt(100, 300);
        loan.dob = LocalDate.now().minusYears(20).minusDays(daysToSubtract);
        loan.loanReason = Reason.getRandom();
        loan.ownershipStatus = OwnAHome.getRandom();
        loan.employmentStatus = EmploymentStatus.getRandom();
        int income = RandomUtils.nextInt(10000, 30000);
        loan.incomeBeforeTax = Integer.toString(income);
        int monthlyContribution = RandomUtils.nextInt(0, 2000);
        loan.monthlyContributionRentOrMortgage = Integer.toString(monthlyContribution);
        loan.telephoneNumber = "07911888888";
        loan.address = new Address();
        System.out.println(loan.toString());
        return loan;
    }

    public String toString() {
        String object =   "Name: %s %s %s %s,\n"
                        + "Date of birth: %s\n"
                        + "Email: %s\n"
                        + "Password: %s\n"
                        + "Telephone Number: %s\n"
                        + "Loan Reason: %s\n"
                        + "Income Before Tax: %s\n"
                        + "Address: %s\n"
                        + "Ownership status: %s\n"
                        + "Monthly Contribution To Rent or Mortgage: %s\n"
                        + "Employment status: %s\n";

        return String.format(object,
            this.title,
            this.firstName,
            this.middleName,
            this.lastName,
            this.dob.toString("dd-MM-YYYY"),
            this.email,
            this.password,
            this.telephoneNumber,
            this.loanReason.toString(),
            this.incomeBeforeTax,
            this.address.fullAddress,
            this.ownershipStatus.toString(),
            this.monthlyContributionRentOrMortgage,
            this.employmentStatus.toString()
        );
    }


}
