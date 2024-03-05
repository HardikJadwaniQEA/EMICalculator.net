package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			 features= {".//Feature//A_CarLoan.feature",
					 ".//Feature//B_HomeLoan.feature",
					 ".//Feature//C_EMICalculator.feature",
					 ".//Feature//D_LoanAmountCalculator.feature",
					 ".//Feature//E_LoanTenureCalculator.feature"
					 },
			glue="stepDefinitions"
		)
public class testRun {

}
