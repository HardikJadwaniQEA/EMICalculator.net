package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CarLoanEMICalculator;
import pageObjects.HomeLoanEMICalculator;
import testBase.CucumberBaseClass;

public class B_HomeLoan {
	CarLoanEMICalculator ec;
	HomeLoanEMICalculator hl;

	@Given("the user is on the home loan page of the website with \\(title: {string})")
	public void the_user_is_on_the_home_loan_page_of_the_website_with_title(String title) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		ec = new CarLoanEMICalculator(CucumberBaseClass.getDriver());
		Assert.assertTrue(ec.calc_dropdown());
		Assert.assertEquals(ec.clickOnHomeLoan(), title);

	}

	@When("user scrolls down to the loan table")
	public void user_scrolls_down_to_the_loan_table() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		hl = new HomeLoanEMICalculator(CucumberBaseClass.getDriver());
		Thread.sleep(5000);
		Assert.assertTrue(hl.scrollToTable());

	}

	@Then("verify that the loan table is being stored in the excel file")
	public void verify_that_the_loan_table_is_being_stored_in_the_excel_file()
			throws IOException, InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		hl = new HomeLoanEMICalculator(CucumberBaseClass.getDriver());
		Thread.sleep(5000);
		hl.LoanTable();
		hl.clickOnLoanCalc();

	}
}