package com.test.WebDriverDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Assert;

import org.junit.*;

public class WebDriverDemo {
	static String result;
	static WebDriver driver = null;
	
	@BeforeClass
	public static void SetUpClass(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\labt_\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	    driver.get("http://www.calculator.net/");
        System.out.println("Started session");
	}
	
	@Test
	public void TestCalc(){
	  try {
	      driver.findElement(By.xpath(".//*[@id = 'contentout']/table/tbody//tr/td/table/tbody/tr[2]/td[2]/div/div[3]/span[2]")).click();	            
	      driver.findElement(By.xpath(".//*[@id = 'contentout']/table/tbody//tr/td/table/tbody/tr[2]/td[2]/div/div[4]/span[4]")).click();     	      
	      driver.findElement(By.xpath(".//*[@id = 'contentout']/table/tbody//tr/td/table/tbody/tr[2]/td[2]/div/div[3]/span[3]")).click();
	
	      String result =
	         driver.findElement(By.xpath(".//*[@id = 'contentout']/table/tbody/tr/td/table/tbody/tr/td/div/div[2]")).getText();

	      System.out.println(" The Result is " + result);
	      	      
	      double expected = 0.6666666667;
	      double actual = Double.parseDouble(result);
	      Assert.assertEquals(expected,actual,0.0001); //assert
	      
	  } catch (Exception e){
		  System.out.println(e.getMessage());
	  }
	 
	}
	
	@AfterClass
    public static void 	TearDownClass() {
		if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + "passed");
            System.out.println("TearDown is called");
            driver.quit();
        }
		else {
			System.out.println("TearDown is not called");
		}
    }
}
