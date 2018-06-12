package com.revature.test.admin.testclasses;

import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.revature.test.admin.pom.Logout;
import com.revature.test.utils.LoginUtil;
import com.revature.test.utils.TestConfig;
import com.revature.test.utils.WebDriverUtil;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * This is extended by the cuke.java files. This is the runner file for all cucumber tests
 * specified in the glue attribute. All setup before the cucumber tests should be run in the
 * beforesuite method and all shutdown should be run in the aftersuite method
 * @author Jesse (reviewer)
 * @since 6.18.06.07
 */
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/AdminFeatureFiles/Login.feature",
				 glue="src/test/java/test/admin/cukes/LoginCukes.java")
public class AdminSuite extends AbstractTestNGCucumberTests{
	
	public WebDriver wd = null;
	private String baseURL = TestConfig.getBaseURL(); //gets the website URL
	public static Alert alert = null; //creates object to interact with alerts in order to cancel pop ups
	public static Actions action = null;
	
	@BeforeSuite
	public void beforeSuite() {
		wd = new WebDriverUtil().getChromeDriver();
		System.out.println("================== TRACKFORCE TESTS ==================");
		//wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Logging In");
		try {
			Thread.sleep(5000);
			wd.get(baseURL);
			LoginUtil.loginAsAdmin(wd);
		
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Logging out");
		Logout.logout(wd);
		//wd.quit();

	}
}
