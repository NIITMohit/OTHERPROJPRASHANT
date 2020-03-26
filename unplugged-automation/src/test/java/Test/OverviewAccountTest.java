package Test;

import io.restassured.response.Response;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import API.ApiRead;
import Pages.CommonElements;
import Pages.CreateAccountOverviewPage;
import Utilities.CommonMethods;
import Utilities.PropertyReaderUtility;
import Utilities.ReadExcelFile;
import Utilities.Reporting;
import Utilities.WindowsCapabilitie;

public class OverviewAccountTest extends WindowsCapabilitie {

	CreateAccountOverviewPage caop = null;
	CommonElements ce = null;
	CommonMethods cm = null;

	@Test()
	public void createAccountOverview(ITestContext context) throws IOException,
			InterruptedException, ParseException {

		caop = new CreateAccountOverviewPage(driver);
		ce = new CommonElements(driver);
		cm = new CommonMethods();

		service.start();
		cm.selectAccount(context);

		cm.waitForLoader();

		ce.overview_Button.click();
		cm.waitForLoader();
		ApiRead api = new ApiRead(PropertyReaderUtility.getPropertyVal(
				"UserAPI",
				context.getCurrentXmlTest().getParameter("accountType")
						+ ".properties"), PropertyReaderUtility.getPropertyVal(
				"PasswordAPI",
				context.getCurrentXmlTest().getParameter("accountType")
						+ ".properties"));
		Response res = api.getRsAccountOverview();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String chkoutDate = api.getLastEnrollmentDate(res,
				PropertyReaderUtility.getPropertyVal("Account", context
						.getCurrentXmlTest().getParameter("accountType")
						+ ".properties"));
		Reporting.logsGeneration("Check for Overview heading");
		String header = caop.checkedOutAccountOverviewHeading.getText();
		Assert.assertEquals(header, "Account summary");

		String accountNameField = caop.checkedOutAccountName_Value.getText();

		CommonMethods.compareElementsText(caop.checkedOutAccountName_Value, api
				.getAccountname(res, PropertyReaderUtility.getPropertyVal(
						"Account",
						context.getCurrentXmlTest().getParameter("accountType")
								+ ".properties")));
		Reporting.passLogsGeneration("Check for Account Name comparing with "
				+ accountNameField
				+ " and "
				+ api.getAccountname(res, PropertyReaderUtility.getPropertyVal(
						"Account",
						context.getCurrentXmlTest().getParameter("accountType")
								+ ".properties")));
		Date d = sdf.parse(chkoutDate);
		sdf.applyPattern("MM/dd/yyyy");
		String checkOutDate = sdf.format(d);
		String lastEnrollDate = sdf.format(sdf.parse(sdf.format(DateUtils
				.addDays(d, 30))));
		String checkInDate = sdf.format(sdf.parse(sdf.format(DateUtils.addDays(
				d, 90))));

		CommonMethods.compareElementsText(caop.checkedOutAccountDate_Value,
				checkOutDate);

		CommonMethods.compareElementsText(
				caop.checkedOutAccountEnrollLastDate_Value, lastEnrollDate);

		CommonMethods.compareElementsText(caop.checkedInAccountDate_Value,
				checkInDate);

		ce.back_AccountListLandingPage.click();
		cm.waitForLoader();

	}
}
