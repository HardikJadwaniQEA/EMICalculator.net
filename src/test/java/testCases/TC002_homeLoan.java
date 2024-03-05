package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CarLoanEMICalculator;
import pageObjects.HomeLoanEMICalculator;
import testBase.BaseClass;

public class TC002_homeLoan extends BaseClass {

	HomeLoanEMICalculator ec;
	CarLoanEMICalculator cl;

	@Test(priority = 12)
	public void HomeLoanTable() throws IOException {
		ec = new HomeLoanEMICalculator(BaseClass.driver);
		ec.LoanTable();

	}

	@Test(priority = 13)
	public void NavigateToLoanCalculators() {
		cl = new CarLoanEMICalculator(BaseClass.driver);
		//cl.calc_dropdown();
		//System.out.println(ec.clickOnLoanCalc());
		Assert.assertEquals(ec.clickOnLoanCalc(), "Loan Calculator — Calculate EMI, Affordability, Tenure & Interest Rate");

	}
	
	

}
