package org.example.exportacaoPedidos;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class DownloadPedidos {

    @Test
    public void deveBaixarArquivoDePedidos() throws IOException {
        Response response = given()
                .body("{\n" +
                        "  \"dataIntegracaoFinal\": \"\",\n" +
                        "  \"dataIntegracaoInicio\": \"\",\n" +
                       // "  \"dataLeituraFinal\": \"2023/09/12T14:26:09.431-0300\",\n" +
                     //   "  \"dataLeituraInicio\": \"2020/09/12T01:26:09.431-0300\",\n" +
                         "  \"dataLeituraFinal\": \"2023/09/22T14:26:09.431-0300\",\n" +
                         "  \"dataLeituraInicio\": \"2023/09/01T01:26:09.431-0300\",\n" +
                        "  \"nomeParceiro\": \"\",\n" +
                        "  \"pedido\": \"\",\n" +
                        "  \"pedidoParceiro\": \"\",\n" +
                        "  \"pedidoSA\": \"\",\n" +
                        "  \"statusGPA\": \"\",\n" +
                        "  \"statusParceiro\": \"\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                .post("http://prevenda-portal-whitelabel-api.servicos-hml.gpa.net.br/painelParceiros/exportarCsvPedidos")
                .then()
                .statusCode(200)
                .extract().response();

        String csvDownload = response.asString();

        // Salvando o CSV em um arquivo
        String filePath = "C:\\TestAllureReport\\src\\test\\resources\\ARQUIVO_PEDIDOS.csv";
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(csvDownload);
        fileWriter.close();

        // Validar o cabeçalho do CSV
        String[] linhasCSV = csvDownload.split("\n");
        String cabecalho = linhasCSV[0].trim(); // trim remove os espaços

        assertThat(cabecalho, containsString("Pedido"));
        // Adicione verificações para outras colunas do cabeçalho, se necessário
    }
}
