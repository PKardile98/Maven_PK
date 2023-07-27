package Com.healthcare.TestCases;

import org.testng.annotations.Test;


import Com.healthcare.Baseclass.BaseClass_OpenMRS;
import Com.healthcare.Pageclass.Login_MRS;
import Com.healthcare.Pageclass.Register_Patient;

public class Register_PatientTestclass extends BaseClass_OpenMRS{

	@Test
	public void Enroll_Patient() throws InterruptedException {
		
		Login_MRS LG= new Login_MRS(); // Created the object of the 
		
		LG.Setusername("Admin");
		Thread.sleep(2000);
		LG.SetPassword("Admin123");
		Thread.sleep(2000);
		LG.Wardclick();
		Thread.sleep(2000);
		LG.Login_Click();
		
		Thread.sleep(2000);
		
		Register_Patient RP = new Register_Patient();
		Thread.sleep(2000);
		RP.Click_Register();
		loggers.info("Click on the Register");
		Thread.sleep(2000);
		RP.First_Name("Pradeep");
		loggers.info("Enter the 1st name");
		Thread.sleep(2000);
		RP.Middle_Name("Deelip");
		loggers.info("Enter the middle name");
		Thread.sleep(2000);
		RP.Last_Name("Kardile");
		loggers.info("Enter the Lastname");
		Thread.sleep(2000);
		RP.Forward();
		loggers.info("Next Button");
		
		RP.Gender_T1();
		loggers.info("Select Button");
		
		RP.Forward1();
		loggers.info("Next button 1");
		
		// DOB
		
		RP.Day_click("2");
		loggers.info("Select the date");
		RP.Month_click();
		loggers.info("Select the Month");
		RP.Year_click("1998");
		loggers.info("Select the Year");
		RP.Forward2();
		loggers.info("Next button 2");
		// Address
		
		RP.Address("Pune");
		loggers.info("Address added");
		RP.Forward3();
		loggers.info("Next button 3");
		
		// Phone
		
		RP.Click_Phone("8975725507");
		loggers.info("Enter the phone");
		RP.Forward4();
		loggers.info("Next button 4");
		
		// Relation Person
		
		RP.Relation_R1();
		loggers.info("Relation enter");
		RP.Person_Name("Prashnat");
		loggers.info("Sibling");
//		
		RP.Forward5();
		loggers.info("Next5");
		
		// Submit
		RP.Submit1();
		loggers.info("Submit button");
		
	}
}
