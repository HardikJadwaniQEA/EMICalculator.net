package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CarLoanEMICalculator;
import pageObjects.LoanCalculator;
import testBase.BaseClass;

public class TC003_EMICalc extends BaseClass {

	LoanCalculator lc;
	CarLoanEMICalculator ec;

	@Test(priority = 14)
	public void clickOnLoanCalBtn() {
		lc = new LoanCalculator(BaseClass.driver);
		lc.emicalc();
	}

	@Test(priority = 15)
	public void validateAmountSlider() {
		ec = new CarLoanEMICalculator(BaseClass.driver);

		Assert.assertNotEquals(lc.ValidateSliderStyle(ec.loan_amt_slider, 100),
				lc.ValidateSliderStyle(ec.loan_amt_slider, 0));

	}

	@Test(priority = 16)
	public void validateAmountUnit() {

		// System.out.println(lc.ValidateUnit(0));
		Assert.assertEquals(lc.ValidateUnit(0), "₹");

	}

	@Test(priority = 17)
	public void validateAmountscale() {

		// System.out.println(lc.verifyscale(2));
		Assert.assertTrue(lc.verifyScale(0,-1,-1));

	}

	@Test(priority = 18)
	public void validateInterestSlider() {
		// ec=new CarLoanEMICalculator(driver);

		Assert.assertNotEquals(lc.ValidateSliderStyle(ec.interestrateslider, 100),
				lc.ValidateSliderStyle(ec.interestrateslider, 0));

	}

	@Test(priority = 19)
	public void validateInterestUnit() {

		// System.out.println(lc.ValidateUnit(2));
		Assert.assertEquals(lc.ValidateUnit(2), "%");

	}

	@Test(priority = 20)
	public void validateInterestscale() {

		// System.out.println(lc.verifyscale(2));
		Assert.assertTrue(lc.verifyScale(2,-1,-1));

	}

	@Test(priority = 21)
	public void validateTenureSlider() {
		// ec=new CarLoanEMICalculator(driver);

		Assert.assertNotEquals(lc.ValidateSliderStyle(ec.interesttenureslider, 100),
				lc.ValidateSliderStyle(ec.interesttenureslider, 0));

	}

	@Test(priority = 22)
	public void validateTenurescale() {

		// System.out.println(lc.verifyscale(2));
		Assert.assertTrue(lc.verifyScale(3,-1,-1));

	}
	
	

	@Test(priority = 23)
	public void validatefncSlider() {
		Assert.assertNotEquals(lc.ValidateSliderStyle(lc.fncSlider, 100), lc.ValidateSliderStyle(lc.fncSlider, 0));
	}

	@Test(priority = 24)
	public void validatefncUnit() {

		// System.out.println(lc.ValidateUnit(3));
		Assert.assertEquals(lc.ValidateUnit(3), "₹");

	}
	
	@Test(priority = 25)
	public void validatefncscale() {

		// System.out.println(lc.verifyscale(2));
		Assert.assertTrue(lc.verifyScale(4,-1,-1));

	}
	@Test(priority = 26)
	public void clickOnLoanAmtCalcBtn() {

		lc.loanAmtBtn();
	}
	

}
