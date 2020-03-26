package Pages;

import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ValidateProductsAndPLanPage {

	public ValidateProductsAndPLanPage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	  }
	@WindowsFindBy(accessibility="productTapId")
	public WebElement products;
	
	@WindowsFindBy(accessibility="productId")
	public WebElement productsList;
}
