package testplans;

import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;
import config.Configurations;
import config.DataProviderr;

public class LoginTestPlan {

	@Test(dataProvider = "loginAPIInput", dataProviderClass = DataProviderr.class, alwaysRun = true)
	public void LoginAPISuccess(String userName, String pwd, String expectedCode, String messagecode, String message,
			String caseType) {

		RequestSender req = buildLoginRequest(userName, pwd);
		// calling request method and returning the response.

		Response response = req.request(Method.POST);
		if (caseType.equalsIgnoreCase("success")) {

			Configurations.validator.loginSuccessvalidate(response, expectedCode, messagecode);
		} else {
			System.out.println(response.body().asString());
			Configurations.validator.validate(response, expectedCode, messagecode, message);
		}

	}

	private RequestSender buildLoginRequest(String userName, String pwd) {
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = Configurations.ENDPOINT_LOGIN;

		// To avoid ssl certificate error
		RestAssured.useRelaxedHTTPSValidation();

		// adding headers

		RequestSpecification request = RestAssured.given();

		request.headers(Configurations.headers);

		// adding requestPayload
		return request.body(addLoginPayload(userName, pwd).toString());

	}

	private JSONObject addLoginPayload(String userName, String pwd) {

		JSONObject payload = new JSONObject();

		payload.put("username", userName);
		payload.put("password", pwd);

		return payload;

	}
}
