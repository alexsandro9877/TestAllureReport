package org.example.Test;


import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.http.ContentType;
import org.example.utils.MontaPedido;
import org.example.utils.UrlUtils;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


@Feature("Criação da order.")
public class PostCreatedOrderTest  {

    String parceiro = "bees";
    String loja = "7490";



    @Test
    @Description("Deve criar pedido.")
    public void SholdCreateOrder() {
      //  Response response =
        given()
                .contentType(ContentType.JSON)
                .body(MontaPedido.Pedido("bees","7490"))
                .log().all()
                .post(UrlUtils.getBaseUrlWhiteLabel()+ "order/process")
                        .then()
                        .statusCode(201)
                        .log().all()
                       // .extract().response()
                ;
    }

    @Test
    @Description("Deve criar pedido.")
    public void SholdCreateOrder2() {

        System.out.println(MontaPedido.Pedido("bees","7490"));
             ;
    }




}