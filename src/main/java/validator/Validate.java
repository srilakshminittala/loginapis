package validator;

import io.restassured.response.Response;

public interface Validate {

	public void validate(Response res, String expectedCode, String code, String message);

	public void loginSuccessvalidate(Response res, String code, String messageCode);

}
