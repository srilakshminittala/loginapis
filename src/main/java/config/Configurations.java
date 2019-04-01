package config;

import java.util.ArrayList;
import java.util.List;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import utils.Validator;

public class Configurations {


	private static final String ACCEPT = "application/json";
	private static final String CONTENT_TYPE = "application/json;charset=UTF-8";
	
	// read this parameter from the configuration file or TestNG ContextManager
	public static final String ENDPOINT_VALIDATE = "https://api-dev.bluecrewjobs.com/v1/noauth/user/validate";
	public static final String ENDPOINT_LOGIN = "http://api-dev.bluecrewjobs.com/v1/noauth/user/login";
	public static final String ENDPOINT_CREATE = "http://api-dev.bluecrewjobs.com/v1/noauth/user/create";
	
	// populate headers only once
	public static Headers headers;
	static {
		Header h1 = new Header("Accept", ACCEPT);
		Header h2 = new Header("Content-Type", CONTENT_TYPE);
		List<Header> list = new ArrayList<Header>();
		list.add(h1);
		list.add(h2);
		headers = new Headers(list);
	}
    //instatiate validator once
	public static Validator validator;
	static {
		validator = new Validator();
	}
	
}
