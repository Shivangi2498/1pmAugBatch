package generic_utility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pom_repository.Home_page;
import pom_repository.Login_page;

public class Base_class {
	
	public WebDriver driver;
	public File_utility fUtils = new File_utility();
	public Excel_utility excelUtils = new Excel_utility();
	public WebDriver_utility wUtils= new WebDriver_utility();
	
	@BeforeSuite
	//Connect to database
	public void bsConfig() {
		System.out.println("Connect to database");
	}
	
	@BeforeClass
	//Launch the browser, navigate to URL
	public void bcConfig() throws IOException {
		String url = fUtils.fetchDataFromPropertyFile("url");
		
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@BeforeMethod
	//Login
	public void bmConfig() throws IOException {
		String username = fUtils.fetchDataFromPropertyFile("username");
		String password = fUtils.fetchDataFromPropertyFile("password");
		Login_page login = new Login_page(driver); //Separate class is used 
		login.loginAction(username, password);
	}
	
	@AfterMethod
	//Logout
	public void amConfig() {
		Home_page home = new Home_page(driver);
		home.logoutAction();
	}
	
	@AfterClass
	//Close the browser
	public void afConfig() {
		driver.quit();
	}
	
	@AfterSuite
	//database is closed
	public void asConfig() {
		System.out.println("Data base is closed");
	}

}
