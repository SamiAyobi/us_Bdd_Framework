package step.definitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import core.Base;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.RetailScenariosPage;
import utilities.Util;

public class RetailStepDefinitions extends Base {
	RetailScenariosPage retail = new RetailScenariosPage();
	
	@When("User click on Register for an Affiliate Account link")
	public void user_click_on_register_for_an_affiliate_account_link() {
		retail.clickonRegisterLink();
		logger.info("user clicked on Register for an Affiliate Account Link");

	}
	@When("User fill affiliate form with below information")
	public void user_fill_affiliate_form_with_below_information(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String,String>> affiliateinformation = dataTable.asMaps(String.class,String.class);
		retail.enterCompanyName(affiliateinformation.get(0).get("company"));
		retail.enterWebSiteName(affiliateinformation.get(0).get("website"));
		retail.enterTaxId(affiliateinformation.get(0).get("taxID"));
		retail.selectPaymentMethod(affiliateinformation.get(0).get("paymentMethod"));
		retail.enterPayeeName(affiliateinformation.get(0).get("payeeName"));
		logger.info("user filled affiliate form with required information");
		Util.takeScreenShot();
		
		
	}
	@When("User check on About us check box")
	public void user_check_on_about_us_check_box() {
		retail.clickOnAboutUs();
		logger.info("user check on About us Check box");

	}
	@When("User click on Continue button")
	public void user_click_on_continue_button() {
		retail.clickOnContinueButton();
		logger.info("user clicked on Continue button");

	}
	@Then("User should see a success message")
	public void user_should_see_a_success_message() {
		Assert.assertTrue(retail.successMessageVerification());
		logger.info("Success message verified");
		Util.takeScreenShot();

	}
	
	@When("User click on Edit your affiliate informationlink")
	public void user_click_on_edit_your_affiliate_informationlink() {
		retail.editAffiliateInformation();
	}
	@When("user click on Bank Transfer radio button")
	public void user_click_on_bank_transfer_radio_button() {
		retail.selectPaymentMethod("bankTransfer");
	}
	@When("User fill Bank information with below information")
	public void user_fill_bank_information_with_below_information(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String,String>> bankinformation = dataTable.asMaps(String.class,String.class);
		retail.enterBankName(bankinformation.get(0).get("bankName"));
		retail.enterABABranchName(bankinformation.get(0).get("abaNumber"));
		retail.enterSwiftCode(bankinformation.get(0).get("swiftCode"));
		retail.enterAccountName(bankinformation.get(0).get("accountName"));
		retail.enterAccountNumber(bankinformation.get(0).get("accountNumber"));
		
	}
	
	@When("User click on Edit your account information link")
	public void user_click_on_edit_your_account_information_link() {
		retail.clickOnEditPersonalInformation();

	}
	@When("User modify below information")
	public void user_modify_below_information(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String,String>>  personalInformation = dataTable.asMaps(String.class,String.class);
		retail.enterFirstName(personalInformation.get(0).get("firstname"));
		retail.enterLastName(personalInformation.get(0).get("lastName"));
		retail.enterEmail(personalInformation.get(0).get("email"));
		retail.enterTelephone(personalInformation.get(0).get("telephone"));
		Util.takeScreenShot();
	}

	@Then("User should see a message {string}")
	public void user_should_see_a_message(String expectedMessage) {
		Assert.assertEquals(expectedMessage, retail.actualSucessMessage());
		logger.info("user should see success message");

	}


}
