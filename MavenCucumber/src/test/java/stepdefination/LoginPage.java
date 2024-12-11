package stepdefination;



import io.cucumber.java.en.*;
import io.cucumber.java.en.Given;

public class LoginPage {
	
	@Given("The user navigates to the login page")
	public void the_user_navigates_to_the_login_page() {
	    System.out.println("---> user has navigated to login page...");
	}
	
	@When("The user enters valid email {string}")
	public void the_user_enters_valid_email(String userName) {
		System.out.println("---> user has entered valid email  : " + userName);
	}

	@And("Enter valid password {string}")
	public void enter_valid_password(String userpassword) {
		System.out.println("---> user has entered valid password : " + userpassword);
	}

	@And("Clicks the login button")
	public void clicks_the_login_button() {
		System.out.println("---> user has clicked the login button");
	}

	@Then("The user should be redirected to the dashboard")
	public void the_user_should_be_redirected_to_the_dashboard() {
		System.out.println("---> Logedin user has redirected to the dashboard");
	}

	
	 //invalid emails and valid password
	
	@When("The user enters invalid email {string}")
	public void the_user_enters_invalid_email(String userName)
	{
		System.out.println("---->user has entered invalid password :"+userName);
	}
	
	@And("Enter invalid password {string}")
	public void enter_the_valid_password(String password)
	{
		System.out.println("--->user has entered valid password");
	}
	@Then("An error message Invalid username or password should be displayed")
	public void error_message_displayed()
	{
		System.out.println("--->error msg is displayed");
	}
	
	//invalid user and invalid password credentials 
	
	@Then("user should get proper warning message")
	public void user_should_get_proper_warning_message()
	{
		System.out.println("--->user get proper warning msg");
	}
 
}
