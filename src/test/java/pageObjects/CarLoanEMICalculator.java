package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import com.pageObjects.EMICalculatorPageObjects;

//import com.pageClasses.ProductPage;

public class CarLoanEMICalculator extends BasePage {

	public CarLoanEMICalculator(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	

	public JavascriptExecutor js = (JavascriptExecutor) driver;
	public Actions move = new Actions(driver);
	// public List<String> loantable = new ArrayList<>();

	@FindBy(id = "car-loan")
	WebElement car_loan;

	public boolean clickOnCarLoanButton() {
		
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(car_loan));
			car_loan.click();
			if(car_loan.getAttribute("class").equalsIgnoreCase("active")) {
				return true;
			}
			return false;
		
		
	}
	public String getTitle() {
		return driver.getTitle();
	}
	

	@FindBy(id = "loanamountslider")
	public WebElement loan_amt_slider;
	@FindBy(id = "loanamount")
	public WebElement loan_amt;

	@FindBy(id = "loaninterestslider")
	public WebElement interestrateslider;

	@FindBy(id = "loaninterest")
	public WebElement interest_rate;

	@FindBy(id = "loantermslider")
	public WebElement interesttenureslider;

	@FindBy(id = "loanterm")
	public WebElement interest_tenure;

	public String verifySlider(WebElement slider, WebElement textbox, int dx) {

		Action slide = (Action) move.dragAndDropBy(slider, dx, 0).build();
		slide.perform();
		String value = textbox.getAttribute("value");
		// System.out.println(caramt);
		return value;

	}

	@FindBy(xpath = "//div[@class=\"col-lg-8\"]//label")
	List<WebElement> emi_optn;

	public String emiOption(int i) {
		js.executeScript("arguments[0].scrollIntoView();", emi_optn.get(i));
		String emi = emi_optn.get(i).getText();
		emi_optn.get(i).click();
		return emi;
	}

	@FindBy(id = "year2024")
	WebElement yearAdv;

	public String yeartable() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView();", yearAdv);
		String cur_year = yearAdv.getText();
		yearAdv.click();
		Thread.sleep(3000);
		return cur_year;
	}

	@FindBy(xpath = "//*[@id=\"monthyear2024\"]/td/div/table/tbody/tr[2]/td[2]")
	WebElement principal;

	@FindBy(xpath = "//*[@id=\"monthyear2024\"]/td/div/table/tbody/tr[2]/td[3]")
	WebElement interest;

	public String[] p_int() {
		
		String p_amt = principal.getText();
		// System.out.println("Principal Amount: "+ p_amt);

		String i_amt = interest.getText();
		// System.out.println("Interest Amount: "+ i_amt);

		String[] pr_int = { p_amt, i_amt };
		return pr_int;
	}

	

	

	@FindBy(id = "menu-item-dropdown-2696")
	WebElement calculators;

	public boolean calc_dropdown() {
		calculators.click();
		return calculators.isDisplayed();
		
	}

	@FindBy(id = "menu-item-3294")
	WebElement home_emi_opt;
	
	@FindBy(id="homeloaninsuranceamount")
	public WebElement homeLoanHeader;

	public String clickOnHomeLoan() {
		home_emi_opt.click();
		// System.out.println(driver.getTitle());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(homeLoanHeader));
		return driver.getTitle();
	}

	

}
