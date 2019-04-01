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

class ValidateTestPlan {

	

	@Test(dataProvider = "validateAPIInput", dataProviderClass = DataProviderr.class, alwaysRun = true)
	public void validateAPI(String phone, String userName, String pwd, String zip, String expectedCode, String errorCode,
			String errorMessage) {

		RequestSender req = buildRequest(phone, userName, pwd, zip);
		// calling request method and returning the response.

		Response response = req.request(Method.POST);
		
		Configurations.validator.validate(response, expectedCode, errorCode, errorMessage);

	}


	private RequestSender buildRequest(String phone, String userName, String pwd, String zip) {
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = Configurations.ENDPOINT_VALIDATE;

		// To avoid ssl certificate error
		RestAssured.useRelaxedHTTPSValidation();

		// adding headers

		RequestSpecification request = RestAssured.given();

		request.headers(Configurations.headers);

		// adding requestPayload
		return request.body(addValidatePayload(phone, userName, pwd, zip).toString());

	}



	private JSONObject addValidatePayload(String phone, String userName, String pwd, String zip) {

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
		payload.put("zipcode", zip);

		return payload;

	}

}

