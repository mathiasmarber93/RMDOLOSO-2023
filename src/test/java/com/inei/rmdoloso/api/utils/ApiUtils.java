package com.inei.rmdoloso.api.utils;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;

import java.util.Map;

public class ApiUtils {

    public static int responseCode;

    public static void sendGetRequest(String apiUrl) {
        SerenityRest.given().relaxedHTTPSValidation()
                .when()
                .get(apiUrl);
        responseCode = SerenityRest.then().extract().statusCode();
    }

    public static void sendPostRequest(String apiUrl, Map<String, String> requestBody) {
        SerenityRest.given().relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .body(requestBody).log().all()
                .post(apiUrl);
        responseCode = SerenityRest.then().extract().statusCode();
    }

}
