package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CarLoanEMICalculator;
import pageObjects.HomeLoanEMICalculator;
import pageObjects.LoanCalculator;
import testBase.CucumberBaseClass;

public class A_CarLoan {
	WebDriver driver;
	Properties p;
	CarLoanEMICalculator ec;
	HomeLoanEMICalculator hl;
	LoanCalculator lc;
	Hooks hk;
	@Given("The user is on the emicalculator website\\(title:{string})")
	public void the_user_is_on_the_emicalculator_website_title(String exp_title) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		hk=new Hooks();
		hk.setup();
		ec = new CarLoanEMICalculator(CucumberBaseClass.getDriver());
		Assert.assertEquals(exp_title,ec.getTitle());
		
	}

	@When("User Clicks On the Car Loan radio button")
	public void user_clicks_on_the_car_loan_radio_button() {
		// Write code here that turns the phrase above into concrete actions
		ec = new CarLoanEMICalculator(CucumberBaseClass.getDriver());
		Assert.assertTrue( ec.clickOnCarLoanButton());

	}

	@When("moves the Car loan slider to the desired width")
	public void moves_the_car_loan_slider_to_the_desired_width() {
		// Write code here that turns the phrase above into concrete actions
		ec = new CarLoanEMICalculator(CucumberBaseClass.getDriver());
		

	}

	@Then("verify if the value attribute of the amount slider is\\(Amount:{string})")
	public void verify_if_the_value_attribute_of_the_amount_slider_is_amount(String exp_amount) {
		// Write code here that turns the phrase above into concrete actions
		ec = new CarLoanEMICalculator(CucumberBaseClass.getDriver());
		Assert.assertEquals(ec.verifySlider(ec.loan_amt_slider, ec.loan_amt, 163), exp_amount);

	}

	@When("User moves the interest rate slider to the desired width")
	public void user_moves_the_interest_rate_slider_to_the_desired_width() {
		// Write code here that turns the phrase above
		ec = new CarLoanEMICalculator(CucumberBaseClass.getDriver());
		
	}

	@Then("verify if the value attribute of the interest slider is\\(Interest:{string})")
	public void verify_if_the_value_attribute_of_the_interest_slider_is_interest(String exp_interest) {
		// Write code here that turns the phrase above into concrete actions
		ec = new CarLoanEMICalculator(CucumberBaseClass.getDriver());
		Assert.assertEquals(ec.verifySlider(ec.interestrateslider, ec.interest_rate, -130), exp_interest);

	}

	@When("User moves the tenure slider to the desired width")
	public void user_moves_the_tenure_slider_to_the_desired_width() {
		// Write code here that turns the phrase above into concrete actions
		ec = new CarLoanEMICalculator(CucumberBaseClass.getDriver());
		

	}

	@Then("verify if the value attribute of the tenure slider is\\(Tenure:{string})")
	public void verify_if_the_value_attribute_of_the_tenure_slider_is_tenure(String exp_tenure) {
		// Write code here that turns the phrase above into concrete actions
		ec = new CarLoanEMICalculator(CucumberBaseClass.getDriver());
		Assert.assertEquals(ec.verifySlider(ec.interesttenureslider, ec.interest_tenure, -230), exp_tenure);
	}
	@Given("The user scrolls down to the emi option buttons")
	public void the_user_scrolls_down_to_the_emi_option_buttons() {
	    // Write code here that turns the phrase above into concrete actions
		
		ec = new CarLoanEMICalculator(CucumberBaseClass.getDriver());
		ec.emiOption(0);
	}
	@When("User clicks on the emi advance \\(button:{string})")
	public void user_clicks_on_the_emi_advance_button(String advance_btn) {
	    // Write code here that turns the phrase above into concrete actions
		ec = new CarLoanEMICalculator(CucumberBaseClass.getDriver());
		Assert.assertEquals(ec.emiOption(0), advance_btn);
		
	    
	}
	@When("User clicks on the more button in the \\(year: {string},option:{int})")
	public void user_clicks_on_the_more_button_in_the_year_option(String year, Integer option) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		ec = new CarLoanEMICalculator(CucumberBaseClass.getDriver());
		Assert.assertEquals(ec.yeartable(),year );
	    
	}
	@Then("verify that the \\(principal:{string}) and \\(interest:{string}) amounts of one month are displayed")
	public void verify_that_the_principal_and_interest_amounts_of_one_month_are_displayed(String principal, String interest) {
	    // Write code here that turns the phrase above into concrete actions
		ec = new CarLoanEMICalculator(CucumberBaseClass.getDriver());
		Assert.assertEquals(ec.p_int()[0], principal);
		Assert.assertEquals(ec.p_int()[1], interest);
	    
	}
	@Given("The user scrolls up to the emi option buttons")
	public void the_user_scrolls_up_to_the_emi_option_buttons() {
	    // Write code here that turns the phrase above into concrete actions
		
		ec = new CarLoanEMICalculator(CucumberBaseClass.getDriver());
		ec.emiOption(1);
	}
	@When("User clicks on the emi arrears \\(button:{string})")
	public void user_clicks_on_the_emi_arrears_button(String advance_btn) {
	    // Write code here that turns the phrase above into concrete actions
		ec = new CarLoanEMICalculator(CucumberBaseClass.getDriver());
		Assert.assertEquals(ec.emiOption(1), advance_btn);
		
	    
	}

}
