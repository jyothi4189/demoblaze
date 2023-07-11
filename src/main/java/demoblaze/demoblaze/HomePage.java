package demoblaze.demoblaze;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
public HomePage(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
}

@FindBy(css="[class='card h-100']")
private List<WebElement> allMobiles;

public void selectCategory(String category) {
	driver.findElement(By.xpath("//a[text()='"+category+"']")).click();
}
public int noOfMobile() {
	return allMobiles.size();
}
public void selectMobile(String Name,String Price) {
	for(WebElement Mobiles:allMobiles) {
	WebElement mobileDetails=Mobiles.findElement(By.xpath("descendant::div[@class='card-block']"));
	WebElement mobName=mobileDetails.findElement(By.xpath("descendant::h4"));
	String mobileName=mobName.getText();
	System.out.println(mobileName);
	WebElement mobPrice=mobileDetails.findElement(By.xpath("descendant::h5"));
	
	
	String mobilePrice=mobPrice.getText();
	System.out.println(mobilePrice);
	if((mobileName.equalsIgnoreCase(Name))&&(mobilePrice.equalsIgnoreCase(Price))) {
		mobName.findElement(By.tagName("a")).click();
		break;
	}
}
}
}
