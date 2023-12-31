package com.inei.rmdoloso.api.definitions;

import com.inei.rmdoloso.api.utils.SerenityProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.SystemProperties;

import java.util.HashMap;

import static com.inei.rmdoloso.api.utils.ApiUtils.*;
import static com.inei.rmdoloso.api.utils.RetryTime.retryUntilTimeout;
import static org.assertj.core.api.Assertions.assertThat;


public class apiDefinitions {

    private String baseUrl;
    private static final String API_ENDPOINT = "api-webdoloso2023/api/";
    private static final String DIR_ENDPOINT = "dir-webdoloso2023/APK/";
    private static final String FILES_DIR = SystemProperties.getUserDir() + "/files/";

    @Given("la url esta configurada en serenity.properties")
    public void configureBaseUrl() {
        baseUrl = SerenityProperties
                .getProperty("base.url");
    }

    @When("hago la peticion GET al archivo {string} para la descarga")
    public void requestApkToDownload(String apk) {
        String apiUrl = baseUrl + DIR_ENDPOINT + apk;
        retryUntilTimeout(() -> sendGetRequest(apiUrl));
    }

    @When("hago la peticion GET de login para obtener el usuario {string} y la contraseña {string}")
    public void requestApiForLogin(String user, String pass) {
        String apiUrl = baseUrl + API_ENDPOINT + "login/"+ user + "/" + pass;
        retryUntilTimeout(() -> sendGetRequest(apiUrl));
        System.out.println(apiUrl);
    }

    @When("hago la peticion POST para transferir el archivo {string}")
    public void transferFiles(String file) {
        HashMap<String, String> requestBody = new HashMap<>();
        String files;
           if(file.equals("fsupmultitransferdata")){
               files = "file.fsupmultitransferdata";
           } else if(file.equals("fstrackingmultiple")){
               files = "file.fstrackingmultiple";
           } else {
               files = "file.fstrackingdetmultiple";
           }
            //Guard option - Map
        String zipFile = FILES_DIR + SerenityProperties.getProperty(files);
            requestBody.put("modoenvio", "MOVIL");
            requestBody.put("indexrural", "0");
            requestBody.put("evaluador", "MASTER1");
            String apiUrl = baseUrl + API_ENDPOINT + file;
            sendPostRequest(zipFile, apiUrl, requestBody);
    }

    @Then("el codigo de respuesta deberia ser {int}")
    public void verifyResponseCode(int expectedResponseCode) {
        assertThat(responseCode).isEqualTo(expectedResponseCode);
    }

}

