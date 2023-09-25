package org.example.ImportarArquivo;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.*;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ImportCatalogo {
    @Test
    public void  deveFazerDowloadnDoCatalogo1(){
        given()
                .when()
                .get("http://prevenda-portal-whitelabel-api.servicos-hml.gpa.net.br/api/produtos/exportarCatalogoExcel/38/1/INCLUSAO")
                .then()
                .statusCode(200)
        ;
    }
    @Test
    public void deveFazerValidacaoDoArquivo(){
    given()
            .when()
            .log().all()
            .multiPart("ArquivoCatalogo", new File("C:\\TestAllureReport\\src\\test\\resources\\INCLUSAO.xlsx"))
            .contentType(ContentType.MULTIPART)
            .post("http://prevenda-portal-whitelabel-api.servicos-hml.gpa.net.br/api/produtos/importarCatalogoExcel")
            .then()
            .log().all()
            ;
    }
    @Test
    public void deveValidarNomeDoArquivo() throws IOException {
        Response response = given()
                .when()
                .get("http://prevenda-portal-whitelabel-api.servicos-hml.gpa.net.br/api/produtos/exportarCatalogoExcel/38/1/INCLUSAO")
                .then()
                .statusCode(200)
                .extract().response();

        assertThat(response.getHeader("Content-Length"),is(notNullValue()));
        assertThat(response.getHeader("Content-Disposition"),is(notNullValue()));
        assertThat(response.getHeader(" Content-Type"),is(notNullValue()));

// / Pegar o header da requisição que vem com o nome do arquivo
        String ContentDisposition = response.headers().getValue("Content-Disposition");

        //regex
        //valor para procurar
        Pattern pattern = Pattern.compile("filename=\"([^\"]+)\"");/// pegar o valor que esta entre este texto pos nao sei o que esta excrito
        //onde procurar
        Matcher matcher = pattern.matcher(ContentDisposition);

        //iniciar uma variavel  para receber o parametro
        String nomeDoArquivo = "";
        /// colocar o find para procurar no matcher, e o group para pegar o grupo(1)
        if (matcher.find()){
           nomeDoArquivo = matcher.group(1);
        }else{
            nomeDoArquivo = "";
        }
/// varrendo o nome do arquivo
    String[] nome = nomeDoArquivo.split("_");
      Assertions.assertTrue(nome[1].equals("INCLUSAO"));

    }
    @Test
    public void deveFazerDownloadDoCatalogoDeInclusao() throws IOException {
        Response response = given()
                .when()
                .get("http://prevenda-portal-whitelabel-api.servicos-hml.gpa.net.br/api/produtos/exportarCatalogoExcel/38/1/INCLUSAO")
                .then()
                .statusCode(200)
                .extract().response();

        assertThat(response.getHeader("Content-Length"),is(notNullValue()));
        assertThat(response.getHeader("Content-Disposition"),is(notNullValue()));
        assertThat(response.getHeader(" Content-Type"),is(notNullValue()));

        //// validando o corpo
        String contentDispositionHeader = response.getHeader("Content-Disposition");
        Pattern pattern = Pattern.compile("filename=\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(contentDispositionHeader);
        String fileName = "ArquivoCatalogo.xlsx"; // Nome padrão caso não possa ser extraído.
        if (matcher.find()) {
            fileName = matcher.group(1);
            String[] Nome = fileName.split("_");
            fileName = Nome[1].trim();
        }
        // inicia a criação do arquivo
        /// abrindo com o input
        InputStream inputStream = response.getBody().asInputStream();
        OutputStream outputStream = new FileOutputStream("C:\\TestAllureReport\\src\\test\\resources\\"+ fileName+".xlsx");

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        outputStream.close();
        inputStream.close();



    }








}
