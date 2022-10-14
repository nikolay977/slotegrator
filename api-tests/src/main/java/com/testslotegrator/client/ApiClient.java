package com.testslotegrator.client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.http.ContentType.JSON;

public class ApiClient {

    private static String BASE_URI = "http://test-api.d6.dev.devcaz.com";
    private static String BASE_PATH = "/v2";

    public RequestSpecBuilder getRequestSpecificationBuilder() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(BASE_PATH)
                .addHeader("Accept", JSON.getAcceptHeader());
    }

    public RequestSpecification getRequestSpecification(Map<String, String> params) {
        return getRequestSpecificationBuilder().addParams(params).build();
    }

    public RequestSpecification getRequestSpecification() {
        return getRequestSpecificationBuilder().setContentType(JSON).build();
    }
}
