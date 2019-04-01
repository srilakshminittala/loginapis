package utils;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.response.Response;
import validator.IValidator;

public class Validator implements IValidator {

	@Override
	public void validate(Response res, String expectedCode, String code, String message) {

		Map<String, String> expected = new LinkedHashMap<>();
		expected.put(code, message);
		Map<String, String> actual = new LinkedHashMap<>();
		JSONObject json = new JSONObject(res.body().asString());
		json.keySet().forEach(k -> {
			Object v = json.get(code);
			actual.put(code, v.toString());

		});
		Assert.assertEquals(Integer.toString(res.getStatusCode()), expectedCode);
		Assert.assertEquals(actual, expected);
	}

	@Override
	public void loginSuccessvalidate(Response res, String expectedCode, String messageCode) {

		JSONObject json = new JSONObject(res.body().asString());

		if (json.has(expectedCode)) {
			Assert.assertTrue(true);
			System.out.println(json.getString(expectedCode));
		}

		Assert.assertEquals(Integer.toString(res.getStatusCode()), expectedCode);

	}

}
