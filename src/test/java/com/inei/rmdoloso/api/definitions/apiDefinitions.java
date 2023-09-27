package com.inei.rmdoloso.api.definitions;

import com.inei.rmdoloso.api.utils.SerenityProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.inei.rmdoloso.api.utils.ApiUtils.responseCode;
import static com.inei.rmdoloso.api.utils.ApiUtils.sendGetRequest;
import static com.inei.rmdoloso.api.utils.EndPointList.getEndPoint;
import static com.inei.rmdoloso.api.utils.RetryTime.retryUntilTimeout;
import static org.assertj.core.api.Assertions.assertThat;


public class apiDefinitions {

    private String baseUrl;
    private String apiKey;

    @Given("the base URL is configured in serenity.properties")
    public void configureBaseUrl() {
        baseUrl = SerenityProperties
                .getProperty("base.url");
    }

    @When("I request the apk to download")
    public void requestCountryInformation() {
        //String endPoint = getEndPoint(apk);
        //String apiUrl = baseUrl + "APK" + "/" + apk;
        String apiUrl = "http://servicesrest2.inei.gob.pe/dir-webdoloso2023";
        sendGetRequest(apiUrl);
    }

    @Then("the response code should be {int}")
    public void verifyResponseCode(int expectedResponseCode) {
        assertThat(responseCode).isEqualTo(expectedResponseCode);
    }

}

