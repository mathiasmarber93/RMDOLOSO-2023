package com.inei.rmdoloso.api;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.inei.rmdoloso.api.definitions",
        tags = "@API and @test1"
)
public class Runner {
}
