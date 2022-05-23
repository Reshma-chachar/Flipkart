package utility;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumbermap.ConfigReader;

public class SeleniumOperations1
{
 
	public static WebDriver driver=null;  
	public static ConfigReader config=null;
	
	public static Hashtable<String,Object> outputParameters=new Hashtable<String,Object>();
	
	//browserLaunch
	public static Hashtable<String,Object>  browserLaunch(Object[]inputParameters)
		{
		try{
		String strBrowserName=(String) inputParameters[0];
		
		 config=new ConfigReader();
		
		if(strBrowserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",config.getDriverPathChrome());
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
		}
		else if(strBrowserName.equalsIgnoreCase("FF"))
		{
			System.setProperty("webdriver.gecko.driver", config.getDriverPathFF());
			   driver=new FirefoxDriver();	
			   driver.manage().window().maximize();
			   driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
		}
			
		 outputParameters.put("STATUS", "PASS");
		 outputParameters.put("MESSAGE", "methodUsed:browserLaunch, Input_Data : " + inputParameters[0].toString());
		
		}catch(Exception e)
		{			
			 outputParameters.put("STATUS", "FAIL");
			 outputParameters.put("MESSAGE", "methodUsed:browserLaunch, Input_Data : " + inputParameters[0].toString());
		}
		return outputParameters;				
		}
	//openApplication
	     public static Hashtable<String,Object> openApplication()
	     {
	    	 try{
	    		
	    		   		
	    		driver.get(config.getApplicationUrl());
	    		driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
	    		
	    		 outputParameters.put("STATUS", "PASS");
	    		 outputParameters.put("MESSAGE", "methodUsed:openApplication, Input_Data : " + config.getApplicationUrl().toString());		
	    	    }catch(Exception e)
	 	     	{	
	    	    	 outputParameters.put("STATUS", "FAIL");
		    		 outputParameters.put("MESSAGE", "methodUsed:openApplication, Input_Data : " + config.getApplicationUrl().toString());
	 	    	}
	    	 
	    	 return outputParameters;
	     }
		
	//clickOnElement
	     public static Hashtable<String,Object> clickOnElement(Object[]inputParameters)
	     {
	    	 try{
	    		String xpath=(String) inputParameters[0];    		
	    		driver.findElement(By.xpath(xpath)).click();
	    		driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
	    		
	    		 outputParameters.put("STATUS", "PASS");
	    		 outputParameters.put("MESSAGE", "methodUsed:clickOnElement, Input_Data : " + inputParameters[0].toString());
	        	 }
	    	    catch(Exception e)
	 	    	{	
	    	    	outputParameters.put("STATUS", "FAIL");
		    		 outputParameters.put("MESSAGE", "methodUsed:clickOnElement, Input_Data : " + inputParameters[0].toString());
	 	    	}
	    	 
	    	 return outputParameters;
	     }	
	     
	     //movetoElement
	     public static Hashtable<String,Object> moveToElement(Object[]inputParameters)
	     {
	    	 try{
	    		String xpath=(String) inputParameters[0];	
	    		Actions act=new Actions(driver);	    		
	    		WebElement element=driver.findElement(By.xpath(xpath));	    		
	    		act.moveToElement(element).build().perform();
	    		driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
	    	    
	    		 outputParameters.put("STATUS", "PASS");
	    		 outputParameters.put("MESSAGE", "methodUsed:moveToElement, Input_Data : " + inputParameters[0].toString());
	    	 
	    	 }
	    	    catch(Exception e)
	 		    {
	    	    	 outputParameters.put("STATUS", "FAIL");
		    		 outputParameters.put("MESSAGE", "methodUsed:moveToElement, Input_Data : " + inputParameters[0].toString());
	      		}
	    	 return outputParameters;	
	     }
	
	     
	     public static Hashtable<String,Object> sendKey(Object[] inputParameters)         //2 parameter
		 {
			try{
			 String xpath1=(String)inputParameters[0];
			String value1=(String)inputParameters[1];  		                   //pinCode int
			driver.findElement(By.xpath(xpath1)).sendKeys(value1);
			driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
			
			 outputParameters.put("STATUS", "PASS");
			 outputParameters.put("MESSAGE", "methodUsed:sendKey, Input_Data : " + inputParameters[1].toString());
			}
			catch(Exception e)
			 {				
				 outputParameters.put("STATUS", "FAIL");
				 outputParameters.put("MESSAGE", "methodUsed:sendKey, Input_Data : " + inputParameters[1].toString());
		  	 }	
			
			return outputParameters;
		 } 
	     
	     public static Hashtable<String,Object>  validation(Object[] inputParameters) //2 parameter
		 {
			try{
			 String givenText=(String)inputParameters[0];     // Ganesh Gandal
			String xpath=(String)inputParameters[1];  		  // xpath of above text
			
			String  text=driver.findElement(By.xpath(xpath)).getText();
			
			if(givenText.equalsIgnoreCase(text))
			{
				System.out.println("Test case Pass");
			}else 
			{
				System.out.println("Test case Fail");
			}
			
			 outputParameters.put("STATUS", "PASS");
			 outputParameters.put("MESSAGE", "methodUsed:validationLogin, Input_Data : " + inputParameters[0].toString());
			 }catch(Exception e)
			 {				
				 outputParameters.put("STATUS", "FAIL");
				 outputParameters.put("MESSAGE", "methodUsed:validationLogin, Input_Data : " + inputParameters[0].toString());
		  	 }	
			return outputParameters;
		 }
	
	    
	   
	
	     
}
