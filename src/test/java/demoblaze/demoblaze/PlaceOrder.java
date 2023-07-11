package demoblaze.demoblaze;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrder extends BaseTest{
@Test
public void testOrder() throws InterruptedException {
	String ProductName="Iphone 6 32gb";
	String Price="$790";
	HomePage homepage=new HomePage(driver);
	homepage.selectCategory("Phones");
	Thread.sleep(2000);
	
	homepage.selectMobile(ProductName, Price);
	CartPage cartpage=new CartPage(driver);
	String actualProductName=cartpage.getProductName();
	String actualPrice=cartpage.getPrice();
	System.out.println(actualPrice);
	Assert.assertEquals(ProductName,actualProductName);
	Assert.assertEquals(Price, actualPrice);
	cartpage.clickOnAddToCart();
	String alertText=cartpage.getPopUpText();
	Assert.assertEquals(alertText, "Product added");
	cartpage.acceptPopUp();
	
}
}
