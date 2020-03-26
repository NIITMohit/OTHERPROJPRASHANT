package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang3.time.DateUtils;

import Utilities.PropertyReaderUtility;

public class ApiRead {
	public static String baseUri = "https://mon-qa.empoweredbenefits.com/";
	public static String cookie;
	public static String userName = "";
	public static String passWord = "";

	/*
	 * static { Response tokenResponse = RestAssured.given().baseUri(baseUri)
	 * .header("content-type", "application/json") .get("api/auth/csrf"); cookie
	 * = tokenResponse.getCookie("SESSIONID");
	 * RestAssured.given().baseUri(baseUri).urlEncodingEnabled(false)
	 * .header("content-type", "application/json") .header("X-CSRF-TOKEN",
	 * tokenResponse.jsonPath().get("token")) .cookies("SESSIONID",
	 * cookie).auth().preemptive() .basic(userName,
	 * passWord).post("api/auth/login"); }
	 */
	/*public static void main(String[] args) throws ParseException {
		ApiRead api=new ApiRead("ruby_howell@us.aflacqa.com", "test");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Response res=api.getRsAccountOverview();
		String chkoutDate=api.getLastEnrollmentDate(res,"E1G23");
		Date d=sdf.parse(chkoutDate);
		sdf.applyPattern("MM/dd/yyyy");
		System.out.println(sdf.format(d));
		System.out.println(sdf.format(sdf.parse(sdf.format(DateUtils.addDays(d, 30)))));
		System.out.println(sdf.format(sdf.parse(sdf.format(DateUtils.addDays(d, 90)))));
		System.out.println(api.getAccountname(res, "E1G23"));
		
	}*/

	public ApiRead(String username, String password) {
		userName = username;
		passWord = password;
		Response tokenResponse = RestAssured.given().baseUri(baseUri)
				.header("content-type", "application/json")
				.get("api/auth/csrf");
		cookie = tokenResponse.getCookie("SESSIONID");
		RestAssured.given().baseUri(baseUri).urlEncodingEnabled(false)
				.header("content-type", "application/json")
				.header("X-CSRF-TOKEN", tokenResponse.jsonPath().get("token"))
				.cookies("SESSIONID", cookie).auth().preemptive()
				.basic(userName, passWord).post("api/auth/login");
	}

	public Response getRsAccountOverview() {
		Response response = RestAssured.given().baseUri(baseUri)
				.header("content-type", "application/json")
				.header("MP-DeviceIdentifier", "testdevice-12345")
				.cookies("SESSIONID", cookie).get("api/apptaker/accountList");
		return response;
	}
	
	public String getLastEnrollmentDate(Response response,String accountNumber) throws ParseException {
		String date="";
		ArrayList accountList = response.jsonPath().get();
		for (int i = 0; i < accountList.size(); i++) {
			if (accountNumber.equals(((HashMap) accountList.get(i)).get(
					"groupNumber").toString())) {
				// enrollmentWindowStartDate
				date= ((HashMap) accountList.get(i)).get("enrollmentWindowStartDate")
						.toString();
			}
		}	
		return date;
	}
	public String getAccountname(Response response,String accountNumber) {
		String accountName="";
		ArrayList accountList = response.jsonPath().get();
		for (int i = 0; i < accountList.size(); i++) {
			if (accountNumber.equals(((HashMap) accountList.get(i)).get(
					"groupNumber").toString())) {
				accountName= ((HashMap) accountList.get(i)).get("name")
						.toString();
			}
		}	
		return accountName;
	}

	public ArrayList getPlansForProducts(Response planResponse, String product) {
		ArrayList planList = new ArrayList();
		ArrayList listOfPlans = planResponse.jsonPath().get();
		for (int i = 0; i < listOfPlans.size(); i++) {
			if (((HashMap) ((HashMap) ((HashMap) listOfPlans.get(i))
					.get("plan")).get("product")).get("adminName").equals(
					product)) {
				planList.add(((HashMap) ((HashMap) listOfPlans.get(i))
						.get("plan")).get("name"));
			}
		}
		return planList;
	}

	public Response getPlanRs(String enrollmentMethod, String enrollmentState,
			String age, String payrollFrequencyId, String group,
			String residenceState) {
		Response planResponse = RestAssured
				.given()
				.baseUri(baseUri)
				.header("content-type", "application/json")
				.header("mp-group", group)
				.cookies("SESSIONID", cookie)
				.get("api/enrollment/shopping/plans?enrollmentMethod="
						+ enrollmentMethod
						+ "&expand=plan.productId&enrollmentState="
						+ enrollmentState + "&age=" + age + "&residenceState="
						+ residenceState + "&payrollFrequencyId="
						+ payrollFrequencyId + "");
		return planResponse;
	}

	public Response getRsByMemberId(String enrollmentMethod,
			String enrollmentState, int memberId, int group) {
		Response planResponse = RestAssured
				.given()
				.baseUri(baseUri)
				.header("content-type", "application/json")
				.header("mp-group", group)
				.cookies("SESSIONID", cookie)
				.get("api/enrollment/shopping/plans?enrollmentMethod="
						+ enrollmentMethod
						+ "&expand=plan.productId&enrollmentState="
						+ enrollmentState + "&memberId=" + memberId);
		return planResponse;
	}

	public ArrayList getProducts(int group) {
		ArrayList productsList = new ArrayList();
		Response response = RestAssured.given().baseUri(baseUri)
				.header("content-type", "application/json")
				.header("mp-group", group).cookies("SESSIONID", cookie)
				.get("api/enrollment/shopping/products");
		ArrayList products = response.jsonPath().get();
		for (int i = 0; i < products.size(); i++) {
			productsList.add(((HashMap) ((HashMap) products.get(i))
					.get("product")).get("adminName"));
		}
		return productsList;
	}

