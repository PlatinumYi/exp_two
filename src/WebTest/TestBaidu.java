package WebTest;

import java.util.regex.Pattern;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(Parameterized.class)
public class TestBaidu {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  private StudentInformation studentInformation;
  
  @Parameters
  public static Collection<StudentInformation> getData(){
	  
	  FileParser fileParser = new FileParser();
	  return fileParser.getInformation();
	  
  }
  
  public TestBaidu( StudentInformation studentInformation ) {
    this.studentInformation = studentInformation ;
  }
  @Before
  public void setUp() throws Exception {
	  String driverPath = System.getProperty("user.dir") + "/src/geckodriver.exe";
	  System.setProperty("webdriver.gecko.driver", driverPath);
	  FirefoxOptions options = new FirefoxOptions();
      options.addArguments("--headless");
      options.addArguments("--disable-gpu");
      driver = new FirefoxDriver(options);
	 // driver = new FirefoxDriver();
	  baseUrl = "http://121.193.130.195:8800";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBaidu() throws Exception {
	  
    driver.get(baseUrl + "/login");
    WebElement idElement = driver.findElement(By.name("id"));
    driver.findElement(By.name("id")).clear();
    driver.findElement(By.name("id")).sendKeys(studentInformation.getStudentNumber());
    WebElement passwordElement = driver.findElement(By.name("password"));
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(studentInformation.getPassword());
    WebElement buttonElement = driver.findElement(By.id("btn_login"));
    buttonElement.click();
    
    WebElement nameElement = driver.findElement(By.id("student-name"));
    String name = nameElement.getText();
    WebElement realIdElement = driver.findElement(By.id("student-id"));
    String id = realIdElement.getText();
    WebElement gitElement = driver.findElement(By.id("student-git"));
    String git = gitElement.getText();
    assertEquals(studentInformation.getName(),name);
    assertEquals(studentInformation.getStudentNumber(),id);
    assertEquals(studentInformation.getGitLocation(),git);
    
    driver.close();
    
  }
 

}

