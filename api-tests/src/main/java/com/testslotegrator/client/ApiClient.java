package com.testslotegrator.client;

import com.testslotegrator.util.UiConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;

import java.util.Map;

import static io.restassured.http.ContentType.JSON;

public class ApiClient {

    public static UiConfig cfg = ConfigFactory.create(UiConfig.class);
    public RequestSpecBuilder getRequestSpecificationBuilder() {
        return new RequestSpecBuilder()
                .setBaseUri(cfg.baseUrl())
                .setBasePath(cfg.basePath())
                .addHeader("Accept", JSON.getAcceptHeader());
    }

    public RequestSpecification getRequestSpecification(Map<String, String> params) {
        return getRequestSpecificationBuilder().addParams(params).build();
    }

    public RequestSpecification getRequestSpecification() {
        return getRequestSpecificationBuilder().setContentType(JSON).build();
    }
}
