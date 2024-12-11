package com.seleniumconcepts;
import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example6 {
	
	public static void main(String[] args) {
		
		
	
		
		String workingdirname=System.getProperty("user.dir");
		System.out.println("working dir name is"+workingdirname);
		
		String projectname=new File(workingdirname).getName();
		System.out.println("current projectname:"+projectname);
		
		String pkgName=Example6.class.getPackageName();
		System.out.println("current project pakage name is:"+pkgName);
		
	}

}
