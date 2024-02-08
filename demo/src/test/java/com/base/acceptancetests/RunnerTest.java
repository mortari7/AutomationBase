package com.base.acceptancetests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"pretty"},
        glue = {"com.base"},
        features = "src/test/resources/features/base.feature"        
)
public class RunnerTest {
    
}
