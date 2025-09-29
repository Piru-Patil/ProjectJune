package stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.Driverfactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {
	
	private LoginPage loginpage = new LoginPage(Driverfactory.getDriver());
	private AccountsPage accountspage;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
		List<Map<String, String>> cred = credTable.asMaps();
		String Username = cred.get(0).get("username");
		String Password = cred.get(0).get("password");
		
		Driverfactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
		accountspage = loginpage.DoLogin(Username, Password);
		
	}

	@Given("User is on Accounts page")
	public void user_is_on_accounts_page() {
		String title = accountspage.getAccountPageTitle();
		System.out.println("accounts page title is :" + title);
	}

	@Then("user gets the accounts section")
	public void user_gets_the_accounts_section(DataTable sectionsTable) {
		List<String> expectedAccountSectionList = sectionsTable.asList();
		System.out.println("Expected account section list :" + expectedAccountSectionList);
		
		List<String> actualAccountSectionList = accountspage.getAccountSectionList();
		System.out.println("Actual account section list :" + actualAccountSectionList);
		Assert.assertTrue(expectedAccountSectionList.containsAll(actualAccountSectionList));
	}

	@Then("Account section count shoud be {int}")
	public void account_section_count_shoud_be(Integer expectedSectionCount) {
		Assert.assertTrue(accountspage.getAccountSectionCount() == expectedSectionCount);
	}

}
