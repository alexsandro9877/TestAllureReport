package org.example.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParceiroCatalogoControllerCabecalhoLog {
    @Test
    public void test(){
        String codigoParceiro = "4";
        String codigoCatalogo = "1";
        String dataInicial = "2023-09-28";
        String dataFinal = "2023-09-31";

        String baseUrl ="http://prevenda-portal-whitelabel-api.micro.dev.gpa.net.br/api/parceiro/buscaCabecalhoCatalogoLog";
     Response response =  given()
                .when()
                .get(baseUrl+"/"+codigoParceiro+"/"+codigoCatalogo+"/"+dataInicial+"/"+dataFinal)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();

       //String tid = jsonPath.getString("modificacoes.boleto.tid");
       // Assert.assertNotNull(tid, "O campo 'tid' não está presente na resposta.");

        String matricula = jsonPath.getString("matricula");

        List<String> modificacoes = Collections.singletonList(jsonPath.getString("modificacoes"));
        assertThat(modificacoes, Matchers.hasSize(1));
        assertThat(matricula, Matchers.is("[TC021237]"));
        Assert.assertEquals("[[Inclus\u00F5es, Exclus\u00F5es, Lojas]]", modificacoes);
        String dataModificacao = jsonPath.getString("dataModificacao");

    System.out.println(modificacoes);
    }


}
