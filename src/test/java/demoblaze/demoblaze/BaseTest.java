package demoblaze.demoblaze;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
public WebDriver driver;
@BeforeMethod
public void initializeDriver() throws IOException {
	FileInputStream fis=new FileInputStream("C:\\Users\\jinka\\eclipse-workspace\\demoblaze\\data.property");
	Properties p=new Properties();
	p.load(fis);
	String url=p.getProperty("Url");
	String Browser=p.getProperty("Browser");
	if(Browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}
	else if(Browser.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}
	else if(Browser.equalsIgnoreCase("Edge")) {
		driver=new EdgeDriver();
	}
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
}
@AfterMethod
public void closeDriver() {
	if(driver!=null) {
driver.quit();	
	}
}
}

