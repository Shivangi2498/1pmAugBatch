package pom_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {
	
	public Home_page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (id="logoutLink")
	private WebElement logoutButton;
	
	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public void logoutAction() {
		logoutButton.click();
	}

}
