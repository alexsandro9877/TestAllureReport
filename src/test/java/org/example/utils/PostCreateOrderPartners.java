package org.example.utils;


import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostCreateOrderPartners {


    public Response bodyPartPartner(String parceiro , String loja){
        CreateOrder Order = new CreateOrder(parceiro, loja);
        return  given()
                .body(Order.Pedido())
                .when()
                .post(UrlUtils.getBaseUrlWhiteLabel()+ "order/process")

                ;

    }



}
