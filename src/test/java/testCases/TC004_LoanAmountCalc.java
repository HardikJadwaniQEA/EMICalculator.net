package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CarLoanEMICalculator;
import pageObjects.LoanCalculator;
import testBase.BaseClass;

public class TC004_LoanAmountCalc extends BaseClass {
	
	LoanCalculator lc;
	CarLoanEMICalculator ec;
	
	@Test(priority = 27)
	public void validateEMISlider() {
		lc = new LoanCalculator(BaseClass.driver);
		ec = new CarLoanEMICalculator(BaseClass.driver);
		lc.loanAmtBtn();
		lc.clickYrBtn();
		Assert.assertNotEquals(lc.ValidateSliderStyle(lc.loan_emi_slider, 100),
				lc.ValidateSliderStyle(lc.loan_emi_slider, 0));

	}
	
	@Test(priority = 28)
	public void validateEMIUnit() {

		// System.out.println(lc.ValidateUnit(0));
		Assert.assertEquals(lc.ValidateUnit(1), "₹");

	}
	@Test(priority = 29)
	public void validateEMIscale() {

		// System.out.println(lc.verifyscale(2));
		Assert.assertTrue(lc.verifyScale(-1,1,-1));

	}
	@Test(priority = 30)
	public void validateInterestSlider() {
		// ec=new CarLoanEMICalculator(driver);

		Assert.assertNotEquals(lc.ValidateSliderStyle(ec.interestrateslider, 100),
				lc.ValidateSliderStyle(ec.interestrateslider, 0));

	}

	@Test(priority = 31)
	public void validateInterestUnit() {

		// System.out.println(lc.ValidateUnit(2));
		Assert.assertEquals(lc.ValidateUnit(2), "%");

	}

	@Test(priority = 32)
	public void validateInterestscale() {

		// System.out.println(lc.verifyscale(2));
		Assert.assertTrue(lc.verifyScale(-1,2,-1));

	}
	@Test(priority = 33)
	public void validateTenureSlider() {
		// ec=new CarLoanEMICalculator(driver);

		Assert.assertNotEquals(lc.ValidateSliderStyle(ec.interesttenureslider, 100),
				lc.ValidateSliderStyle(ec.interesttenureslider, 0));

	}

	@Test(priority = 34)
	public void validateTenurescale() {

		// System.out.println(lc.verifyscale(2));
		Assert.assertTrue(lc.verifyScale(-1,3,-1));

	}
	@Test(priority = 35)
	public void validatefncSlider() {
		Assert.assertNotEquals(lc.ValidateSliderStyle(lc.fncSlider, 100), lc.ValidateSliderStyle(lc.fncSlider, 0));
	}

	@Test(priority = 36)
	public void validatefncUnit() {

		// System.out.println(lc.ValidateUnit(3));
		Assert.assertEquals(lc.ValidateUnit(3), "₹");

	}
	
	@Test(priority = 37)
	public void validatefncscale() {

		// System.out.println(lc.verifyscale(2));
		Assert.assertTrue(lc.verifyScale(-1,4,-1));

	}
	@Test(priority=38)
	public void clickOnloanTenureCalcBtn() {
		Assert.assertFalse(lc.loanTenureBtn());
	}
	
	
	

}
