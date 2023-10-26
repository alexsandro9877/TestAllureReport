package org.example.BaseTest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.FilterableRequestSpecification;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.requestSpecification;

public class BaseTest {


    public FilterableRequestSpecification req = (FilterableRequestSpecification) requestSpecification;
    @BeforeClass
    public static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        requestSpecification = reqBuilder.build();
        requestSpecification.contentType(ContentType.JSON);

    }


}