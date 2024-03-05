package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CarLoanEMICalculator;
import pageObjects.LoanCalculator;
import testBase.BaseClass;

public class TC005_LoanTenureCalc extends BaseClass {
	
	LoanCalculator lc;
	CarLoanEMICalculator ec;
	
	@Test(priority = 39)
	public void validateAmountSlider() {
		lc = new LoanCalculator(BaseClass.driver);
		ec = new CarLoanEMICalculator(BaseClass.driver);
		lc.loanTenureBtn();
		
		
		Assert.assertNotEquals(lc.ValidateSliderStyle(ec.loan_amt_slider, 10),
				lc.ValidateSliderStyle(ec.loan_amt_slider, 20));

	}
	
	@Test(priority = 40)
	public void validateAmountUnit() {

		// System.out.println(lc.ValidateUnit(0));
		Assert.assertEquals(lc.ValidateUnit(0), "₹");

	}
	
	@Test(priority = 41)
	public void validateAmountscale() {

		// System.out.println(lc.verifyscale(2));
		Assert.assertTrue(lc.verifyScale(-1,-1,0));

	}
	
	@Test(priority = 48)
	public void validateEMISlider() {
		
		//System.out.println(lc.send_EMI_toSlider()); 
		Assert.assertEquals(lc.ValidateSliderStyle(lc.loan_emi_slider, 10),
				lc.ValidateSliderStyle(lc.loan_emi_slider, -5));

	}
	@Test(priority = 42)
	public void validateEMIUnit() {

		// System.out.println(lc.ValidateUnit(0));
		Assert.assertEquals(lc.ValidateUnit(1), "₹");

	}
	@Test(priority = 43)
	public void validateEMIscale() {

		// System.out.println(lc.verifyscale(2));
		Assert.assertTrue(lc.verifyScale(-1,-1,1));

	}
	
	@Test(priority = 44)
	public void validateInterestSlider() {
		// ec=new CarLoanEMICalculator(driver);

		Assert.assertNotEquals(lc.ValidateSliderStyle(ec.interestrateslider, 10),
				lc.ValidateSliderStyle(ec.interestrateslider, -5));

	}

	@Test(priority = 45)
	public void validateInterestUnit() {

		// System.out.println(lc.ValidateUnit(2));
		Assert.assertEquals(lc.ValidateUnit(2), "%");

	}

	@Test(priority = 46)
	public void validateInterestscale() {

		// System.out.println(lc.verifyscale(2));
		Assert.assertTrue(lc.verifyScale(-1,-1,2));

	}
	
	@Test(priority = 47)
	public void validatefncSlider() {
		Assert.assertNotEquals(lc.ValidateSliderStyle(lc.fncSlider, 10), lc.ValidateSliderStyle(lc.fncSlider, -5));
	}

	@Test(priority = 49)
	public void validatefncUnit() {

		// System.out.println(lc.ValidateUnit(3));
		Assert.assertEquals(lc.ValidateUnit(3), "₹");

	}
	
	@Test(priority = 50)
	public void validatefncscale() {

		// System.out.println(lc.verifyscale(2));
		Assert.assertTrue(lc.verifyScale(-1,-1,4));

	}
	
	
	
	
	
	
	

}
