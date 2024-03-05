package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Utils;

public class HomeLoanEMICalculator extends BasePage {
	
	
	
	public HomeLoanEMICalculator(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath="//div[@id=\"paymentschedule\"]/table")
	WebElement loan_table;
	
	@FindBy(xpath="//div[@id=\"paymentschedule\"]/table//tr/th")
	List<WebElement> header;
	
	@FindBy(xpath="//*[@class=\"row no-margin yearlypaymentdetails\"]")
	List<WebElement> rows;
	//List<WebElement> header = loan_table.findElements(By.xpath("//tr/th"));
	//List<WebElement> rows = loan_table.findElements(By.xpath("//tr[@class=\"row no-margin yearlypaymentdetails\"]"));

	
	public boolean scrollToTable() {
		js.executeScript("arguments[0].scrollIntoView();", loan_table);
		return loan_table.isDisplayed();
	}
	
	public void LoanTable() throws IOException {

		
		for (int i = 1; i < header.size() + 1; i++) {
			// System.out.println(header.get(i).getText());
			Utils.write("LoanTable", 0, i - 1, header.get(i - 1).getText());
			for (int j = 0; j < rows.size(); j++) {
				Utils.write("LoanTable", j + 1, i - 1, rows.get(j).findElement(By.xpath("td[" + i + "]")).getText());

			}

		}

	}

	//@FindBy(id = "menu-item-2423")
	@FindBy(xpath="//*[@id=\"menu-item-2423\"]")
	WebElement loan_calc_opt;
	@FindBy(id="menu-item-2696")
	WebElement calculators;
	
	@FindBy(id = "loancalculatordashboard")
	WebElement loan_calc_dashboard;

	public String clickOnLoanCalc() {
		//js.executeScript("arguments[0].scrollIntoView();",calculators );
		calculators.click();
		loan_calc_opt.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(loan_calc_dashboard));
		// System.out.println(driver.getTitle());
		return driver.getTitle();
	}

}
