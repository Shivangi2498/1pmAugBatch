package login_Test;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import generic_utility.Base_class;

@Test
public class Verify_homepage_Test extends Base_class{
	
	@Test
	public void Verify_homepage_Test() throws EncryptedDocumentException,IOException {
		
		String expectedTitle = excelUtils.fetchDataFromExcelSheets("Sheet2", 1, 0);
		
		wUtils.waitForTitle(driver,"Enter"); //explicit wait
		
		String actualTitle = driver.getTitle();
		
		System.out.println(actualTitle);
		System.out.println(expectedTitle);
		
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Pass: The title is verified");
		
	}		
}
