package demoblaze.demoblaze;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{
public CartPage(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
}
@FindBy(tagName="h2")
private WebElement ProductName;
@FindBy(tagName="h3")
private WebElement price;
@FindBy(xpath="//a[text()='Add to cart']")
private WebElement addToCart;
public String getProductName() {
	return ProductName.getText();
}
public String getPrice() {
	return price.getText().split(" ")[0];
}
public void clickOnAddToCart() {
	addToCart.click();	
}
public String getPopUpText() {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.alertIsPresent());
	return driver.switchTo().alert().getText();
}
public void acceptPopUp() {
	driver.switchTo().alert().accept();
}
}
