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
		login.emailaddresstextfield();
		login.passwordtextfield();
		login.clickonsigninbutton();
	}
}
