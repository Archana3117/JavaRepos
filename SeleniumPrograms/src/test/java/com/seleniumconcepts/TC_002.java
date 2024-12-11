package com.seleniumconcepts;

import com.aventstack.extentreports.Status;

public class TC_002 extends BaseTest{
public static void main(String[] args) throws Exception {
	
	BaseTest obj=new BaseTest();
	obj.init("chromebrowser");

    test=report.createTest("TC_002");
    test.log(Status.INFO,"Test report is generated");
    
    test.log(Status.INFO, "Launced the browser :  " + p.getProperty("chromebrowser"));
	
	navigateUrl("amazonurl");
	
	report.flush();
	
}
}
