package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import testBase.BaseClass;
import testBase.CucumberBaseClass;

public class LoanCalculator extends BasePage {

	public LoanCalculator(WebDriver driver) {
		super(driver);

	}

	public Actions move = new Actions(driver);
	 //CarLoanEMICalculator cl = new CarLoanEMICalculator(CucumberBaseClass.getDriver());

	public String getTitle() {
		return driver.getTitle();
	}
	
	@FindBy(id = "emi-calc")
	WebElement emiCalcBtn;

	public boolean emicalc() {
		emiCalcBtn.click();
		String match =emiCalcBtn.getAttribute("class");
		
		if(match.equalsIgnoreCase("active")) {
			return true;
			
		}else {
			return false;
		}
		
		
	}

	public String ValidateSliderStyle(WebElement slider, int dx) {

		Action slide = (Action) move.dragAndDropBy(slider, dx, 0).build();
		slide.perform();

		return slider.findElement(By.xpath("div")).getAttribute("style");

		// ec.loan_amt_slider;

	}

	@FindBy(xpath = "//span[@class=\"input-group-text\"]")
	public List<WebElement> units;

	public String ValidateUnit(int i) {

		return units.get(i).getText();

	}

	@FindBy(id = "loanfees")
	public WebElement fnc;

	@FindBy(id = "loanfeesslider")
	public WebElement fncSlider;

	@FindBy(className = "steps")
	public List<WebElement> scales;

	@FindBy(xpath = "//label[@class=\"btn btn-secondary\"]")
	public List<WebElement> secondary_btn;

	boolean onMonths = false;

	public void clickYrBtn() {
		secondary_btn.get(0).click();
	}
	@FindBy(id = "loanterm")
	public WebElement interest_tenure;

	public boolean verifyScale(int j, int k, int l) {
		
		int a = 0;

		if (j != -1) {
			a = j;

		}
		if (k != -1) {
			a = k;
		}
		if (l != -1) {
			a = l;
		}

		List<WebElement> markers_ele = getMarkers(a);

		float[] markers = new float[markers_ele.size()];

		for (int i = 0; i < markers_ele.size(); i++) {

			if ((a == 0 || a == 4) && i > 0 && j != -1) {
				String marker = markers_ele.get(i).getText();
				markers[i] = Float.parseFloat(marker.substring(0, marker.length() - 1));

			} else if (j != -1) {
				try {
					markers[i] = Float.parseFloat(markers_ele.get(i).getText());

				} catch (org.openqa.selenium.StaleElementReferenceException ex) {

				}
				if ((a == 1 || a == 4) && i > 0 && k != -1) {
					String marker = markers_ele.get(i).getText();
					markers[i] = Float.parseFloat(marker.substring(0, marker.length() - 1));

				} else if (k != -1) {
					try {
						markers[i] = Float.parseFloat(markers_ele.get(i).getText());

					} catch (org.openqa.selenium.StaleElementReferenceException ex) {

					}

				}
				if ((a == 0 || a == 1 || a==4) && i > 0 && l != -1) {
					String marker = markers_ele.get(i).getText();
					markers[i] = Float.parseFloat(marker.substring(0, marker.length() - 1));

				} else if (l != -1) {
					try {
						markers[i] = Float.parseFloat(markers_ele.get(i).getText());

					} catch (org.openqa.selenium.StaleElementReferenceException ex) {

					}

				}

				if (a == 3 && l==-1) {
					if (!onMonths) {
						onMonths = true;
						clickOnMonths(Integer.parseInt(interest_tenure.getAttribute("value")), j, k, l);
					}
				}

			}

		}
		return verify_intervals(markers);

	}

	private void clickOnMonths(int yr_value, int j, int k, int l) {
		// TODO Auto-generated method stub
		secondary_btn.get(0).click();
		int month_value = Integer.parseInt(interest_tenure.getAttribute("value"));
		Assert.assertEquals(yr_value * 12, month_value);

		verifyScale(j, k, l);

	}

	public boolean verify_intervals(float[] markers) {
		float interval = markers[1] - markers[0];
		for (int i = 1; i < markers.length - 1; i++) {
			if (markers[i + 1] - markers[i] == interval) {
				continue;
			}
			return false;

		}
		return true;

	}

	public List<WebElement> getMarkers(int i) {
		WebElement scale = scales.get(i);

		List<WebElement> markers = scale.findElements(By.xpath("span//span"));

		return markers;

	}

	@FindBy(id = "loan-amount-calc")
	WebElement loanAmountCalc;

	public void loanAmtBtn() {
		loanAmountCalc.click();
	}

	@FindBy(id = "loanemislider")
	public WebElement loan_emi_slider;
	@FindBy(id = "loanemi")
	public WebElement loan_emi;

	@FindBy(id = "loan-tenure-calc")
	WebElement loanTenureCalc;
	
	@FindBy(id = "loanyears")
	WebElement YrBtn;

	public boolean loanTenureBtn() {
		loanTenureCalc.click();
		return YrBtn.isDisplayed();

	}
	public String send_EMI_toSlider() {
		loan_emi.clear();
		loan_emi.sendKeys("27000");
		
		Action slide = (Action) move.dragAndDropBy(loan_emi_slider, 0, 0).build();
		slide.perform();
		return loan_emi.getAttribute("style");
	}

}
