package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;



import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	Properties p;

	@BeforeTest
	@Parameters({ "os","browser" })
	public WebDriver driverSetup( String os,String br) throws IOException {
		logger = LogManager.getLogger(this.getClass());
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
	

		logger.info(br + " opened successfully___☑️");

		logger.info("Website opened successfully___☑️");
		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			if (os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
			} else {
				System.out.println("no match found");
			}
			switch (br.toLowerCase()) {
			case "chrome":
				cap.setBrowserName("chrome");
				break;
			case "edge":
				cap.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.println("no match found");
				break;
			}
			driver = new RemoteWebDriver( new URL("http://localhost:4444/wd/hub"),cap);
		} 
		else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
			
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("No matching browser");
				driver = null;
			}
			driver.get(p.getProperty("URL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().deleteAllCookies();
		}

		return driver;
	}

	public void screenshot(String name) {
		TakesScreenshot ss = ((TakesScreenshot) driver);
		File src = ss.getScreenshotAs(OutputType.FILE);
		try {
			File trg = new File("./Reports/Screenshot/" + name + ".png");
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		logger.info("Browser closed successfully___☑️");
	}

	public String captureScreen(String name)

	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir") + "\\ExtentReportscreenshots\\" + name + "_" + timeStamp
				+ ".png";
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
}
