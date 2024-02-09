package com.bestbuy.cucumber.steps;

import com.bestbuy.steps.ProductSteps;
import com.bestbuy.steps.StoreSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;

public class MyStepdefs {
    static ValidatableResponse response;
    @Steps
    ProductSteps productSteps;
    @Steps
    StoreSteps storesSteps;


    @When("User sends GET request for all products endpoints.")
    public void userSendsGETRequestForAllProductsEndpoints() {
        response = storesSteps.getAllStores();

    }

    @Then("User gets the valid status code {int}")
    public void userGetsTheValidStatusCode(int statusCode) {
        response.statusCode(statusCode);

    }

    @When("User sends GET request for all stores endpoints")
    public void userSendsGETRequestForAllStoresEndpoints() {

        response = productSteps.getAllProducts();
    }

    @Then("User gets status code {int}")
    public void userGetsStatusCode(int statusCode1) {
        response.statusCode(statusCode1);
    }
    }

