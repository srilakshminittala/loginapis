package config;

import org.testng.annotations.DataProvider;

import utils.RandomGenerator;

public class DataProviderr {

	@DataProvider(name = "validateAPIInput")
	public static Object[][] getValidateData() {

		Object[][] testData = {
				{ RandomGenerator.generatePhoneNumber(), RandomGenerator.generateEmail(), "password123", "94105", "200",
						"needsVerificationCode", "true" },
				{ RandomGenerator.generatePhoneNumber(), "hhh@hh", "password123", "94105", "409", "reason",
						"ER_USERNAME" },
				{ RandomGenerator.generatePhoneNumber(), "lnittala@yahoo.com", "password123", "94105", "409", "reason",
						"ER_DUP_EMAIL" },
				{ RandomGenerator.generatePhoneNumber(), " ", "password123", "94105", "409", "reason", "ER_USERNAME" },
				{ RandomGenerator.generatePhoneNumber(), "lnittala@yahoo.com", "", "94105", "409", "reason",
						"ER_PASSWORD" },
				{ RandomGenerator.generatePhoneNumber(), RandomGenerator.generateEmail(), "hhj", "94", "409", "reason",
						"ER_ZIPCODE" }

		};

		return testData;
	}

	@DataProvider(name = "loginAPIInput")
	public static Object[][] getLoginData() {

		Object[][] testData = { { "lnittala@yahoo.com", "password123", "200", "authToken", "", "success" },

				{ "lnittala@yahoo.com", "pasord123", "403", "reason", "INCORRECT_PASSWORD", "failure" },

				{ "ss@ya.com", "password123", "403", "reason", "INCORRECT_USERNAME", "failure" },

				{ "lnittala@", "password123", "403", "reason", "INCORRECT_USERNAME", "failure" },

				{ "lnittala@ya.com", "d", "403", "reason", "INCORRECT_USERNAME", "failure" },

		};

		return testData;
	}

	@DataProvider(name = "createAPIInput")
	public static Object[][] getCreateData() {

		Object[][] testData = {
				{ "4087027998", RandomGenerator.generateEmail(), "password123", "94105",
						RandomGenerator.generateFirstName(), RandomGenerator.generateLastName(), 1111, "200",
						"authToken", "", "success" },

				{ "4087027998", RandomGenerator.generateEmail(), "password123", "94105",
						RandomGenerator.generateFirstName(), RandomGenerator.generateLastName(), 00, "500", "reason",
						"No verification code provided", "failure" },

				{ "4087027998", "lnittala@yahoo.com", "password123", "94105", RandomGenerator.generateFirstName(),
						RandomGenerator.generateLastName(), 1111, "409", "reason", "Duplicate Username", "failure" },

		};

		return testData;
	}
}
