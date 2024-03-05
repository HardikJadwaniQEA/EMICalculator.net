package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CarLoanEMICalculator;
import pageObjects.HomeLoanEMICalculator;
import pageObjects.LoanCalculator;
import testBase.CucumberBaseClass;

public class C_LoanCalculator {
	
	CarLoanEMICalculator ec;
	HomeLoanEMICalculator hl;
	LoanCalculator lc;
	@Given("User Successfully navigates to the LoanCalculator page of the web application\\(title:{string})")
	public void user_successfully_navigates_to_the_loan_calculator_page_of_the_web_application_title(String title) {
	    // Write code here that turns the phrase above into concrete actions
		//lc=new LoanCalculator(BaseClass.driver);
		hl=new HomeLoanEMICalculator(CucumberBaseClass.getDriver());
		Assert.assertEquals( hl.clickOnLoanCalc(),title);
	    
	}
	
	@When("user clicks on the EMI Calculator button")
	public void user_clicks_on_the_emi_calculator_button() {
	    // Write code here that turns the phrase above into concrete actions
		lc = new LoanCalculator(CucumberBaseClass.getDriver());
		Assert.assertTrue(lc.emicalc()); 
		
	   
	}

	@Then("Validate the LoanAmount\\(Slider:{int})")
	public void validate_the_loan_amount_slider(Integer i)  {
	    // Write code here that turns the phrase above into concrete actions
	    //cl=new CarLoanEMICalculator(Hooks.driver);
		ec = new CarLoanEMICalculator(CucumberBaseClass.getDriver());
		lc = new LoanCalculator(CucumberBaseClass.getDriver());
		
		Assert.assertNotEquals(lc.ValidateSliderStyle(ec.loan_amt_slider, 100),
				lc.ValidateSliderStyle(ec.loan_amt_slider, 0));
	}

	@Then("Validate the LoanAmount\\(Unit:{string},option:{int})")
	public void validate_the_loan_amount_unit_option(String unit, Integer int1)  {
	    // Write code here that turns the phrase above into concrete actions
		lc = new LoanCalculator(CucumberBaseClass.getDriver());
		
		Assert.assertEquals(lc.ValidateUnit(0), unit);
	}

	@Then("Validate the LoanAmount\\(scale:{int},{int},{int})")
	public void validate_the_loan_amount_scale(Integer j, Integer k, Integer l)  {
	    // Write code here that turns the phrase above into concrete actions
		lc = new LoanCalculator(CucumberBaseClass.getDriver());
		
		Assert.assertTrue(lc.verifyScale(j,k,l));
	    
	}

	@Then("Validate the InterestRate\\(Slider:{int})")
	public void validate_the_interest_rate_slider(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		lc = new LoanCalculator(CucumberBaseClass.getDriver());
		ec = new CarLoanEMICalculator(CucumberBaseClass.getDriver());
		Assert.assertNotEquals(lc.ValidateSliderStyle(ec.interestrateslider, 100),
				lc.ValidateSliderStyle(ec.interestrateslider, 0));
	}

	@Then("Validate the InterestRate\\(Unit:{string},option:{int})")
	public void validate_the_interest_rate_unit_option(String unit, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		lc = new LoanCalculator(CucumberBaseClass.getDriver());
		Assert.assertEquals(lc.ValidateUnit(2), "%");
		
	}

	@Then("Validate the InterestRate\\(scale:{int},{int},{int})")
	public void validate_the_interest_rate_scale(Integer j, Integer k, Integer l) {
	    // Write code here that turns the phrase above into concrete actions
		lc = new LoanCalculator(CucumberBaseClass.getDriver());
		Assert.assertTrue(lc.verifyScale(j,k,l));
	    
	}

	@Then("Validate the LoanTenure\\(Slider:{int})")
	public void validate_the_loan_tenure_slider(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		lc = new LoanCalculator(CucumberBaseClass.getDriver());
		ec = new CarLoanEMICalculator(CucumberBaseClass.getDriver());
		Assert.assertNotEquals(lc.ValidateSliderStyle(ec.interesttenureslider, 100),
				lc.ValidateSliderStyle(ec.interesttenureslider, 0));
	}

	@Then("Validate the LoanTenure\\(scale:{int},{int},{int})")
	public void validate_the_loan_tenure_scale(Integer j, Integer k, Integer l) {
	    // Write code here that turns the phrase above into concrete actions
		lc = new LoanCalculator(CucumberBaseClass.getDriver());
		Assert.assertTrue(lc.verifyScale(j,k,l));
	}

	@Then("Validate the Fees&Charges\\(Slider:{int})")
	public void validate_the_fees_charges_slider(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		lc = new LoanCalculator(CucumberBaseClass.getDriver());
		Assert.assertNotEquals(lc.ValidateSliderStyle(lc.fncSlider, 100), lc.ValidateSliderStyle(lc.fncSlider, 0));
	}

	@Then("Validate the Fees&Charges\\(Unit:{string},option:{int})")
	public void validate_the_fees_charges_unit_option(String unit, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		lc = new LoanCalculator(CucumberBaseClass.getDriver());
		Assert.assertEquals(lc.ValidateUnit(3),unit );
	}

	@Then("Validate the Fees&Charges\\(scale:{int},{int},{int})")
	public void validate_the_fees_charges_scale(Integer j, Integer k, Integer l) {
	    // Write code here that turns the phrase above into concrete actions
		lc = new LoanCalculator(CucumberBaseClass.getDriver());
		Assert.assertTrue(lc.verifyScale(j,k,l));
	}
	@When("user clicks on the Loan Amount Calculator button")
	public void user_clicks_on_the_loan_amount_calculator_button() {
	    // Write code here that turns the phrase above into concrete actions
		lc = new LoanCalculator(CucumberBaseClass.getDriver());
		lc.loanAmtBtn();
		lc.clickYrBtn();
		
	}

	@Then("Validate the EMI\\(Slider:{int})")
	public void validate_the_emi_slider(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		lc = new LoanCalculator(CucumberBaseClass.getDriver());
		
		
		if(int1==2) {
			Assert.assertEquals(lc.ValidateSliderStyle(lc.loan_emi_slider, 100),
					lc.ValidateSliderStyle(lc.loan_emi_slider, 0));
		}else {
			Assert.assertNotEquals(lc.ValidateSliderStyle(lc.loan_emi_slider, 100),
					lc.ValidateSliderStyle(lc.loan_emi_slider, 0));
		}
	}

	@Then("Validate the EMI\\(Unit:{string},option:{int})")
	public void validate_the_emi_unit_option(String string, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		lc = new LoanCalculator(CucumberBaseClass.getDriver());
		Assert.assertEquals(lc.ValidateUnit(1), "₹");
	}

	@Then("Validate the EMI\\(scale:{int},{int},{int})")
	public void validate_the_emi_scale(Integer j, Integer k, Integer l) {
	    
		lc = new LoanCalculator(CucumberBaseClass.getDriver());// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(lc.verifyScale(j,k,l));
		
	}
	
	@When("user clicks on the Loan Tenure Calculator button")
	public void user_clicks_on_the_loan_tenure_calculator_button() {
	    // Write code here that turns the phrase above into concrete actions
		lc = new LoanCalculator(CucumberBaseClass.getDriver());
		Assert.assertFalse(lc.loanTenureBtn());
	}

}
