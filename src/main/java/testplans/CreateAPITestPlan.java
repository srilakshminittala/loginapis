package testplans;

import org.json.JSONObject;
import org.testng.annotations.Test;
import config.Configurations;
import config.DataProviderr;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class CreateAPITestPlan {

	@Test(dataProvider = "createAPIInput", dataProviderClass = DataProviderr.class, alwaysRun = true)
	public void createTestPlan(String phone, String userName, String pwd, String zip, String firstName, String lastName,
			int verificationCode, String expectedResponseCode, String messagecode, String message, String caseType) {

		RequestSender req = buildCreateRequest(phone, userName, pwd, zip, firstName, lastName, verificationCode);
		// calling request method and returning the response.

		Response response = req.request(Method.POST);
		if (caseType.equalsIgnoreCase("success")) {

			Configurations.validator.loginSuccessvalidate(response, expectedResponseCode, messagecode);
		} else {
			System.out.println(response.body().asString());
			Configurations.validator.validate(response, expectedResponseCode, messagecode, message);
		}

	}

	private RequestSender buildCreateRequest(String phone, String userName, String pwd, String zip, String firstName,
			String lastName, int verificationCode) {
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = Configurations.ENDPOINT_CREATE;

		// To avoid ssl certificate error
		RestAssured.useRelaxedHTTPSValidation();

		// adding headers

		RequestSpecification request = RestAssured.given();

		request.headers(Configurations.headers);

		// adding requestPayload
		return request
				.body(addCreatePayload(phone, userName, pwd, zip, firstName, lastName, verificationCode).toString());

	}

	private JSONObject addCreatePayload(String phone, String userName, String pwd, String zip, String firstName,
			String lastName, int verificationCode) {

		JSONObject payload = new JSONObject();
		payload.put("allowJsonError", true);
		payload.put("branchParams", "");
		payload.put("phone", phone);
		payload.put("referrer", "");
		payload.put("referrerCode", "");
		payload.put("signUps", "BlewCrew");
		payload.put("source", "");
		payload.put("username", userName);
		payload.put("password", pwd);
		payload.put("verificationCode", verificationCode);
		payload.put("firstName", firstName);
		payload.put("lastName", lastName);
		payload.put("zipcode", zip);
		payload.put("tos", true);
		return payload;

	}

}
