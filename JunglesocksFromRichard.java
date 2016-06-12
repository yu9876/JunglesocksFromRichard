
package EamestExamForRichard;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.junit.*;
import static org.junit.Assert.*;

public class JunglesocksFromRichard {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	//Open jungle socks page
    driver = new FirefoxDriver();
    baseUrl = "https://jungle-socks.herokuapp.com";
    //time out
  	Thread.sleep(2000);
  }

  /* Three happy flows test cases for CA, NY, MN below based on the requirement*/
  
  @Test 
//{state : 'ca' , value : 0.08 }
  public void JungleSocksTestCase1() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("line_item_quantity_zebra")).clear();
	    driver.findElement(By.id("line_item_quantity_zebra")).sendKeys("9");
	    driver.findElement(By.id("line_item_quantity_lion")).clear();
	    driver.findElement(By.id("line_item_quantity_lion")).sendKeys("0");
	    driver.findElement(By.id("line_item_quantity_elephant")).clear();
	    driver.findElement(By.id("line_item_quantity_elephant")).sendKeys("0");
	    driver.findElement(By.id("line_item_quantity_giraffe")).clear();
	    driver.findElement(By.id("line_item_quantity_giraffe")).sendKeys("0");
	    new Select(driver.findElement(By.name("state"))).selectByVisibleText("California");
	    driver.findElement(By.name("commit")).click();
	    try {
	      assertFalse(isAlertPresent());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("$117.00", driver.findElement(By.id("subtotal")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("$9.36", driver.findElement(By.id("taxes")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("$126.36", driver.findElement(By.id("total")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	   
	  }
  
  @Test
//{state : 'ny' , value : 0.06 }
  public void JungleSocksTestCase2() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("line_item_quantity_zebra")).clear();
    driver.findElement(By.id("line_item_quantity_zebra")).sendKeys("0");
    driver.findElement(By.id("line_item_quantity_lion")).clear();
    driver.findElement(By.id("line_item_quantity_lion")).sendKeys("8");
    driver.findElement(By.id("line_item_quantity_elephant")).clear();
    driver.findElement(By.id("line_item_quantity_elephant")).sendKeys("0");
    driver.findElement(By.id("line_item_quantity_giraffe")).clear();
    driver.findElement(By.id("line_item_quantity_giraffe")).sendKeys("0");
    new Select(driver.findElement(By.name("state"))).selectByVisibleText("New York");
    driver.findElement(By.name("commit")).click();
    try {
      assertFalse(isAlertPresent());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("$160.00", driver.findElement(By.id("subtotal")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("$9.60", driver.findElement(By.id("taxes")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("$169.60", driver.findElement(By.id("total")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
   
  }
  
  @Test
//{state : 'mn' , value : 0.00 }
  public void JungleSocksTestCase3() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("line_item_quantity_zebra")).clear();
    driver.findElement(By.id("line_item_quantity_zebra")).sendKeys("0");
    driver.findElement(By.id("line_item_quantity_lion")).clear();
    driver.findElement(By.id("line_item_quantity_lion")).sendKeys("0");
    driver.findElement(By.id("line_item_quantity_elephant")).clear();
    driver.findElement(By.id("line_item_quantity_elephant")).sendKeys("6");
    driver.findElement(By.id("line_item_quantity_giraffe")).clear();
    driver.findElement(By.id("line_item_quantity_giraffe")).sendKeys("0");
    new Select(driver.findElement(By.name("state"))).selectByVisibleText("Minnesota");
    driver.findElement(By.name("commit")).click();
    try {
      assertFalse(isAlertPresent());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("$210.00", driver.findElement(By.id("subtotal")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
    	
      assertEquals("$0.00", driver.findElement(By.id("taxes")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("$210.00", driver.findElement(By.id("total")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }  
  } 

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
 }
