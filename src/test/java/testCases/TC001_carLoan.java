package testCases;

import testBase.BaseClass;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.CarLoanEMICalculator;
import stepDefinitions.Hooks;

public class TC001_carLoan extends BaseClass {

	CarLoanEMICalculator ec;
	

	@Test(priority = 1)
	public void clickOnCarLoanBtn() {
		ec = new CarLoanEMICalculator(BaseClass.driver);
		ec.clickOnCarLoanButton();

	}

	@Test(priority = 2)
	public void LoanAmount() {
		Assert.assertEquals(ec.verifySlider(ec.loan_amt_slider, ec.loan_amt, 163), "15,00,000");

	}

	@Test(priority = 3)
	public void LoanInt() {
		// System.out.println(ec.carLoanInterest());
		//Assert.assertEquals(ec.carLoanInterest(), "9.5");
		Assert.assertEquals(ec.verifySlider(ec.interestrateslider, ec.interest_rate, -130), "9.5");

	}

	@Test(priority = 4)
	public void LoanTenure() {

		// System.out.println(ec.carLoanTenure());
		//Assert.assertEquals(ec.carLoanTenure(), "1");
		Assert.assertEquals(ec.verifySlider(ec.interesttenureslider, ec.interest_tenure, -230), "1");
	}

	@Test(priority = 5)
	public void emiAdvance() {

		// System.out.println(ec.emiadvance());
		Assert.assertEquals(ec.emiOption(0), "EMI in Advance");
	}

	@Test(priority = 6)
	public void yearTableAdv() throws InterruptedException {

		// System.out.println(ec.emiadvance());
		Assert.assertEquals(ec.yeartable(), "2024");
	}

	@Test(priority = 7)
	public void pri_int_adv() {

		//System.out.println(ec.adv_p_int()[0] + " " + ec.adv_p_int()[1]);
		Assert.assertEquals(ec.p_int()[0], "₹ 1,19,650");
		Assert.assertEquals(ec.p_int()[1], "₹ 10,842");

	}

	@Test(priority = 8)
	public void emiArrears() {

		// System.out.println(ec.emiadvance());
		Assert.assertEquals(ec.emiOption(1), "EMI in Arrears");
	}

	@Test(priority = 9)
	public void yearTableArr() throws InterruptedException {

		// System.out.println(ec.emiadvance());
		Assert.assertEquals(ec.yeartable(), "2024");
	}

	@Test(priority = 10)
	public void pri_int_arr() {

		// System.out.println(ec.arr_p_int()[0]+" "+ec.arr_p_int()[1]);
		Assert.assertEquals(ec.p_int()[0], "₹ 1,20,597");
		Assert.assertEquals(ec.p_int()[1], "₹ 10,928");

	}

	@Test(priority = 11)
	public void navToHomeLoanCalc() throws InterruptedException {
		ec.calc_dropdown();
		ec.clickOnHomeLoan();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(ec.homeLoanHeader));
//		
//		Assert.assertEquals(ec.clickOnHomeLoan(), "Home Loan EMI Calculator with Prepayments, Taxes & Insurance");
//
	}

}
