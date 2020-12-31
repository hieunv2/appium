import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


public class appiumTest {
WebDriver driver;

@BeforeClass
public void setUp() throws MalformedURLException{
	DesiredCapabilities capabilities = new DesiredCapabilities();
	// get uid của thiết bị bằng lệnh adb devices
	capabilities.setCapability("uid", "56494bqa6"); 
	
	capabilities.setCapability("platformName","Android");
 
   // set appPackage của ứng dụng: lấy trong cài đặt của ứng dụng
   capabilities.setCapability("appPackage", "com.zing.zalo");
   
   	//Activity chính của ứng dụng
	capabilities.setCapability("appActivity","com.zing.zalo.ui.ZaloLauncherActivity"); 
	
	//Tự động cho phép các quyền
	capabilities.setCapability("autoGrantPermissions", "true"); 
	
	//Tự động cho phép các Alert hiện lên
	capabilities.setCapability("autoAcceptAlerts", "true");
	
	//connect đến server của appium
   driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
}

@Test
public void testCal() throws Exception {

	//Button login
   driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
   
   //TextInput phoneNumber
   driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.EditText")).sendKeys("0816076818");
   
   //TextInput password
   driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText")).sendKeys("vanhieu25");
   
   
  //Button Login
   driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ImageView")).click();
   
}

@AfterClass
public void teardown(){
	//close the app
//	driver.quit();
}
}