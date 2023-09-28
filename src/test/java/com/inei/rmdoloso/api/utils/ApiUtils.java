package com.inei.rmdoloso.api.utils;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;
import java.util.Map;

public class ApiUtils {

    public static int responseCode;

    public static void sendGetRequest(String apiUrl) {
        SerenityRest.given().relaxedHTTPSValidation()
                .when()
                .get(apiUrl);
        responseCode = SerenityRest.then().extract().statusCode();
    }

    public static void sendPostRequest(String file, String apiUrl, Map<String, String> requestBody) {
        SerenityRest.given().relaxedHTTPSValidation()
                .contentType(ContentType.MULTIPART)
                .multiPart("uploaded_file", new File(file))
                .formParams(requestBody)
                .post(apiUrl);
        responseCode = SerenityRest.then().extract().statusCode();
    }

}
