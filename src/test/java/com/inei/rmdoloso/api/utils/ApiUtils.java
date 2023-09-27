package com.inei.rmdoloso.api.utils;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;

import java.util.Map;

public class ApiUtils {

    public static int responseCode;

    public static void sendGetRequest(String apiUrl) {
        SerenityRest.given()
                .when()
                .get(apiUrl);
        responseCode = SerenityRest.then().extract().statusCode();
    }

    public static void sendPostRequest(String apiUrl, Map<String, String> requestBody) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(apiUrl);
        responseCode = SerenityRest.then().extract().statusCode();
    }

}
