package stepdefinitions;


import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.Driverfactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private static String title;
	private LoginPage loginpage = new LoginPage(Driverfactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {
		Driverfactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");		
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginpage.getLoginTitle();
		System.out.println("Title of the page is : "+ title);	
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String ExpectedTitle) {
		Assert.assertTrue(title.contains(ExpectedTitle));
	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
		Assert.assertTrue(loginpage.checkforgetpwdLink());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginpage.EnterEmail(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {
		loginpage.EnterPwd(pwd);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginpage.ClickonSignInBtn();
	}

}
