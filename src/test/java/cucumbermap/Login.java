package cucumbermap;

import java.util.Hashtable;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.HTMLReportGenerator;
import utility.SeleniumOperations1;

public class Login 
{

	
	@Given ("^user open \"(.*)\" browser with exe$") 
	   public void browserL(String bname)
	   {
		 Object[] input=new Object[1];
         input[0]=bname;
         SeleniumOperations1.browserLaunch(input);
         		
	   }
	
	@Given ("^user enter url as$")
	public void openURL()
	{ 
		
        SeleniumOperations1.openApplication(); 
	}
	
	
	@Given ("^user cancle initial Login window$")
	public void cancleLogin()
	{
		 Object[] input2=new Object[1];
         input2[0]="//*[@class='_2KpZ6l _2doB4z']";
         SeleniumOperations1.clickOnElement(input2);
	}
	
	@Given ("^user move on Login button$")
	public void move()
	{
		 Object[] input3=new Object[1];
         input3[0]="//*[@class='_28p97w']";
         SeleniumOperations1.moveToElement(input3);
	}
	
	
	@When ("^user click on my profile$")
	public void myProfileClick()
	{
		  Object[] input4=new Object[1];
          input4[0]="//*[text()='My Profile']";
          Hashtable<String, Object> output4= SeleniumOperations1.clickOnElement(input4);
      
HTMLReportGenerator.StepDetails(output4.get("STATUS").toString(), "^user click on my profile$", output4.get("MESSAGE").toString());          
	}
	
	@When ("^user enter \"(.*)\" as username$")
	public void enterUname(String uname) 
	{		
		  Object[] input5=new Object[2];
          input5[0]="(//*[@autocomplete='off'])[2]";
          input5[1]=uname;
          Hashtable<String, Object> output5= SeleniumOperations1.sendKey(input5);
         HTMLReportGenerator.StepDetails(output5.get("STATUS").toString(), "^user enter \"([^\"]*)\" as username$", output5.get("MESSAGE").toString());
	}

	@When ("^user enters \"(.*)\" as password$")
	public void enterPassword(String pass) 
	{
		Object[] input6=new Object[2];
        input6[0]="//*[@type='password']";
        input6[1]=pass;
        Hashtable<String, Object> output6= SeleniumOperations1.sendKey(input6);
        HTMLReportGenerator.StepDetails(output6.get("STATUS").toString(),"^user enter \"([^\"]*)\" as password$", output6.get("MESSAGE").toString());          
	}

	@When("^user click on Login button$")
	public void clickOnLoginB() throws Throwable 
	{
		Thread.sleep(3000);
		  Object[] input7=new Object[1];
          input7[0]="(//*[text()='Login'])[3]";
          Hashtable<String, Object> output7= SeleniumOperations1.clickOnElement(input7);
          HTMLReportGenerator.StepDetails(output7.get("STATUS").toString(),"^user click on Login button$",output7.get("MESSAGE").toString());
	}

	@Then("^Applications shows profile to user$")
	public void validateLogin() 
	{
		Object[] input8=new Object[2];
        input8[0]="GanesH Gandal";
        input8[1]="//*[text()='GanesH Gandal']";
        Hashtable<String, Object> output8= SeleniumOperations1.validation(input8);
        HTMLReportGenerator.StepDetails(output8.get("STATUS").toString(),"^Applications shows profile to user$",output8.get("MESSAGE").toString());
	}


}
