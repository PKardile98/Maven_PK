package Com.healthcare.TestCases;

import org.testng.annotations.Test;

import Com.healthcare.Baseclass.BaseClass_OpenMRS;
import Com.healthcare.Pageclass.Login_MRS;

public class Login_TestClass  extends BaseClass_OpenMRS{

	@Test
	public void Login() {
		
	Login_MRS LG= new Login_MRS(); // Created the obj
	
	LG.Setusername(Username);
	
	LG.SetPassword(Password);
	LG.Wardclick();
	LG.Login_Click();
	
	
	
	
	}
	
}
