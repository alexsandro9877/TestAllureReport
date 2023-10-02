package org.example.Test;

import org.example.BaseTest.BaseTest;
import org.example.utils.MontaPedido;
import org.example.utils.UrlUtils;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CriarPedido extends BaseTest {
    String parceiro = "bees";
    String loja = "7490";

    @Test
    public void test(){

        given()
                .body(MontaPedido.Pedido(parceiro, loja))
                .when()
                .post(UrlUtils.getBaseUrlWhiteLabel()+ "order/process")
                .then()
                .statusCode(201)
                .log().all();
    }
}
