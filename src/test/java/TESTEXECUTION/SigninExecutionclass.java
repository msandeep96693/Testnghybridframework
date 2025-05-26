package TESTEXECUTION;

import org.testng.annotations.Test;

import Basepackage.BaseFlow;
import OBJECTPAGE.Loginpage;

public class SigninExecutionclass extends BaseFlow {
	 
	Loginpage login;
	
	@Test
	public void signinpage() throws InterruptedException
	{
		login = new Loginpage(driver);		
		login.signinpage(prop.getProperty("username"), prop.getProperty("password"));
	}
}
