package com.bestbuy.steps;

import com.bestbuy.constant.Endpoints;
import com.bestbuy.model.StoreAPIRequest;
import com.bestbuy.model.StoresPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

public class StoreSteps {
    @Step("Creating product with name: {0}, type: {1}, address: {2}, address2: {3}, city: {4}, state: {5}, zip: {6}, lat: {7}, lng: {8} and hours{9}")
    public ValidatableResponse createStore(String name, String type, String address, String address2, String city,
                                           String state, String zip, String lat, String lng, String hours) {
        StoresPojo storesPojo = StoreAPIRequest.getAPIStoreRequest(name, type, address, address2, city, state, zip,
                lat, lng, hours);
        return SerenityRest.rest()
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .when()
                .body(storesPojo)
                .post(Endpoints.CREATE_STORES)
                .then().log().ifValidationFails();
    }

    @Step("Getting the store information with storeId: {0}")
    public ValidatableResponse getStoreById(int storeId) {
        return SerenityRest.rest()
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .pathParam("storeId", storeId)
                .when()
                .get(Endpoints.GET_STORES_BY_ID)
                .then().log().ifValidationFails();
    }

    @Step("Getting the all stores information")
    public ValidatableResponse getAllStores() {
        return SerenityRest.rest()
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .when()
                .get(Endpoints.GET_ALL_STORES)
                .then().log().ifValidationFails();
    }

    @Step("Updating store information with storeId: {0}")
    public ValidatableResponse updateStore(int storeId, String name, String type, String address, String address2,
                                           String city, String state, String zip, String lat, String lng, String hours) {

        StoresPojo storesPojo = StoreAPIRequest.getAPIStoreRequest(name, type, address, address2, city, state, zip,
                lat, lng, hours);

        return SerenityRest.rest()
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .pathParam("storeId", storeId)
                .when()
                .body(storesPojo)
                .patch(Endpoints.UPDATE_STORES_BY_ID)
                .then().log().ifValidationFails();
    }

    @Step("Deleting product information with storeId: {0}")
    public ValidatableResponse deleteStore(int storeId) {
        return SerenityRest.rest()
                .given()
                .log()
                .all()
                .pathParam("storeId", storeId)
                .when()
                .delete(Endpoints.DELETE_STORES_BY_ID)
                .then().log().ifValidationFails();
    }

    @Step("Send request to invalid endpoint")
    public ValidatableResponse sendRequestToInvalidEndpoint() {
        return SerenityRest.rest()
                .given()
                .log()
                .all()
                .when()
                .delete(Endpoints.INVALID_ENDPOINT_STORE)
                .then();
    }
}