	public Response getAccountName() {
		Response response = RestAssured.given().baseUri(baseUri)
				.header("content-type", "application/json")
				.cookies("SESSIONID", cookie).get("api/accountList");
		return response;
	}

	public int getAccountId(String accountName, ApiRead api) {
		int accountId = 0;
		Response response = api.getAccountName();
		ArrayList content = response.jsonPath().get("content");
		for (int i = 0; i < content.size(); i++) {
			if (((HashMap) content.get(i)).get("groupNumber") != null) {
				if (((HashMap) content.get(i)).get("groupNumber").toString()
						.equals(accountName)) {
					accountId = (int) ((HashMap) content.get(i)).get("id");
				}
			}
		}

		return accountId;
	}

	public Response getRsEmployees(int groupId) {
		Response response = RestAssured.given().baseUri(baseUri)
				.header("content-type", "application/json")
				.header("mp-group", groupId).cookies("SESSIONID", cookie)
				.get("api/members/search");
		return response;
	}

	public Response getApplicationsFlow(String groupId, String memberId) {
		Response response = RestAssured
				.given()
				.baseUri(baseUri)
				.header("content-type", "application/json")
				.header("mp-group", groupId)
				.cookies("SESSIONID", cookie)
				.get("api/enrollment/checkout/applications?memberId="
						+ memberId);
		return response;

	}

	public void getAnswersOnPage(Response res) {

	}

	public int getMemberId(String groupId, String lastName) {
		int memberId = 0;
		Response response = RestAssured.given().baseUri(baseUri)
				.header("content-type", "application/json")
				.header("mp-group", groupId).cookies("SESSIONID", cookie)
				.get("api/members/search");
		ArrayList content = response.jsonPath().get("content");
		for (int i = 0; i < content.size(); i++) {
			if (((HashMap) content.get(i)).get("lastName").toString()
					.equals(lastName)) {
				return (int) ((HashMap) content.get(i)).get("id");
			}
		}
		return memberId;
	}

	public Response getMemberDetailsResponse(String groupId, int memberId) {
		Response response = RestAssured.given().baseUri(baseUri)
				.header("content-type", "application/json")
				.header("mp-group", groupId).cookies("SESSIONID", cookie)
				.get("api/members/" + memberId + "?fullProfile=true");
		return response;
	}

	public Response getMemberContactDetails(String groupId, int memberId) {
		Response response = RestAssured.given().baseUri(baseUri)
				.header("content-type", "application/json")
				.header("mp-group", groupId).cookies("SESSIONID", cookie)
				.get("api/members/" + memberId + "/contacts");
		return response;
	}

	public Response getMemberWorkInfoRes(String groupId, int memberId) {
		Response response = RestAssured.given().baseUri(baseUri)
				.header("content-type", "application/json")
				.header("mp-group", groupId).cookies("SESSIONID", cookie)
				.get("api/members/" + memberId + "/contacts/WORK");
		return response;
	}

	public Response getDependentDetails(String groupId, int memberId) {
		Response response = RestAssured
				.given()
				.baseUri(baseUri)
				.header("content-type", "application/json")
				.header("mp-group", groupId)
				.cookies("SESSIONID", cookie)
				.get("api/members/" + memberId + "/dependents?fullProfile=true");
		return response;
	}

	public Response getDependentRelation(String groupId) {
		Response response = RestAssured.given().baseUri(baseUri)
				.header("content-type", "application/json")
				.header("mp-group", groupId).cookies("SESSIONID", cookie)
				.get("api/account/dependentRelations");
		return response;
	}

	public Response getDependentAddress(String groupId, int memberId,
			int dependentId) {
		Response response = RestAssured
				.given()
				.baseUri(baseUri)
				.header("content-type", "application/json")
				.header("mp-group", groupId)
				.cookies("SESSIONID", cookie)
				.get("api/members/" + memberId + "/dependents/" + dependentId
						+ "/contact");
		return response;
	}

	public String getRelationShip(Response response, int relationshipId) {
		ArrayList list = response.jsonPath().get();
		for (int i = 0; i < list.size(); i++) {
			if (((int) ((HashMap) list.get(i)).get("id")) == relationshipId) {
				return ((HashMap) list.get(i)).get("name").toString();
			}
		}
		return null;
	}

	public Response getBeneficiaryRes(String groupId, int memberId) {
		Response response = RestAssured
				.given()
				.baseUri(baseUri)
				.header("content-type", "application/json")
				.header("mp-group", groupId)
				.cookies("SESSIONID", cookie)
				.get("api/members/" + memberId
						+ "/beneficiaries?fullProfile=true");
		return response;
	}

	public Response getCoverageSummaryRes(String groupId, int memberId) {
		Response response = RestAssured.given().queryParams("expand", "planId")
				.queryParam("includePerPayPeriodCosts", true).baseUri(baseUri)
				.header("content-type", "application/json")
				.header("mp-group", groupId).cookies("SESSIONID", cookie)
				.get("api/members/" + memberId + "/enrollments/search");
		return response;
	}

	public Response getEnrolledPlansResponse(String groupId, int memberId) {
		String parvalue = "planId,productId,currentEnrollmentId,coverageLevelId";
		Response response = RestAssured.given().urlEncodingEnabled(true)
				.baseUri(baseUri).queryParam("includePerPayPeriodCosts", true)
				.queryParam("expand", parvalue).urlEncodingEnabled(false)
				.header("content-type", "application/json")
				.header("mp-group", groupId).cookies("SESSIONID", cookie)
				.get("api/members/" + memberId + "/enrollments/search");
		return response;
	}

}
